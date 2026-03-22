<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.forage.model.Client" %>
<%@ page import="com.example.forage.model.Demande" %>
<%
    Demande demande = (Demande) request.getAttribute("demande");
    List<Client> clientList = (List<Client>) request.getAttribute("clients");
    boolean isNew = demande.getId() == null;
%>
<html>
<head><title>Demande</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Demande</h1>
    <form action="/demandes/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : demande.getId() %>"/>
        Date : <input type="text" name="date" value="<%= isNew ? "" : demande.getDate() %>"/>
        Lieu : <input type="text" name="lieu" value="<%= isNew ? "" : demande.getLieu() %>"/>
        District : <input type="text" name="district" value="<%= isNew ? "" : demande.getDistrict() %>"/>
        Client : <select name="client.id">
            <option value="">Sélectionner un client</option>
            <% for (Client c : clientList) { %>
                <option value="<%= c.getId() %>" 
                    <%= !isNew && demande.getClient() != null && c.getId().equals(demande.getClient().getId()) ? "selected" : "" %>>
                    <%= c.getNom() %>
                </option>
            <% } %>
        </select>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/demandes">Retour</a>
</body>
</html>