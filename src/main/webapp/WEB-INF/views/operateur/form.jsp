<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Operateur" %>
<%
    Operateur operateur = (Operateur) request.getAttribute("operateur");
    boolean isNew = operateur.getId() == null;
%>
<html>
<head><title>Operateur</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Operateur</h1>
    <form action="/operateurs/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : operateur.getId() %>"/>
        Nom : <input type="text" name="nom" value="<%= isNew ? "" : operateur.getOperateur() %>"/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/operateurs">Retour</a>
</body>
</html>