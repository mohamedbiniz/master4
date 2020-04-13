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
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">
    <jsp:directive.include file="../layout/header.jsp" />
 <header class="col-lg-12">
    <h1>Tous les tags du Blog</h1>

        <div class="col-lg-12">
            <a href="${pageContext.request.contextPath}/tag/add" class="btn btn-primary">A
                jouter Tag</a>
            <br/>
        </div>
        <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Tag</th>
                <th>created</th>
                <th>Action</th>

            </tr>
            <c:forEach items="${pageable.content}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.title}</td>
                    <td><fmt:formatDate type = "date" value = "${tag.created}" /> </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/tag/delete/${pageable.number}/${item.id}" class="btn btn-danger"
                           onclick="if (!(confirm('Vous Voulez supprimer cet elementr?'))) return false">Supprimer</a>
                        <a href="${pageContext.request.contextPath}/tag/add/${item.id}" class="btn btn-success">Modifier</a>
                    </td>
                </tr>

            </c:forEach>
        </table>

     <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:choose>
                <c:when test="${pageable.number !=0 }">
                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/tag/page/${pageable.number-1 }">Previous</a></li>
                </c:when>
            </c:choose>
            <c:forEach begin="0"   end="${pageable.totalPages -1}" var="i">
                <c:choose>
                    <c:when test="${pageable.number ==i }">
                        <li class="page-item disabled"><a class="page-link" href="${pageContext.request.contextPath}/tag/page/${i}">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/tag/page/${i}">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:choose>
                <c:when test="${pageable.number <pageable.totalPages-1 }">
                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/tag/page/${pageable.number+1 }">Next</a></li>
                </c:when>
            </c:choose>
        </ul>
     </nav>



 </header>

</div>

</body>
</html>