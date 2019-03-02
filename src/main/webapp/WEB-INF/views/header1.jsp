<%--
  Created by IntelliJ IDEA.
  User: Dinexpod
  Date: 19.02.2019
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header1</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/servlet/registration">
    <input type="submit" value=" registration ">
</a>

<a href="${pageContext.request.contextPath}/servlet/admin">
    <input type="submit" value=" admin ">
</a>

<a href="${pageContext.request.contextPath}/servlet/header2">
    <input type="submit" value=" header2 ">
</a>

<a href="${pageContext.request.contextPath}/servlet/403">
    <input type="submit" value=" 403 ">
</a>

<a href="${pageContext.request.contextPath}/servlet/404">
    <input type="submit" value=" 404 ">
</a>

<a href="${pageContext.request.contextPath}/servlet/home">
    <input type="submit" value=" home ">
</a>

<a href="${pageContext.request.contextPath}/servlet/login">
    <input type="submit" value=" login ">
</a>

</body>
</html>
