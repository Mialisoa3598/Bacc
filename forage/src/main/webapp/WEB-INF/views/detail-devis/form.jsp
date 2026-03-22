<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.DetailDevis" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="java.util.List" %>
<%
    DetailDevis detailDevis = (DetailDevis) request.getAttribute("detailDevis");
    List<Devis> devisList = (List<Devis>) request.getAttribute("devis");
    boolean isNew = detailDevis.getId() == null;
    Devis devis = isNew ? null : detailDevis.getDevis();
%>
<html>
<head><title>Detail Devis</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Detail Devis</h1>
    <form action="/detail-devis/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : detailDevis.getId() %>"/>

        Libelle : <input type="text" name="libelle" value="<%= isNew ? "" : detailDevis.getLibelle() %>"/>
        <br/>
        Montant : <input type="text" name="montant" value="<%= isNew ? "" : detailDevis.getMontant() %>"/>
        <br/>

        Devis :
        <select name="devis.id" required>
            <option value="">Selectionner</option>
            <% for (Devis d : devisList) { %>
                <option value="<%= d.getId() %>"
                    <%= !isNew && devis != null && d.getId().equals(devis.getId()) ? "selected" : "" %>>
                    <%= d.getDemande().getClient().getNom() %> - <%= d.getDemande().getLieu() %>
                </option>
            <% } %>
        </select>
        <br/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/detail-devis">Retour</a>
</body>
</html>