<%@ tag body-content="scriptless" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="name" required="true" %>
<%@ attribute name="ingredient" type="xian.recipes.model.Ingredient" %>

<form:input path="${name}.quantity.amount" cssClass="amount" cssErrorClass="amount error" autocomplete="off"
            title="${empty ingredient ? '2' : ''}"/>
<form:select path="${name}.quantity.units" cssClass="units" cssErrorClass="units error">
  <c:forEach items="<%= xian.recipes.model.Unit.values() %>" var="unit">
    <form:option value="${unit}"/>
  </c:forEach>
</form:select>
<form:input path="${name}.name" cssClass="name" cssErrorClass="name error" autocomplete="off"
            title="${empty ingredient ? 'Apples' : ''}"/>
<form:input path="${name}.preparation" cssClass="preparation" cssErrorClass="preparation error" autocomplete="off"
            title="${empty ingredient ? 'sliced thinly' : ''}"/>
<form:errors path="${name}" delimiter=", "/>
