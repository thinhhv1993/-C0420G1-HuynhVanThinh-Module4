<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Updated</title>
</head>
<body>
<h2>Updated</h2>
<table>
    <tr>
        <td>Language :</td>
        <td>${Email.languages}</td>
    </tr>
    <tr>
        <td>Page Size :</td>
        <td>${Email.pageSize}</td>
    </tr>
    <tr>
        <td>Spams Filter :</td>
        <td>${Email.spamsFilter}</td>
    </tr>
    <tr>
        <td>Signature :</td>
        <td>${Email.signature}</td>
    </tr>
</table>
</body>
</html>