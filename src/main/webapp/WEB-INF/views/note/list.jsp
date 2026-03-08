<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Note" %>
<%@ page import="java.util.List" %>
<%
    List<Note> notes = (List<Note>) request.getAttribute("notes");
%>
<html>
<head><title>Notes</title></head>
<body>
    <h1>Liste des Notes</h1>
    <a href="/notes/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Matiere</th>
            <th>Candidat</th>
            <th>Correcteur</th>
            <th>Note</th>
            <th>Actions</th>
        </tr>
        <% for (Note n : notes) { %>
        <tr>
            <td><%= n.getId() %></td>
            <td><%= n.getMatiere().getNom() %></td>
            <td><%= n.getCandidat().getNom() %></td>
            <td><%= n.getCorrecteur().getNom() %></td>
            <td><%= n.getNote() %></td>
            <td>
                <a href="/notes/edit/<%= n.getId() %>">Modifier</a>
                <a href="/notes/delete/<%= n.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>