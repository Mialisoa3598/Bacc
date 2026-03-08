<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Operateur" %>
<%@ page import="java.util.List" %>
<%
    List<Operateur> operateurs = (List<Operateur>) request.getAttribute("operateurs");
%>
<html>
<head><title>Operateurs</title></head>
<body>
    <h1>Liste des Operateurs</h1>
    <a href="/operateurs/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Operateur</th>
            <th>Actions</th>
        </tr>
        <% for (Operateur o : operateurs) { %>
        <tr>
            <td><%= o.getId() %></td>
            <td><%= o.getOperateur() %></td>
            <td>
                <a href="/operateurs/edit/<%= o.getId() %>">Modifier</a>
                <a href="/operateurs/delete/<%= o.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>