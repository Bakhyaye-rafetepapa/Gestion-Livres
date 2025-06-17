<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Catégories</title>

</head>
<body>

<c:if test="${not empty message}">
    <div class="message">${message}</div>
</c:if>

<h2>Ajouter ou Modifier une Catégorie</h2>

<div class="form-container">
    <form:form action="${pageContext.request.contextPath}/categories/save" method="post" modelAttribute="categorie">
        <form:hidden path="id" />

        <label for="nom">Nom :</label>
        <form:input path="nom" id="nom" required="true" />

        <c:choose>
            <c:when test="${empty categorie.id}">
                <button type="submit" class="btn">Ajouter</button>
            </c:when>
            <c:otherwise>
                <button type="submit" class="btn">Modifier</button>
            </c:otherwise>
        </c:choose>
    </form:form>
</div>

<c:if test="${not empty categories}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${categories}">
            <tr>
                <td>${c.id}</td>
                <td>${c.nom}</td>
                <td class="actions">
                    <form action="${pageContext.request.contextPath}/categories/editer" method="get">
                        <input type="hidden" name="id" value="${c.id}" />
                        <button type="submit" class="edit-btn">Modifier</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/categories/supprimer" method="post" onsubmit="return confirm('Supprimer cette catégorie ?');">
                        <input type="hidden" name="id" value="${c.id}" />
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
