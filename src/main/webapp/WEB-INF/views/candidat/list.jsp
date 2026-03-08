<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Candidat" %>
<%@ page import="java.util.List" %>
<%
    List<Candidat> candidats = (List<Candidat>) request.getAttribute("candidats");
%>
<html>
<head><title>Candidats</title></head>
<body>
    <h1>Liste des Candidats</h1>
    <a href="/candidats/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Actions</th>
        </tr>
        <% for (Candidat c : candidats) { %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNom() %></td>
            <td>
                <a href="/candidats/edit/<%= c.getId() %>">Modifier</a>
                <a href="/candidats/delete/<%= c.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>