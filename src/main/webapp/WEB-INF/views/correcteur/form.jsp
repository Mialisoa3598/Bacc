<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Correcteur" %>
<%
    Correcteur correcteur = (Correcteur) request.getAttribute("correcteur");
    boolean isNew = correcteur.getId() == null;
%>
<html>
<head><title>Correcteur</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Correcteur</h1>
    <form action="/correcteurs/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : correcteur.getId() %>"/>
        Nom : <input type="text" name="nom" value="<%= isNew ? "" : correcteur.getNom() %>"/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/correcteurs">Retour</a>
</body>
</html>