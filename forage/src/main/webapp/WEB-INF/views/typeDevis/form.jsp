<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.TypeDevis" %>
<%
    TypeDevis typeDevis = (TypeDevis) request.getAttribute("typeDevis");
    boolean isNew = typeDevis.getId() == null;
%>
<html>
<head><title>Type de Devis</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Type de Devis</h1>
    <form action="/typeDevis/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : typeDevis.getId() %>"/>
        Libelle : <input type="text" name="libelle" value="<%= isNew ? "" : typeDevis.getLibelle() %>"/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/typeDevis">Retour</a>
</body>
</html>