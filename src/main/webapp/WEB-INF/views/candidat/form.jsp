<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Candidat" %>
<%
    Candidat candidat = (Candidat) request.getAttribute("candidat");
    boolean isNew = candidat.getId() == null;
%>
<html>
<head><title>Candidat</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Candidat</h1>
    <form action="/candidats/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : candidat.getId() %>"/>
        Nom : <input type="text" name="nom" value="<%= isNew ? "" : candidat.getNom() %>"/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/candidats">Retour</a>
</body>
</html>