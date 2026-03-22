<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="com.example.forage.model.Client" %>
<%@ page import="java.util.List" %>
<%
    List<Demande> demandeList = (List<Demande>) request.getAttribute("demandes");
    List<Client> clientList = (List<Client>) request.getAttribute("clients");
%>
<html>
<head><title>Demandes</title></head>
<body>
    <h1>Liste des Demandes</h1>
    <a href="/demandes/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Client</th>
            <th>Date</th>
            <th>Lieu</th>
            <th>District</th>
            <th>Actions</th>
        </tr>
        <% for (Demande d : demandeList) { %>
        <tr>
            <td><%= d.getId() %></td>
            <td><%= d.getClient().getNom() %></td>
            <td><%= d.getDate() %></td>
            <td><%= d.getLieu() %></td>
            <td><%= d.getDistrict() %></td>
            <td>
                <a href="/demandes/edit/<%= d.getId() %>">Modifier</a>
                <a href="/demandes/delete/<%= d.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>