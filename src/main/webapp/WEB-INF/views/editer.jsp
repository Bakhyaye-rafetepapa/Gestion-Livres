<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 16/06/2025
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un Auteur</title>
</head>
<body>
<h2>Modifier l'Auteur</h2>
<form action="/auteurs/save" method="post">
    <input type="hidden" name="id" value="${auteur.id}" />
    <label>Nom :</label>
    <input type="text" name="nom" value="${auteur.nom}" required /><br>
    <label>Biographies :</label>
    <textarea name="biographies">${auteur.biographies}</textarea><br>
    <button type="submit">Enregistrer les modifications</button>
</form>
<a href="/auteurs">Annuler</a>
</body>
</html>

