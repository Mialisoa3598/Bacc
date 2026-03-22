<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="com.example.forage.model.TypeDevis" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="java.util.List" %>
<%
    List<Devis> devisList = (List<Devis>) request.getAttribute("devis");
%>
<html>
<head><title>Devis</title></head>
<body>
    <h1>Liste des Devis</h1>
    <a href="/devis/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>TypeDevis</th>
            <th>Demande</th>
            <th>Actions</th>
        </tr>
        <% for (Devis d : devisList) { %>
        <tr>
            <td><%= d.getId() %></td>
            <td><%= d.getTypeDevis().getLibelle() %></td>
            <td><%= d.getDemande().getClient().getNom() %></td>
            <td>
                <a href="/devis/edit/<%= d.getId() %>">Modifier</a>
                <a href="/devis/delete/<%= d.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>