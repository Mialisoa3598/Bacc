<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Matiere" %>
<%@ page import="com.example.correction.model.Candidat" %>
<%@ page import="com.example.correction.model.NoteFinal" %>
<%@ page import="java.util.List" %>
<%
    List<Matiere> matieres = (List<Matiere>) request.getAttribute("matieres");
    List<Candidat> candidats = (List<Candidat>) request.getAttribute("candidats");
    NoteFinal noteFinal = (NoteFinal) request.getAttribute("noteFinal");
%>
<html>
<head><title>Note Finale</title></head>
<body>
    <h1>Calcul Note Finale</h1>
    <form action="/note-final/calculer" method="post">
        Candidat :
        <select name="idCandidat" required>
            <% for (Candidat ca : candidats) { %>
                <option value="<%= ca.getId() %>"><%= ca.getNom() %></option>
            <% } %>
        </select>
        Matiere :
        <select name="idMatiere" required>
            <% for (Matiere m : matieres) { %>
                <option value="<%= m.getId() %>"><%= m.getNom() %></option>
            <% } %>
        </select>
        <button type="submit">Calculer</button>
    </form>

    <% if (noteFinal != null) { %>
        <p>Note Finale : <%= noteFinal.getNote() %></p>
    <% } %>
</body>
</html>