<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="com.example.forage.model.TypeDevis" %>
<%@ page import="java.util.List" %>
<%
    Devis devis = (Devis) request.getAttribute("devis");
    List<Demande> demandeList = (List<Demande>) request.getAttribute("demandes");
    List<TypeDevis> typeDevisList = (List<TypeDevis>) request.getAttribute("typeDevis");
%>
<html>
<head>
    <title>Devis</title>
</head>
<body>
    <h1><%= devis.getId() == null ? "Ajouter" : "Modifier" %> Devis</h1>
    <form action="/devis/save" method="post" id="formDevis">
        <input type="hidden" name="id" value="<%= devis.getId() == null ? 0 : devis.getId() %>"/>

        Demande :
        <select name="idDemande" id="selectDemande" onchange="loadDemande(this.value)" required>
            <option value="">Selectionner une demande</option>
            <% for (Demande d : demandeList) { %>
                <option value="<%= d.getId() %>"
                    <%= devis.getDemande() != null && d.getId().equals(devis.getDemande().getId()) ? "selected" : "" %>>
                    <%= d.getClient().getNom() %> - <%= d.getLieu() %>
                </option>
            <% } %>
        </select>
        <br/><br/>

        <div id="infoDemande" style="border:1px solid #ccc; padding:10px; display:none;">
            <p>Client : <span id="clientNom"></span></p>
            <p>Lieu : <span id="lieu"></span></p>
            <p>District : <span id="district"></span></p>
        </div>
        <br/>

        Type Devis :
        <select name="idTypeDevis" required>
            <option value="">Selectionner un type</option>
            <% for (TypeDevis td : typeDevisList) { %>
                <option value="<%= td.getId() %>"
                    <%= devis.getTypeDevis() != null && td.getId().equals(devis.getTypeDevis().getId()) ? "selected" : "" %>>
                    <%= td.getLibelle() %>
                </option>
            <% } %>
        </select>
        <br/><br/>

        <h3>Detail Devis</h3>
        <table id="tableDetails" border="1">
            <tr>
                <th>Libelle</th>
                <th>P.U</th>
                <th>Qte</th>
                <th>Montant</th>
                <th></th>
            </tr>
        </table>
        <button type="button" onclick="ajouterLigne()">+ Ajouter ligne</button>
        <br/><br/>

        <h3>Montant Total : <span id="montantTotal">0</span> Ar</h3>

        <button type="submit">Enregistrer</button>
    </form>
    <a href="/devis">Retour</a>
    <script src="/js/devis.js"></script>
</body>
</html>