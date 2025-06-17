<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 16/06/2025
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Supprimer un Auteur</title>
</head>
<body>
<h2>Voulez-vous vraiment supprimer cet auteur ?</h2>
<p><strong>${auteur.nom}</strong></p>
<p>${auteur.biographies}</p>

<form action="/auteurs/confirmer-suppression" method="post">
    <input type="hidden" name="id" value="${auteur.id}" />
    <button type="submit">supprimer</button>
</form>
<a href="/auteurs">Annuler</a>
</body>
</html>

