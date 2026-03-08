<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Matiere" %>
<%@ page import="com.example.correction.model.Candidat" %>
<%@ page import="com.example.correction.model.Correcteur" %>
<%@ page import="com.example.correction.model.Note" %>
<%@ page import="java.util.List" %>
<%
    List<Matiere> matieres = (List<Matiere>) request.getAttribute("matieres");
    List<Candidat> candidats = (List<Candidat>) request.getAttribute("candidats");
    List<Correcteur> correcteurs = (List<Correcteur>) request.getAttribute("correcteurs");
    Note note = (Note) request.getAttribute("note");
    boolean isNew = note.getId() == null;
%>
<html>
<head><title>Note</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Note</h1>
    <form action="/notes/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : note.getId() %>"/>
        Matiere :
        <select name="matiere.id" required>
            <option value="">Selectionner</option>
            <% for (Matiere m : matieres) { %>
                <option value="<%= m.getId() %>" <%= !isNew && m.getId().equals(note.getMatiere().getId()) ? "selected" : "" %>><%= m.getNom() %></option>
            <% } %>
        </select>
        <br/>
        Candidats :
        <select name="candidat.id" required>
            <option value="">Selectionner</option>
            <% for (Candidat ca : candidats) { %>
                <option value="<%= ca.getId() %>" <%= !isNew && ca.getId().equals(note.getCandidat().getId()) ? "selected" : "" %>><%= ca.getNom() %></option>
            <% } %>
        </select>
        <br/>
        Correcteurs :
        <select name="correcteur.id" required>
            <option value="">Selectionner</option>
            <% for (Correcteur co : correcteurs) { %>
                <option value="<%= co.getId() %>" <%= !isNew && co.getId().equals(note.getCorrecteur().getId()) ? "selected" : "" %>><%= co.getNom() %></option>
            <% } %>
        </select>
        <br/>
        Note : <input type="text" name="note" value="<%= isNew ? "" : note.getNote() %>"/>
        <br/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/notes">Retour</a>
</body>
</html>