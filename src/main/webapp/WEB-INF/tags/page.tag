<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@ attribute name="title" %>
<%@ attribute name="bodyClass" %>

<%@ attribute name="head" fragment="true" %>
<%@ attribute name="titlebar" fragment="true" %>

<!doctype html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>

  <title>${title}</title>

  <link type="text/css" rel="stylesheet" media="all" href="/static/stylesheets/recipes.css">

  <script type="text/javascript" src="/static/javascripts/ext/jquery-1.4.2.js"></script>
  <script type="text/javascript" src="/static/javascripts/ext/jquery.ezpz_hint.js"></script>
  <%--<script type="text/javascript" src="/static/javascripts/application.js"></script>--%>
  <script type="text/javascript" src="/static/javascripts/application.onready.js"></script>

  <jsp:invoke fragment="head"/>
</head>

<body class="${bodyClass}">
<div id="head">
  <div id="message-container">
    <div id="message"></div>
  </div>
</div>
<div id="page">
  <div id="content">
    <jsp:doBody/>
  </div>
</div>
</body>
</html>