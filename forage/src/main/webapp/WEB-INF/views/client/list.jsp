<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Client" %>
<%@ page import="java.util.List" %>
<%
    List<Client> clients = (List<Client>) request.getAttribute("clients");
%>
<html>
<head><title>Clients</title></head>
<body>
    <h1>Liste des Clients</h1>
    <a href="/clients/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Contact</th>
            <th>Actions</th>
        </tr>
        <% for (Client c : clients) { %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNom() %></td>
            <td><%= c.getContact() %></td>
            <td>
                <a href="/clients/edit/<%= c.getId() %>">Modifier</a>
                <a href="/clients/delete/<%= c.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>