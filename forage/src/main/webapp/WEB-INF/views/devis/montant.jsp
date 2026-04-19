<%-- <%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.DetailDevis" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%
    BigDecimal montantTotal = (BigDecimal) request.getAttribute("montantTotal");
%>
<html>
<head><title>Montant Devis</title></head>
<body>
    <%= montantTotal %>
    <a href="/devis">Retour</a>
</body>
</html> --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="com.example.forage.model.DetailDevis" %>

<%
    Devis devis = (Devis) request.getAttribute("devis");
%>

<html>
<head>
    <title>Montant Devis</title>
    <script src="/js/devis.js"></script>
</head>
<body>

    <h1>Detail Montant — <%= devis.getTypeDevis().getLibelle() %></h1>

    <p>Client : <%= devis.getDemande().getClient().getNom() %></p>
    <p>Lieu : <%= devis.getDemande().getLieu() %></p>

    <table border="1" id="tableDetails">
        <tr>
            <th>Libelle</th>
            <th>PU</th>
            <th>Qte</th>
            <th>Montant</th>
        </tr>

        <% for (DetailDevis dd : devis.getDetailDevis()) { %>
        <tr>
            <td><%= dd.getLibelle() %></td>

            <!-- IMPORTANT : inputs pour que JS puisse lire -->
            <td>
                <input type="number" name="pus" value="<%= dd.getPu() %>" readonly>
            </td>

            <td>
                <input type="number" name="qtes" value="<%= dd.getQte() %>" readonly>
            </td>

            <td class="montantLigne">0 Ar</td>
        </tr>
        <% } %>

        <tr>
            <td colspan="3"><strong>Total</strong></td>
            <td><strong id="montantTotal">0 Ar</strong></td>
        </tr>
    </table>

    <br>
    <a href="/devis">Retour</a>

</body>
</html>