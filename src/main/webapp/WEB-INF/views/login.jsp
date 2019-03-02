<%--
  Created by IntelliJ IDEA.
  User: Dinexpod
  Date: 12.02.2019
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/loginStyle.css"/>

    <title>login</title>
</head>

<%@include file="header1.jsp" %>

<div id="login">

    <body>

    <h1>LOGIN PAGE</h1>

    <form method="POST"
          action="${pageContext.request.contextPath}/servlet/login">
        <span class="fontawesome-user"></span>
        <input name="login" type="text" class="form-control" placeholder="login"/>
        <span class="fontawesome-lock"></span>
        <input name="password" type="password" class="form-control" placeholder="password"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login">
    </form>

    <a href="${pageContext.request.contextPath}/servlet/registration">
        <form method="GET"
              action="${pageContext.request.contextPath}/servlet/registration">
            <input type="submit" value=" Go to registration ">
        </form>
    </a>

    </body>
</div>
</html>
