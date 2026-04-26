<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="com.example.forage.model.Status" %>
<%@ page import="java.util.List" %>
<%
    List<Demande> demandes = (List<Demande>) request.getAttribute("demandes");
    Status status = (Status) request.getAttribute("status");
%>
<html>
<head><title>Demandes par Status</title></head>
<body>

    <%-- Fil d'Ariane --%>
    <p>
        <a href="/dashboard">Dashboard</a> &gt;
        Statut "<%= status.getLibelle() %>"
    </p>

    <h1>Demandes avec status : <%= status.getLibelle() %></h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Client</th>
            <th>Lieu</th>
            <th>District</th>
            <th>Actions</th>
        </tr>
        <% for (Demande d : demandes) { %>
        <tr>
            <td><%= d.getId() %></td>
            <td><%= d.getClient().getNom() %></td>
            <td><%= d.getLieu() %></td>
            <td><%= d.getDistrict() %></td>
            <td>
                <a href="/devis/demande/<%= d.getId() %>">Voir Devis</a>
            </td>
        </tr>
        <% } %>
    </table>

    <a href="/dashboard">Retour Dashboard</a>
</body>
</html>