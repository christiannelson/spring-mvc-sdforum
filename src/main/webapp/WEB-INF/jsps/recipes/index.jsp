<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="recipes" scope="request" type="java.util.List<xian.recipes.model.Recipe>"/>

<template:page title="Recipes" bodyClass="">
  <jsp:body>
    <table>
      <thead>
      <tr>
        <th>Name</th>
        <th>Serves</th>
        <th>Time</th>
        <th>Cost</th>
        <th>Actions</th>
      </tr>
      </thead>
      <c:forEach items="${recipes}" var="recipe">
        <tr>
          <td><a href="/recipes/${recipe.id}">${recipe.name}</a></td>
          <td>${recipe.servingCount}</td>
          <td>${recipe.preparationTime}</td>
          <td><spring:eval expression="recipe.cost"/></td>
          <td>
            <a href="/recipes/${recipe.id}/edit">Edit</a>
            <a href="/recipes/${recipe.id}" data-confirm="Are you sure?" data-method="delete" rel="nofollow">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </table>

    <div class="actions">
      <ul>
        <li><a href="/recipes/new">Add a recipe</a></li>
      </ul>
    </div>

  </jsp:body>
</template:page>
