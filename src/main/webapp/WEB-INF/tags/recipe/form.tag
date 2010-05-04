<%@ tag body-content="scriptless" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="recipe" tagdir="/WEB-INF/tags/recipe" %>

<%@ attribute name="recipe" type="xian.recipes.model.Recipe" required="true" %>
<%@ attribute name="operation" required="true" %>

<c:choose>
  <c:when test="${operation == 'create'}">
    <c:set var="action">/recipes</c:set>
    <c:set var="method">post</c:set>
    <c:set var="buttonText">Create</c:set>
  </c:when>
  <c:otherwise>
    <c:set var="action">/recipes/${recipe.id}</c:set>
    <c:set var="method">put</c:set>
    <c:set var="buttonText">Update</c:set>
  </c:otherwise>
</c:choose>

<form:form commandName="recipe" action="${action}" method="${method}">
  <input type="hidden" name="id" value="${recipe.id}"/>

  <fieldset>
    <legend>Recipe</legend>

    <p>
      <form:label path="name">Name</form:label><br/>
      <form:input path="name" cssClass="recipe-name" cssErrorClass="recipe-name error" autocomplete="off"/>
      <form:errors path="name" delimiter=", "/>
    </p>

    <p>
      <form:label path="description">Description</form:label><br/>
      <form:textarea path="description" cssClass="description" cssErrorClass="description error"/>
      <form:errors path="description" delimiter=", "/>
    </p>

    <p>
      <form:label path="servingCount">Servings</form:label><br/>
      <form:input path="servingCount" cssErrorClass="error" autocomplete="off"/>
      <form:errors path="servingCount" delimiter=", "/>
    </p>

    <p>
      <form:label path="preparationTime">Preparation Time (minutes)</form:label><br/>
      <form:input path="preparationTime" cssErrorClass="error" autocomplete="off"/>
      <form:errors path="preparationTime" delimiter=", "/>
    </p>

    <p>
      <form:label path="cost">Cost (approximate)</form:label><br/>
      <form:input path="cost" cssErrorClass="error" autocomplete="off" title="$15.00"/>
      <form:errors path="cost" delimiter=", "/>
    </p>
  </fieldset>
  <fieldset>
    <legend>Ingredients</legend>
    <form:errors path="ingredients"/>
    <ul class="ingredients">
      <c:forEach items="${recipe.ingredients}" var="ingredient" varStatus="loopStatus">
        <li>
          <recipe:ingredient name="ingredients[${loopStatus.index}]" ingredient="${ingredient}"/>
          <button type="button" class="delete">Delete</button>
        </li>
      </c:forEach>
      <li>
        <recipe:ingredient name="ingredients[${fn:length(recipe.ingredients)}]"/>
        <button type="button" class="delete">Delete</button>
      </li>
    </ul>
    <button type="button" class="add-ingredient">Add Another</button>
  </fieldset>
  <fieldset>
    <legend>Directions</legend>
    <form:errors path="steps"/>
    <ol class="steps">
      <c:forEach items="${recipe.steps}" var="step" varStatus="loopStatus">
        <li>
          <form:input path="steps[${loopStatus.index}].directions" autocomplete="off"/>
          <form:errors path="steps[${loopStatus.index}].directions" delimiter=", "/>
          <button type="button" class="delete">Delete</button>
        </li>
      </c:forEach>
      <li>
        <form:input path="steps[${fn:length(recipe.steps)}].directions" autocomplete="off"/>
        <form:errors path="steps[${fn:length(recipe.steps)}].directions" delimiter=", "/>
        <button type="button" class="delete">Delete</button>
      </li>
    </ol>
    <button type="button" class="add-step">Add Another</button>
  </fieldset>
  <button type="submit">${buttonText}</button>
</form:form>
