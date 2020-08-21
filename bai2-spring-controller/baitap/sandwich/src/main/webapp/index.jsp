<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/save">
    <input type="checkbox" id="vehicle1" name="vehicle" value="Lettuce">
    <label for="vehicle1"> Lettuce</label><br>
    <input type="checkbox" id="vehicle2" name="vehicle" value="Tomato">
    <label for="vehicle2"> Tomato</label><br>
    <input type="checkbox" id="vehicle3" name="vehicle" value="Mustard">
    <label for="vehicle3"> Mustard</label><br><br>
    <input type="submit" value="Submit" >
</form>
</body>
<h3>Hi ${vehicle1}</h3>
</html>
