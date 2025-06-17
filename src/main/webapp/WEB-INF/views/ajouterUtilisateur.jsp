<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter ou Modifier un Utilisateur</title>

</head>
<body>

<h2>Ajouter ou Modifier un Utilisateur</h2>

<div class="form-container">
    <form action="/utilisateurs/save" method="post">
        <input type="hidden" name="id" value="${utilisateur.id}" />

        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" value="${utilisateur.nom}" required />

        <label for="telephone">Telephone :</label>
        <input type="text" id="telephone" name="telephone" value="${utilisateur.telephone}" required />


        <label for="email">Email :</label>
        <input type="email" id="email" name="email" value="${utilisateur.email}" required />


        <c:choose>
            <c:when test="${empty utilisateur.id}">
                <button type="submit">Ajouter</button>
            </c:when>
            <c:otherwise>
                <button type="submit">Modifier</button>
            </c:otherwise>
        </c:choose>
    </form>
</div>

<a href="/utilisateurs" class="link">← Retour à la liste</a>

</body>
</html>
