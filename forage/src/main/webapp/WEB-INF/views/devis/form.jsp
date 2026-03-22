<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Devis" %>
<%@ page import="com.example.forage.model.TypeDevis" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="java.util.List" %>
<%
    Devis devis = (Devis) request.getAttribute("devis");
    List<TypeDevis> typeDevisList = (List<TypeDevis>) request.getAttribute("typeDevis");
    List<Demande> demandeList = (List<Demande>) request.getAttribute("demandes");
    boolean isNew = devis.getId() == null;
%>
<html>
<head><title>Devis</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Devis</h1>
    <form action="/devis/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : devis.getId() %>"/>

        Date : <input type="text" name="date" value="<%= isNew ? "" : devis.getDate() %>"/>
        <br/>

        Type de Devis :
        <select name="typeDevis.id" required>
            <option value="">Selectionner</option>
            <% for (TypeDevis td : typeDevisList) { %>
                <option value="<%= td.getId() %>"
                    <%= !isNew && devis.getTypeDevis() != null && td.getId().equals(devis.getTypeDevis().getId()) ? "selected" : "" %>>
                    <%= td.getLibelle() %>
                </option>
            <% } %>
        </select>
        <br/>

        Demande :
        <select name="demande.id" required>
            <option value="">Selectionner</option>
            <% for (Demande d : demandeList) { %>
                <option value="<%= d.getId() %>"
                    <%= !isNew && devis.getDemande() != null && d.getId().equals(devis.getDemande().getId()) ? "selected" : "" %>>
                    <%= d.getClient().getNom() %> - <%= d.getLieu() %>
                </option>
            <% } %>
        </select>
        <br/>

        <button type="submit">Enregistrer</button>
    </form>
    <a href="/devis">Retour</a>
</body>
</html>