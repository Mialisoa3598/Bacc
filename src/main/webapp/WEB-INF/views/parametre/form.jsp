<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Matiere" %>
<%@ page import="com.example.correction.model.Operateur" %>
<%@ page import="com.example.correction.model.Resolution" %>
<%@ page import="com.example.correction.model.Parametre" %>
<%@ page import="java.util.List" %>
<%
    List<Matiere> matieres = (List<Matiere>) request.getAttribute("matieres");
    List<Operateur> operateurs = (List<Operateur>) request.getAttribute("operateurs");
    List<Resolution> resolutions = (List<Resolution>) request.getAttribute("resolutions");
    Parametre parametre = (Parametre) request.getAttribute("parametre");
    boolean isNew = parametre.getId() == null;
%>
<html>
<head><title>Parametre</title></head>
<body>
    <h1><%= isNew ? "Ajouter" : "Modifier" %> Parametre</h1>
    <form action="/parametres/save" method="post">
        <input type="hidden" name="id" value="<%= isNew ? "" : parametre.getId() %>"/>
        Matiere :
        <select name="matiere.id" required>
            <option value="">Selectionner</option>
            <% for (Matiere m : matieres) { %>
                <option value="<%= m.getId() %>" <%= !isNew && m.getId().equals(parametre.getMatiere().getId()) ? "selected" : "" %>><%= m.getNom() %></option>
            <% } %>
        </select>
        <br/>
        Diff : <input type="text" name="diff" value="<%= isNew ? "" : parametre.getDiff() %>"/>
        <br/>
        Operateur :
        <select name="operateur.id" required>
            <option value="">Selectionner</option>
            <% for (Operateur o : operateurs) { %>
                <option value="<%= o.getId() %>" <%= !isNew && o.getId().equals(parametre.getOperateur().getId()) ? "selected" : "" %>><%= o.getOperateur() %></option>
            <% } %>
        </select>
        <br/>
        Resolution :
        <select name="resolution.id" required>
            <option value="">Selectionner</option>
            <% for (Resolution r : resolutions) { %>
                <option value="<%= r.getId() %>" <%= !isNew && r.getId().equals(parametre.getResolution().getId()) ? "selected" : "" %>><%= r.getNom() %></option>
            <% } %>
        </select>
        <br/>
        <button type="submit">Enregistrer</button>
    </form>
    <a href="/parametres">Retour</a>
</body>
</html>