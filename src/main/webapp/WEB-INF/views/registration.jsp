<%--
  Created by IntelliJ IDEA.
  User: Dinexpod
  Date: 14.02.2019
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/loginStyle.css"/>

    <title>registration</title>
</head>
<%@include file="header1.jsp"%>

<div id="login">

    <body>
    <h1>REGISTRATION PAGE</h1>
    <form method="POST"
          action="${pageContext.request.contextPath}/servlet/registration" modelattribute="userRegistrationInput">
        <span class="fontawesome-user"></span>
        <input name="email" type="text" placeholder="Email">
        <span class="fontawesome-user"></span>
        <input name="login" type="text" placeholder="login">
        <span class="fontawesome-user"></span>
        <input name="name" type="text" placeholder="Name">
        <span class="fontawesome-lock"></span>
        <input name="password" type="password" placeholder="Password">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Authorization">
    </form>
    <a href="${pageContext.request.contextPath}/servlet/login">
        <form method="GET"
              action="${pageContext.request.contextPath}/servlet/login">
            <input type="submit" value=" Go to login ">
        </form>
    </a>
    </body>
</div>
</html>
