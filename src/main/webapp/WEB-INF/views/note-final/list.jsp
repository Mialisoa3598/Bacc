<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.NoteFinal" %>
<%@ page import="java.util.List" %>
<%
    List<NoteFinal> notesFinals = (List<NoteFinal>) request.getAttribute("notesFinals");
%>
<html>
<head><title>Notes Finales</title></head>
<body>
    <h1>Liste des Notes Finales - ETU3598</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Matiere</th>
            <th>Candidat</th>
            <th>Note Finale</th>
        </tr>
        <% for (NoteFinal n : notesFinals) { %>
        <tr>
            <td><%= n.getId() %></td>
            <td><%= n.getMatiere().getNom() %></td>
            <td><%= n.getCandidat().getNom() %></td>
            <td><%= n.getNote() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>