<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Status" %>
<%@ page import="java.util.List" %>
<%
    List<Status> statuts = (List<Status>) request.getAttribute("statuts");
%>
<html>
<head><title>Statuts</title></head>
<body>
    <h1>Liste des Statuts</h1>
    <a href="/status/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Libelle</th>
            <th>Actions</th>
        </tr>
        <% for (Status s : statuts) { %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getLibelle() %></td>
            <td>
                <a href="/status/edit/<%= s.getId() %>">Modifier</a>
                <a href="/status/delete/<%= s.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>