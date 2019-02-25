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

    <title>home</title>
</head>
<%@include file="header1.jsp"%>

<div id="login">

    <form method="POST" action="${pageContext.request.contextPath}/servlet/logout" class="form">
        <button type="submit">Logout</button>

        <h1> Welcome!!! </h1>
        <h1> You are located on main page WebSite! </h1>

        <body>
        <a href="${pageContext.request.contextPath}/servlet/login">
            <form method="GET"
                  action="${pageContext.request.contextPath}/servlet/login">
                <input type="submit" value=" Login ">
            </form>
        </a>
        <a href="${pageContext.request.contextPath}/developer">
            <form method="GET"
                  action="${pageContext.request.contextPath}/developer">
                <input type="submit" value=" Developer page ">
            </form>
        </a>

        </body>

    </form>

</div>

</html>