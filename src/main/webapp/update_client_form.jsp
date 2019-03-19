<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 3/19/19
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action = "/shop_war_exploded/clients/update" method = "GET">
    id: <input type = "text" name = "id">
    <br />
    Phone: <input type = "number" name = "phone" />
    <br />
    Email: <input type = "text" name = "email" />
    <br />
    Age: <input type = "text" name = "age" />
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>