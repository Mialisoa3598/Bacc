<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Client" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="java.util.List" %>
<%
    Client client = (Client) request.getAttribute("client");
    Demande demande = (Demande) request.getAttribute("demande");
    List<Devis> devisList = (List<Devis>) request.getAttribute("devis");
%>
<html>
<head><title>Devis de la Demande</title></head>
<body>
    <%-- Fil d'Ariane --%>
    <p>
        <a href="/dashboard">Dashboard</a> &gt;
        <a href="/dashboard/clients">Clients</a> &gt;
        <a href="/dashboard/clients/<%= client.getId() %>"><%= client.getNom() %></a> &gt;
        Demande <%= demande.getLieu() %>
    </p>

    <h1>Devis — <%= demande.getLieu() %></h1>
    <p>Client : <%= client.getNom() %></p>
    <p>District : <%= demande.getDistrict() %></p>

    <h2>Liste des Devis</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Type Devis</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        <% for (Devis d : devisList) { %>
        <tr>
            <td><%= d.getId() %></td>
            <td><%= d.getTypeDevis().getLibelle() %></td>
            <td><%= d.getDate() %></td>
            <td>
                <a href="/dashboard/clients/<%= client.getId() %>/demandes/<%= demande.getId() %>/devis/<%= d.getId() %>">Voir Detail</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>