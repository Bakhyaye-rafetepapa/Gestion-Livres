<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Gestion des Auteurs</title>


</head>
<body>

<h2>Ajouter ou Modifier un Auteur</h2>

<div class="form-container">
  <a class="link" href="/auteurs">Ajouter un nouvel auteur</a>

  <form action="/auteurs/save" method="post">
    <input type="hidden" name="id" value="${auteur.id}" />

    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" value="${auteur.nom}" required />

    <label for="biographies">Biographies :</label>
    <textarea id="biographies" name="biographies">${auteur.biographies}</textarea>

    <c:choose>
      <c:when test="${empty auteur.id}">
        <button type="submit">Ajouter</button>
      </c:when>
      <c:otherwise>
        <button type="submit">Modifier</button>
      </c:otherwise>
    </c:choose>
  </form>
</div>

<c:if test="${not empty auteurs}">
  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Nom</th>
      <th>Biographies</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="a" items="${auteurs}">
      <tr>
        <td>${a.id}</td>
        <td>${a.nom}</td>
        <td>${a.biographies}</td>
        <td class="actions">
          <form action="/auteurs/editer" method="get">
            <input type="hidden" name="id" value="${a.id}" />
            <button type="submit">Modifier</button>
          </form>
          <form action="/auteurs/supprimer" method="post" onsubmit="return confirm('Supprimer cet auteur ?');">
            <input type="hidden" name="id" value="${a.id}" />
            <button type="submit" style="background-color: #dc3545;">Supprimer</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>

<a class="link" href="/">Retour à l'accueil</a>

</body>
</html>
