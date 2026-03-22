<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Client" %>
<%
    Client client = (Client) request.getAttribute("client");
    boolean isNew = client.getId() == null;
%>
<html>
<head><title>Client</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Client</h1>
    <form action="/clients/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : client.getId() %>"/>
        Nom : <input type="text" name="nom" value="<%= isNew ? "" : client.getNom() %>"/>
        Contact : <input type="text" name="contact" value="<%= isNew ? "" : client.getContact() %>"/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/clients">Retour</a>
</body>
</html>