<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.TypeDevis" %>
<%@ page import="java.util.List" %>
<%
    List<TypeDevis> typeDevisList = (List<TypeDevis>) request.getAttribute("typesDevis");
%>
<html>
<head><title>Types de Devis</title></head>
<body>
    <h1>Liste des Types de Devis</h1>
    <a href="/typeDevis/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Libelle</th>
            <th>Actions</th>
        </tr>
        <% for (TypeDevis t : typeDevisList) { %>
        <tr>
            <td><%= t.getId() %></td>
            <td><%= t.getLibelle() %></td>
            <td>
                <a href="/typeDevis/edit/<%= t.getId() %>">Modifier</a>
                <a href="/typeDevis/delete/<%= t.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>