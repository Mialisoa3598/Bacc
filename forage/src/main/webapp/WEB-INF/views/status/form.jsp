<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Status" %>
<%
    Status status = (Status) request.getAttribute("status");
    boolean isNew = status.getId() == null;
%>
<html>
<head><title>Status</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Status</h1>
    <form action="/status/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : status.getId() %>"/>
        Libelle : <input type="text" name="libelle" value="<%= isNew ? "" : status.getLibelle() %>"/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/status">Retour</a>
</body>
</html>