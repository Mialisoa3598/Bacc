<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="com.example.forage.model.Status" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="java.util.List" %>
<%
    Demande demande = (Demande) request.getAttribute("demande");
    Status status = (Status) request.getAttribute("status");
    List<Devis> devisList = (List<Devis>) request.getAttribute("devis");
%>
<html>
<head><title>Devis</title></head>
<body>
    <p>
        <a href="/dashboard">Dashboard</a> &gt;
        <a href="/dashboard/status/<%= status.getId() %>">Status "<%= status.getLibelle() %>"</a> &gt;
        Demande <%= demande.getLieu() %>
    </p>

    <h1>Devis — <%= demande.getLieu() %></h1>
    <p>Client :
        <a href="/dashboard/clients/<%= demande.getClient().getId() %>">
            <%= demande.getClient().getNom() %>
        </a>
    </p>

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
                <a href="/dashboard/devis/<%= d.getId() %>">Voir Detail</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
