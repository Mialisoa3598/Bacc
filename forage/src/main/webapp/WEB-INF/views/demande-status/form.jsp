<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.DemandeStatus" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="com.example.forage.model.Status" %>
<%@ page import="java.util.List" %>
<%
    DemandeStatus demandeStatus = (DemandeStatus) request.getAttribute("demandeStatus");
    List<Demande> demandeList = (List<Demande>) request.getAttribute("demandes");
    List<Status> statuts = (List<Status>) request.getAttribute("statuts");
    boolean isNew = demandeStatus.getId() == null;
%>
<html>
<head><title>Demande Status</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Demande Status</h1>
    <form action="/demande-status/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : demandeStatus.getId() %>"/>

        Date : <input type="text" name="date" value="<%= isNew ? "" : demandeStatus.getDate() %>"/>
        <br/>

        Demande :
        <select name="demande.id" required>
            <option value="">Selectionner</option>
            <% for (Demande d : demandeList) { %>
                <option value="<%= d.getId() %>"
                    <%= !isNew && demandeStatus.getDemande() != null && d.getId().equals(demandeStatus.getDemande().getId()) ? "selected" : "" %>>
                    <%= d.getClient().getNom() %> - <%= d.getLieu() %>
                </option>
            <% } %>
        </select>
        <br/>

        Status :
        <select name="status.id" required>
            <option value="">Selectionner</option>
            <% for (Status s : statuts) { %>
                <option value="<%= s.getId() %>"
                    <%= !isNew && demandeStatus.getStatus() != null && s.getId().equals(demandeStatus.getStatus().getId()) ? "selected" : "" %>>
                    <%= s.getLibelle() %>
                </option>
            <% } %>
        </select>
        <br/>

        <button type="submit">Enregistrer</button>
    </form>
    <a href="/demande-status">Retour</a>
</body>
</html>