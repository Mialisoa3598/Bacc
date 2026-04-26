<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.DetailDevis" %>
<%@ page import="java.util.List" %>
<%
    List<DetailDevis> details = (List<DetailDevis>) request.getAttribute("details");
    Double total = (Double) request.getAttribute("total");
%>
<html>
<head><title>Chiffre d'Affaire</title></head>
<body>
    <p>
        <a href="/dashboard">Dashboard</a> &gt;
        Chiffre d'Affaire
    </p>

    <h1>Chiffre d'Affaire</h1>

    <table border="1">
        <tr>
            <th>Libelle</th>
            <th>P.U</th>
            <th>Qte</th>
            <th>Montant</th>
            <th>Client</th>
            <th>Type Devis</th>
        </tr>
        <% for (DetailDevis dd : details) { %>
        <tr>
            <td><%= dd.getLibelle() %></td>
            <td><%= dd.getPu() %></td>
            <td><%= dd.getQte() %></td>
            <td><%= dd.getPu() * dd.getQte() %> Ar</td>
            <td>
                <a href="/dashboard/clients/<%= dd.getDevis().getDemande().getClient().getId() %>">
                    <%= dd.getDevis().getDemande().getClient().getNom() %>
                </a>
            </td>
            <td><%= dd.getDevis().getTypeDevis().getLibelle() %></td>
        </tr>
        <% } %>
        <tr>
            <td colspan="3"><strong>Total CA</strong></td>
            <td><strong><%= total %> Ar</strong></td>
            <td colspan="2"></td>
        </tr>
    </table>
</body>
</html>