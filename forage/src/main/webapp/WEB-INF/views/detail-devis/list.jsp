<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.DetailDevis" %>
<%@ page import="java.util.List" %>
<%
    List<DetailDevis> detailDevisList = (List<DetailDevis>) request.getAttribute("detailDevis");
%>
<html>
<head><title>Detail Devis</title></head>
<body>
    <h1>Liste des Detail Devis</h1>
    <a href="/detail-devis/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Libelle</th>
            <th>Montant</th>
            <th>Devis</th>
            <th>Actions</th>
        </tr>
        <% for (DetailDevis dd : detailDevisList) { %>
        <tr>
            <td><%= dd.getId() %></td>
            <td><%= dd.getLibelle() %></td>
            <td><%= dd.getMontant() %></td>
            <td><%= dd.getDevis().getDemande().getClient().getNom() %> - <%= dd.getDevis().getTypeDevis().getLibelle() %></td>
            <td>
                <a href="/detail-devis/edit/<%= dd.getId() %>">Modifier</a>
                <a href="/detail-devis/delete/<%= dd.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>