<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Client" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="com.example.forage.model.DetailDevis" %>
<%@ page import="java.util.List" %>
<%
    Client client = (Client) request.getAttribute("client");
    Demande demande = (Demande) request.getAttribute("demande");
    Devis devis = (Devis) request.getAttribute("devis");
    List<DetailDevis> details = devis.getDetailDevis();
%>
<html>
<head><title>Detail Devis</title></head>
<body>
    <%-- Fil d'Ariane --%>
    <p>
        <a href="/dashboard">Dashboard</a> &gt;
        <a href="/dashboard/clients">Clients</a> &gt;
        <a href="/dashboard/clients/<%= client.getId() %>"><%= client.getNom() %></a> &gt;
        <a href="/dashboard/clients/<%= client.getId() %>/demandes/<%= demande.getId() %>">Demande <%= demande.getLieu() %></a> &gt;
        Devis <%= devis.getTypeDevis().getLibelle() %>
    </p>

    <h1>Detail Devis — <%= devis.getTypeDevis().getLibelle() %></h1>
    <p>Client : <%= client.getNom() %></p>
    <p>Lieu : <%= demande.getLieu() %></p>

    <table border="1">
        <tr>
            <th>Libelle</th>
            <th>P.U</th>
            <th>Qte</th>
            <th>Montant</th>
        </tr>
        <% double total = 0; %>
        <% for (DetailDevis dd : details) {
            double montant = dd.getPu() * dd.getQte();
            total += montant;
        %>
        <tr>
            <td><%= dd.getLibelle() %></td>
            <td><%= dd.getPu() %></td>
            <td><%= dd.getQte() %></td>
            <td><%= montant %> Ar</td>
        </tr>
        <% } %>
        <tr>
            <td colspan="3"><strong>Total</strong></td>
            <td><strong><%= total %> Ar</strong></td>
        </tr>
    </table>
</body>
</html>