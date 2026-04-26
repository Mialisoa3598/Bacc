<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.forage.model.Demande" %>
<%@ page import="com.example.forage.model.Status" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%

    String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
    List<Demande> demandeList = (List<Demande>) request.getAttribute("demandes");
    List<Status> statuts = (List<Status>) request.getAttribute("statuts");
%>
<html>
<head><title>Gestion Status</title></head>
<body>
    <h1>Gestion des Status</h1>

    <%-- Formulaire creation nouveau DemandeStatus --%>
    <form action="/demande-status/gestion/save" method="post">

        Demande :
        <select name="idDemande" onchange="loadHistorique(this.value)" required>
            <option value="">Selectionner une demande</option>
            <% for (Demande d : demandeList) { %>
                <option value="<%= d.getId() %>">
                    <%= d.getClient().getNom() %> - <%= d.getLieu() %>
                </option>
            <% } %>
        </select>
        <br/><br/>

        Status :
        <select name="idStatus" required>
            <option value="">Selectionner un status</option>
            <% for (Status s : statuts) { %>
                <option value="<%= s.getId() %>">
                    <%= s.getLibelle() %>
                </option>
            <% } %>
        </select>
        <br/><br/>

        Observation :
        <input type="text" name="observation" placeholder="optionnel"/>
        <br/><br/>

        Date :
        <input type="datetime-local" name="date" value="<%= now %>" required/>
        <br/><br/>

        <button type="submit">Valider</button>
    </form>

    <br/>

    <%-- Historique charge par AJAX --%>
    <div id="historique" style="display:none;">
        <h2>Historique</h2>
        <table border="1">
            <tr>
                <th>Status</th>
                <th>Date</th>
                <th>Observation</th>
                    <th>Durée Simple</th>
                    <th>Durée Complexe</th>
                <th>Action</th>
            </tr>
            <tbody id="tbodyHistorique"></tbody>
        </table>
    </div>

    <a href="/demande-status">Retour</a>

    <script src="/js/demande-status.js"></script>
</body>
</html>