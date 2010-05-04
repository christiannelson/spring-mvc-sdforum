<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="recipe" scope="request" type="xian.recipes.model.Recipe"/>

<template:page title="${recipe.name}" bodyClass="">
  <jsp:body>
    <ul>
      <li>
        <b>Name</b>
        ${recipe.name}
      </li>
      <li>
        <b>Description</b>
        ${recipe.description}
      </li>
      <li>
        <b>Serves</b>
        ${recipe.servingCount}
      </li>
      <li>
        <b>Prep. Time</b>
        ${recipe.preparationTime} minutes
      </li>
      <li>
        <b>Cost (Approximate)</b>
        <spring:eval expression="recipe.cost"/>
      </li>
      <li>
        <b>Ingredients</b>
        <ul>
          <c:forEach items="${recipe.ingredients}" var="ingredient" varStatus="loopStatus">
            <li><spring:eval expression="ingredient.quantity"/>&nbsp;${ingredient.name}&nbsp;<c:if test="${!empty ingredient.preparation}">- ${ingredient.preparation}</c:if></li>
          </c:forEach>
        </ul>
      </li>
      <li>
        <b>Directions</b>
        <ol>
          <c:forEach items="${recipe.steps}" var="step" varStatus="loopStatus">
            <li>${step.directions}</li>
          </c:forEach>
        </ol>
      </li>
    </ul>

    <div class="actions">
      <ul>
        <li><a href="/recipes/${recipe.id}/edit">Edit</a></li>
      </ul>
    </div>
  </jsp:body>
</template:page>
