<%--
  Created by IntelliJ IDEA.
  User: binizmohamed
  Date: 4/6/20
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Ajouter article</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

<div class="container">
    <jsp:directive.include file="../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>Ajouter un article</h1>
        <form:form method="post" action="${pageContext.request.contextPath}/article/save" modelAttribute="article" >
            <form:input path="id" type="hidden" />
            <div class="form-group">
                <label for="title">Titre</label>
                <form:input path="title" cssClass="form-control"  placeholder="titre" />
                <form:errors path="title" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="body">Texte</label>
                <form:textarea path="body" cssClass="form-control"  placeholder="le Corps de l'article" />
                <form:errors path="body" cssClass="alert-danger" />

            </div>
            <div class="form-check">
                <label class="form-check-label">
                    Publier
                </label>
                <form:checkbox path="published"/>
            </div>

            <div class="form-check">
                <label class="form-check-label">
                    Tags
                </label>


                <c:forEach items="${tags}"   var="tag">
                    <c:choose>
                        <c:when test="${tag.used}">
                                <form:checkbox path="tagList" value="${tag.id}" label="${tag.title}" checked="checked" />
                        </c:when>
                        <c:otherwise>
                            <form:checkbox path="tagList" value="${tag.id}" label="${tag.title}"  />
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
                <form:errors path="tagList" cssClass="alert-danger" />
            </div>
            





            <input type = "submit" value = "Submit"/>
        </form:form>
    </header>
</div>
</body>
</html>
