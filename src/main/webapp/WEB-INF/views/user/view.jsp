<%--
  Created by IntelliJ IDEA.
  User: binizmohamed
  Date: 4/6/20
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Blog</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">

    <jsp:directive.include file="../layout/header.jsp" />

    <div class="col-lg-12">
      <p> Nom Complet : <b>${user.name}</b>
        <p> email : ${user.email}</p>
        <p> mot de passe: ${user.password}</p>

    </div>
    <table class="table table-bordered">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>created</th>
            <th>Action</th>

        </tr>
        <c:forEach items="${articles}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/article/view/${item.id}">
                            ${item.title}</a></td>
                <td><fmt:formatDate type = "date" value = "${article.created}" /> </td>
                <td>
                    <a href="${pageContext.request.contextPath}/article/delete/${pageable.number}/${item.id}" class="btn btn-danger"
                       onclick="if (!(confirm('Vous Voulez supprimer cet elementr?'))) return false">Supprimer</a>
                    <a href="${pageContext.request.contextPath}/article/add/${item.id}" class="btn btn-success">Modifier</a>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>

</body>
</html>