<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Resolution" %>
<%@ page import="java.util.List" %>
<%
    List<Resolution> resolutions = (List<Resolution>) request.getAttribute("resolutions");
%>
<html>
<head><title>Resolutions</title></head>
<body>
    <h1>Liste des Resolutions</h1>
    <a href="/resolutions/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Actions</th>
        </tr>
        <% for (Resolution r : resolutions) { %>
        <tr>
            <td><%= r.getId() %></td>
            <td><%= r.getNom() %></td>
            <td>
                <a href="/resolutions/edit/<%= r.getId() %>">Modifier</a>
                <a href="/resolutions/delete/<%= r.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>