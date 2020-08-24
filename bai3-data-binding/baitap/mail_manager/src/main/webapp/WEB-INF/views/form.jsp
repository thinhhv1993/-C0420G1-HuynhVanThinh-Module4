<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h3>Settings</h3>
<form:form method="POST" action="update" modelAttribute="Email">
    <table>
        <tr>
            <td><form:label path="languages">languages:</form:label></td>
            <td><form:select path="languages" items="${listLanguage}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td><form:select path="pageSize" items="${listPageSize}"/></td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter: </form:label></td>
            <td><form:checkbox path="spamsFilter" value="Enable"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="update"/></td>
            <td><button type="button"/>
                <a href="/form" style="text-decoration: none">Cancel</a></td>
        </tr>
    </table>
</form:form>
</body>
</html>