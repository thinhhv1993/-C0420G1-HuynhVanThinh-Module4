<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Trang chuyển đổi</h2>
<form action="/result" method="get">
    <input type="number" name="number" placeholder="Input number">
    <input type="submit" value="Convert">
</form>
<h2>Kết quả là: ${result}</h2>
</body>
</html>
