<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Ajouter ou Modifier une Catégorie</title>

</head>
<body>

<h2>Ajouter ou Modifier une Catégorie</h2>

<div class="form-container">
  <form action="/categories/save" method="post">
    <input type="hidden" name="id" value="${categorie.id}" />

    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" value="${categorie.nom}" required />

    <c:choose>
      <c:when test="${empty categorie.id}">
        <button type="submit">Ajouter</button>
      </c:when>
      <c:otherwise>
        <button type="submit">Modifier</button>
      </c:otherwise>
    </c:choose>
  </form>
</div>

<a href="/categories" class="link">← Retour à la liste</a>

</body>
</html>
