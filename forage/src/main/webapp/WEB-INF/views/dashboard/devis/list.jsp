<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="java.util.List" %>
<%
    List<Devis> devisList = (List<Devis>) request.getAttribute("devis");
%>
<html>
<head><title>Devis</title></head>
<body>
    <p>
        <a href="/dashboard">Dashboard</a> &gt;
        Devis
    </p>
    <h1>Liste des Devis</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Type</th>
            <th>Client</th>
            <th>Lieu</th>
            <th>Actions</th>
        </tr>
        <% for (Devis d : devisList) { %>
        <tr>
            <td><%= d.getId() %></td>
            <td><%= d.getTypeDevis().getLibelle() %></td>
            <td><%= d.getDemande().getClient().getNom() %></td>
            <td><%= d.getDemande().getLieu() %></td>
            <td>
                <a href="/dashboard/devis/<%= d.getId() %>">Voir détail</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>