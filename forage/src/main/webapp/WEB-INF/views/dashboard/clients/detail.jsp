<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Client" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="java.util.List" %>
<%
    Client client = (Client) request.getAttribute("client");
    List<Demande> demandes = (List<Demande>) request.getAttribute("demandes");
%>
<html>
<head><title>Detail Client</title></head>
<body>
    <%-- Fil d'Ariane --%>
    <p>
        <a href="/dashboard">Dashboard</a> &gt;
        <a href="/dashboard/clients">Clients</a> &gt;
        <%= client.getNom() %>
    </p>

    <h1>Detail Client — <%= client.getNom() %></h1>
    <p>Contact : <%= client.getContact() %></p>

    <h2>Ses Demandes</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Lieu</th>
            <th>District</th>
            <th>Date</th>
            <th>Actions</th>
        </tr>
        <% for (Demande d : demandes) { %>
        <tr>
            <td><%= d.getId() %></td>
            <td><%= d.getLieu() %></td>
            <td><%= d.getDistrict() %></td>
            <td><%= d.getDate() %></td>
            <td>
                <a href="/dashboard/clients/<%= client.getId() %>/demandes/<%= d.getId() %>">Voir Devis</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>