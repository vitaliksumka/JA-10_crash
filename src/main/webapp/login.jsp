<%--
  Created by IntelliJ IDEA.
  service.User: 38096
  Date: 01.09.2021
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%--@declare id="login"--%>
<%--@declare id="password"--%>

<jsp:include page="header.jsp"></jsp:include>

<form action="login" method="post">
    <label for="login">Login :</label><input name="login">
    <br>
    <label for="password">Password :</label><input type="password" name="password">
    <br>
    <input type="submit" value="submit">
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
