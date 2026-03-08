<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Correcteur" %>
<%@ page import="java.util.List" %>
<%
    List<Correcteur> correcteurs = (List<Correcteur>) request.getAttribute("correcteurs");
%>
<html>
<head><title>Correcteurs</title></head>
<body>
    <h1>Liste des Correcteurs</h1>
    <a href="/correcteurs/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Actions</th>
        </tr>
        <% for (Correcteur c : correcteurs) { %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNom() %></td>
            <td>
                <a href="/correcteurs/edit/<%= c.getId() %>">Modifier</a>
                <a href="/correcteurs/delete/<%= c.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>