function loadDemande(idDemande) {
    if (!idDemande) {
        document.getElementById("infoDemande").style.display = "none";
        return;
    }
    fetch("/api/demandes/" + idDemande)
        .then(response => response.json())
        .then(data => {
            document.getElementById("clientNom").innerText = data.client.nom;
            document.getElementById("lieu").innerText = data.lieu;
            document.getElementById("district").innerText = data.district;
            document.getElementById("infoDemande").style.display = "block";
        })
        .catch(error => {
            console.error("Erreur AJAX : ", error);
        });
}

function ajouterLigne() {
    const table = document.getElementById("tableDetails");
    const row = table.insertRow();
    row.innerHTML = `
        <td><input type="text" name="libelles" required/></td>
        <td><input type="number" name="pus" step="0.01" oninput="calculerMontant(this)" required/></td>
        <td><input type="number" name="qtes" min="1" oninput="calculerMontant(this)" required/></td>
        <td class="montantLigne">0 Ar</td>
        <td><button type="button" onclick="supprimerLigne(this)">X</button></td>
    `;
}

function supprimerLigne(btn) {
    const row = btn.closest("tr");
    row.remove();
    calculerTotal();
}

function calculMontantLigne(row) {
    const pu = parseFloat(row.querySelector("[name='pus']").value) || 0;
    const qte = parseInt(row.querySelector("[name='qtes']").value) || 0;

    // Remise de 10% si PU >= 1 000 000
    const puFinal = pu >= 1000000 ? pu * 0.9 : pu;

    return puFinal * qte;
}

function calculerMontant(input) {
    const row = input.closest("tr");

    let pu = parseFloat(row.querySelector("[name='pus']").value) || 0;
    let qte = parseInt(row.querySelector("[name='qtes']").value) || 0;

    // remise simple
    if (pu >= 1000000) {
        pu = pu * 0.9;
    }

    let montant = pu * qte;

    row.querySelector(".montantLigne").innerText = montant + " Ar";

    calculerTotal();
}

function calculerTotal() {
    const rows = document.querySelectorAll("#tableDetails tr:not(:first-child)");
    let total = 0;

    rows.forEach(row => {
        let pu = parseFloat(row.querySelector("[name='pus']").value) || 0;
        let qte = parseInt(row.querySelector("[name='qtes']").value) || 0;

        // même logique de remise
        if (pu >= 1000000) {
            pu = pu * 0.9;
        }

        total += pu * qte;
    });

    document.getElementById("montantTotal").innerText = total + " Ar";
}


// function calculerMontant(input) {
//     const row = input.closest("tr");
//     const pu = parseFloat(row.querySelector("[name='pus']").value) || 0;
//     const qte = parseInt(row.querySelector("[name='qtes']").value) || 0;
//     row.querySelector(".montantLigne").innerText = (pu * qte).toLocaleString() + " Ar";
//     calculerTotal();
// }

// function calculerTotal() {
//     const rows = document.querySelectorAll("#tableDetails tr:not(:first-child)");
//     let total = 0;
//     rows.forEach(row => {
//         const pu = parseFloat(row.querySelector("[name='pus']").value) || 0;
//         const qte = parseInt(row.querySelector("[name='qtes']").value) || 0;
//         total += pu * qte;
//     });
//     document.getElementById("montantTotal").innerText = total.toLocaleString();
// }

window.onload = function () {
    calculerTotal();
};