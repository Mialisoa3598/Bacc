// Graphique fromage Chart.js — Statistique par status
function initChart(labels, data) {
    const ctx = document.getElementById("chartStatus").getContext("2d");
    new Chart(ctx, {
        type: "pie",
        data: {
            labels: labels,
            datasets: [{
                data: data,
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: "bottom"
                },
                tooltip: {
                    callbacks: {
                        label: function(context) {
                            return context.label + " : " + context.raw + " demande(s)";
                        }
                    }
                }
            },
            onClick: function(event, elements) {
                if (elements.length > 0) {
                    const index = elements[0].index;
                    const idStatus = statusIds[index];
                    window.location.href = "/dashboard/status/" + idStatus;
                }
            }
        }
    });
}