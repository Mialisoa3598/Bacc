<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.correction.model.Parametre" %>
<%@ page import="java.util.List" %>
<%
    List<Matiere> matieres = (List<Matiere>) request.getAttribute("matieres");
    List<Operateur> operateurs = (List<Operateur>) request.getAttribute("operateurs");
    List<Resolution> resolutions = (List<Resolution>) request.getAttribute("resolutions");
    List<Parametre> parametres = (List<Parametre>) request.getAttribute("parametres");
%>
<html>
<head><title>Parametres</title></head>
<body>
    <h1>Liste des Parametres</h1>
    <a href="/parametres/new">Ajouter</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Matiere</th>
            <th>Operateur</th>
            <th>Resolution</th>
            <th>Actions</th>
        </tr>
        <% for (Parametre p : parametres) { %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getMatiere().getNom() %></td>
            <td><%= p.getOperateur().getOperateur() %></td>
            <td><%= p.getResolution().getNom() %></td>
            <td>
                <a href="/parametres/edit/<%= p.getId() %>">Modifier</a>
                <a href="/parametres/delete/<%= p.getId() %>">Supprimer</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>