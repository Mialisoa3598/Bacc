<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Matiere" %>
<%@ page import="java.util.List" %>
<%
    List<Matiere> matieres = (List<Matiere>) request.getAttribute("matieres");
%>
<html>
<head><title>Matieres</title></head>
<body>
    <h1>Liste des Matieres</h1>
    <a href="/matieres/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Actions</th>
        </tr>
        <% for (Matiere m : matieres) { %>
        <tr>
            <td><%= m.getId() %></td>
            <td><%= m.getNom() %></td>
            <td>
                <a href="/matieres/edit/<%= m.getId() %>">Modifier</a>
                <a href="/matieres/delete/<%= m.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>