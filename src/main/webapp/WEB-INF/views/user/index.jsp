<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 2020-04-21
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Authetification</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <style>
        #global{
            margin-left: 35%;
            margin-right: 35%;
            margin-top: 5%;
        }
    </style>
</head>
<body>
<div id="global">
    <h2>Authentification</h2>
<form:form method="post" action="${pageContext.request.contextPath}/login" modelAttribute="user" >

    <div class="form-group">
        <label for="email">email</label>
        <form:input path="email" cssClass="form-control"  placeholder="email" />
        <form:errors path="email" cssClass="alert-danger" />
    </div>
    <div class="form-group">
        <label for="password">Mot de passe </label>
        <form:input path="password" cssClass="form-control" type="password" placeholder="mot de passe " />
        <form:errors path="password" cssClass="alert-danger" />
    </div>
    <input class="btn btn-primary" type = "submit" value = "login"/>
</form:form>

</div>
</body>
</html>
