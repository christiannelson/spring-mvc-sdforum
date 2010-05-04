<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="recipe" tagdir="/WEB-INF/tags/recipe" %>

<jsp:useBean id="recipe" scope="request" type="xian.recipes.model.Recipe"/>

<template:page title="Edit Recipe">
  <jsp:attribute name="head">
    <script type="text/javascript" src="/static/javascripts/recipes-form.onready.js"></script>
  </jsp:attribute>
  <jsp:body>
    <recipe:form recipe="${recipe}" operation="update"/>
  </jsp:body>
</template:page>
