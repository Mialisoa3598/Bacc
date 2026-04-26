<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="com.example.forage.model.Client" %>
<%@ page import="com.example.forage.model.DetailDevis" %>
<%@ page import="java.util.List" %>
<%
    Devis devis = (Devis) request.getAttribute("devis");
    Client client = (Client) request.getAttribute("client");
    List<DetailDevis> details = devis.getDetailDevis();
%>
<html>
<head><title>Detail Devis</title></head>
<body>
    <p>
        <a href="/dashboard">Dashboard</a> &gt;
        <a href="/dashboard/devis">Devis</a> &gt;
        <%= devis.getTypeDevis().getLibelle() %>
    </p>

    <h1>Detail Devis — <%= devis.getTypeDevis().getLibelle() %></h1>
    <p>Client : <a href="/dashboard/clients/<%= client.getId() %>"><%= client.getNom() %></a></p>
    <p>Lieu : <%= devis.getDemande().getLieu() %></p>

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