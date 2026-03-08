<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Matiere" %>
<%
    Matiere matiere = (Matiere) request.getAttribute("matiere");
    boolean isNew = matiere.getId() == null;
%>
<html>
<head><title>Matiere</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Matiere</h1>
    <form action="/matieres/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : matiere.getId() %>"/>
        Nom : <input type="text" name="nom" value="<%= isNew ? "" : matiere.getNom() %>"/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/matieres">Retour</a>
</body>
</html>