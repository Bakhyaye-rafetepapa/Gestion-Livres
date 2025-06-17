<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter ou Modifier un Livre</title>


</head>
<body>

<h2>Ajouter ou Modifier un Livre</h2>

<div class="form-container">
    <form action="/livres/save" method="post">
        <input type="hidden" name="id" value="${livre.id}" />

        <label for="titre">Titre :</label>
        <input type="text" id="titre" name="titre" value="${livre.titre}" required />

        <label for="auteur">Auteur :</label>
        <input type="text" id="auteur" name="auteur" value="${livre.auteur}" required />

        <label for="categorie">Catégorie :</label>
        <input type="text" id="categorie" name="categorie" value="${livre.categorie}" required />


        <label for="description">Description :</label>
        <textarea id="description" name="description">${livre.description}</textarea>

        <c:choose>
            <c:when test="${empty livre.id}">
                <button type="submit">Ajouter</button>
            </c:when>
            <c:otherwise>
                <button type="submit">Modifier</button>
            </c:otherwise>
        </c:choose>
    </form>
</div>

<a href="/livres" class="link">← Retour à la liste</a>

</body>
</html>
