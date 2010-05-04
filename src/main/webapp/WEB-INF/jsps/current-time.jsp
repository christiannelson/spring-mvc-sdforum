<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="currentTime" scope="request" type="java.util.Date"/>

<template:page title="Current Time" bodyClass="current-time">
  <jsp:body>
    ${currentTime}
  </jsp:body>
</template:page>
