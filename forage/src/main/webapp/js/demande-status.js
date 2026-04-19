function formatDate(dateStr) {
    return dateStr.replace("T", " ");
}

// AJAX : charger l'historique de la demande selectionnee
function loadHistorique(idDemande) {
    if (!idDemande) {
        document.getElementById("historique").style.display = "none";
        return;
    }
    fetch("/api/demande-status/" + idDemande)
        .then(response => response.json())
        .then(data => {
            const tbody = document.getElementById("tbodyHistorique");
            tbody.innerHTML = "";
            data.forEach(ds => {
                const tr = document.createElement("tr");
            
                tr.innerHTML = `
                    <td>${ds.status.libelle}</td>
                    <td>
                        <input type="datetime-local" id="date_${ds.id}" 
                            value="${ds.date.substring(0, 16)}"/>
                    </td>
                    <td>
                        <input type="text" id="obs_${ds.id}" 
                            value="${ds.observation != null ? ds.observation : ''}"/>
                    </td>
                    <td>
                        <button type="button" onclick="updateStatus(${ds.id})">
                            Enregistrer
                        </button>
                    </td>
                `;
                tbody.appendChild(tr);
            });
            document.getElementById("historique").style.display = "block";
        })
        .catch(error => console.error("Erreur AJAX : ", error));
}

// AJAX : modifier observation et date d'un DemandeStatus
function updateStatus(id) {
    const observation = document.getElementById("obs_" + id).value;
    const date = document.getElementById("date_" + id).value;

    const formData = new FormData();
    formData.append("id", id);
    formData.append("observation", observation);
    formData.append("date", date);

    fetch("/demande-status/gestion/update", {
        method: "POST",
        body: formData
    })
    .then(response => {
        if (response.ok) {
            alert("Mis a jour avec succes !");
        }
    })
    .catch(error => console.error("Erreur update : ", error));
}