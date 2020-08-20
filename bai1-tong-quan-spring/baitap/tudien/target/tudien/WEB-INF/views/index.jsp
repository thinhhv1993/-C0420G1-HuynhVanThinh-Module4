<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Tra từ</h2>
<form action="/result" method="get">
    <input type="text" name="keyword" placeholder="Input keyword">
    <input type="submit" value="Search">
</form>
<h2>Nghĩa của từ: ${result}</h2>
</body>
</html>
