<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/8/2020
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/email/form">Add New Email</a>
<h3>List Email</h3>
<table>
    <tr>
        <th>Id</th>
        <th>languages</th>
        <th>pageSize</th>
        <th>spamsFilter</th>
        <th>signature</th>
        <th>Action</th>
    </tr>
    <c:forEach var="email" items="${emails}">
        <tr>
            <td>${email.id}</td>
            <td>${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
            <td><a href="/email/delete/${email.id}">Delete</a> </td>
            <td><a href="/email/edit/${email.id}">Edit</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
