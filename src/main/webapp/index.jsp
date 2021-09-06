<%--
  Created by IntelliJ IDEA.
  service.User: 38096
  Date: 01.09.2021
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<%--@declare id="firstname"--%>
<%--@declare id="lastname"--%>
<%--@declare id="email"--%>
<%--@declare id="password"--%>

<jsp:include page="header.jsp"></jsp:include>

<form action="registration" method="post">
    <label for="firstName">First Name :</label> <input name="firstName">
    <br>
    <label for="lastName">Last Name :</label> <input name="lastName">
    <br>
    <label for="email">Email :</label> <input name="email">
    <br>
    <label for="password">Password :</label> <input type="password" name="password">
    <br>
    <input type="submit" value="submit">
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
