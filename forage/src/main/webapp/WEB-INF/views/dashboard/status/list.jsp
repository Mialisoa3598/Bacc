<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="com.example.forage.model.Status" %>
<%@ page import="java.util.List" %>
<%
    List<Demande> demandes = (List<Demande>) request.getAttribute("demandes");
    Status status = (Status) request.getAttribute("status");
%>
<html>
<head><title>Demandes par Status</title></head>
<body>
    <p>
        <a href="/dashboard">Dashboard</a> &gt;
        Status "<%= status.getLibelle() %>"
    </p>

    <h1>Demandes — <%= status.getLibelle() %></h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Client</th>
            <th>Lieu</th>
            <th>District</th>
            <th>Actions</th>
        </tr>
        <% for (Demande d : demandes) { %>
        <tr>
            <td><%= d.getId() %></td>
            <td>
                <a href="/dashboard/clients/<%= d.getClient().getId() %>">
                    <%= d.getClient().getNom() %>
                </a>
            </td>
            <td><%= d.getLieu() %></td>
            <td><%= d.getDistrict() %></td>
            <td>
                <a href="/dashboard/status/<%= status.getId() %>/demandes/<%= d.getId() %>">
                    Voir Devis
                </a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>