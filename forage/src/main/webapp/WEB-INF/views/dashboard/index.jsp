<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Status" %>
<%@ page import="com.example.forage.model.DemandeStatus" %>
<%@ page import="java.util.List" %>
<%
    List<Status> statuts = (List<Status>) request.getAttribute("statuts");
    List<DemandeStatus> demandeStatuts = (List<DemandeStatus>) request.getAttribute("demandeStatuts");
    Double chiffreAffaire = (Double) request.getAttribute("chiffreAffaire");
    Integer nbClients = (Integer) request.getAttribute("nbClients");
    Integer nbDevis = (Integer) request.getAttribute("nbDevis");
%>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <p><a href="/dashboard">Dashboard</a></p>
    <h1>Tableau de Bord</h1>

    <table border="1">
        <tr>
            <td><a href="/dashboard/clients"><h3>Nombre de Clients</h3><p><%= nbClients %></p></a></td>
            <td><a href="/dashboard/devis"><h3>Nombre de Devis</h3><p><%= nbDevis %></p></a></td>
            <td><a href="/dashboard/chiffre-affaire"><h3>Chiffre d'Affaire</h3><p><%= chiffreAffaire %> Ar</p></a></td>
            <td><a href="#chartSection"><h3>Statistique par Status</h3></a></td>
        </tr>
    </table>

    <br/>

    <div id="chartSection">
        <h2>Statistique par Status</h2>
        <canvas id="chartStatus" width="400" height="400"></canvas>
    </div>

    <%-- 1. Chart.js CDN --%>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <%-- 2. dashboard.js qui definit initChart() --%>
    <script src="/js/dashboard.js"></script>

    <%-- 3. Script inline qui appelle initChart() avec les donnees Java --%>
    <script>
        const statusIds = [
            <% for (int i = 0; i < statuts.size(); i++) { %>
                <%= statuts.get(i).getId() %><%= i < statuts.size() - 1 ? "," : "" %>
            <% } %>
        ];

        const labels = [
            <% for (int i = 0; i < statuts.size(); i++) { %>
                "<%= statuts.get(i).getLibelle() %>"<%= i < statuts.size() - 1 ? "," : "" %>
            <% } %>
        ];

        const data = [
            <% for (int i = 0; i < statuts.size(); i++) {
                Status s = statuts.get(i);
                long count = demandeStatuts.stream()
                    .filter(ds -> ds.getStatus().getId().equals(s.getId()))
                    .count();
            %>
                <%= count %><%= i < statuts.size() - 1 ? "," : "" %>
            <% } %>
        ];

        initChart(labels, data);
    </script>
</body>
</html>