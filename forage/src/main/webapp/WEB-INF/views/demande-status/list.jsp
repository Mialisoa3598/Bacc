<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.DemandeStatus" %>
<%@ page import="java.util.List" %>
<%
    List<DemandeStatus> demandeStatuts = (List<DemandeStatus>) request.getAttribute("demandeStatuts");
%>
<html>
<head><title>Demande Status</title></head>
<body>
    <h1>Liste des Demande Status</h1>
    <a href="/demande-status/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Demande</th>
            <th>Status</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        <% for (DemandeStatus ds : demandeStatuts) { %>
        <tr>
            <td><%= ds.getId() %></td>
            <td><%= ds.getDemande().getClient().getNom() %> - <%= ds.getDemande().getLieu() %></td>
            <td><%= ds.getStatus().getLibelle() %></td>
            <td><%= ds.getDate() %></td>
            <td>
                <a href="/demande-status/edit/<%= ds.getId() %>">Modifier</a>
                <a href="/demande-status/delete/<%= ds.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>