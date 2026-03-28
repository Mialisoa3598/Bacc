<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.forage.model.Client" %>
<%@ page import="com.example.forage.model.Demande" %>
<%
    Demande demande = (Demande) request.getAttribute("demande");
    List<Client> clientList = (List<Client>) request.getAttribute("clients");
%>
<html>
<head><title>Demande</title></head>
<body>
    <h1><%= demande.getId() == null ? "Ajouter" : "Modifier" %> Demande</h1>
    <form action="/demandes/save" method="post">
        <input type="hidden" name="id" value="<%= demande.getId() == null ? 0 : demande.getId() %>"/>

        Lieu : <input type="text" name="lieu" value="<%= demande.getLieu() != null ? demande.getLieu() : "" %>"/>
        <br/>
        District : <input type="text" name="district" value="<%= demande.getDistrict() != null ? demande.getDistrict() : "" %>"/>
        <br/>
        Client :
        <select name="idclient" required>
            <option value="">Selectionner un client</option>
            <% for (Client c : clientList) { %>
                <option value="<%= c.getId() %>"
                    <%= demande.getClient() != null && c.getId().equals(demande.getClient().getId()) ? "selected" : "" %>>
                    <%= c.getNom() %>
                </option>
            <% } %>
        </select>
        <br/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/demandes">Retour</a>
</body>
</html>

<%-- <%@ page contentType="text/html;charset=UTF-8" %>
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
        Lieu : <input type="text" name="lieu" value="<%= isNew ? "" : demande.getLieu() %>"/>
        District : <input type="text" name="district" value="<%= isNew ? "" : demande.getDistrict() %>"/>
        Client : <select name="idclient">
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
</html> --%>