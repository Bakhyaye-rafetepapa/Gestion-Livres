<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Livres</title>


</head>
<body>

<c:if test="${not empty message}">
    <div class="message">${message}</div>
</c:if>

<h2>Ajouter ou Modifier un Livre</h2>

<div class="form-container">
    <form:form action="${pageContext.request.contextPath}/livres/save" method="post" modelAttribute="livre">
        <form:hidden path="id" />

        <label for="titre">Titre :</label>
        <form:input path="titre" id="titre" required="true" />

        <label for="auteur">Auteur :</label>
        <form:input path="auteur" id="auteur" required="true" />

        <label for="categorie">Catégorie :</label>
        <form:input path="categorie" id="categorie" required="true" />


        <label for="description">Description :</label>
        <form:textarea path="description" id="description" rows="4" />

        <c:choose>
            <c:when test="${empty livre.id}">
                <button type="submit" class="btn">Ajouter</button>
            </c:when>
            <c:otherwise>
                <button type="submit" class="btn">Modifier</button>
            </c:otherwise>
        </c:choose>
    </form:form>
</div>

<c:if test="${not empty livres}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Catégorie</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="l" items="${livres}">
            <tr>
                <td>${l.id}</td>
                <td>${l.titre}</td>
                <td>${l.auteur}</td>
                <td>${l.categorie}</td>
                <td>${l.description}</td>
                <td class="actions">
                    <form action="${pageContext.request.contextPath}/livres/editer" method="get">
                        <input type="hidden" name="id" value="${l.id}" />
                        <button type="submit" class="edit-btn">Modifier</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/livres/supprimer" method="post" onsubmit="return confirm('Supprimer ce livre ?');">
                        <input type="hidden" name="id" value="${l.id}" />
                        <button type="submit" class="delete-btn">Supprimer</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<a href="/" class="link">← Retour à l'accueil</a>

</body>
</html>
