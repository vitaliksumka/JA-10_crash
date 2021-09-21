<%--
  Created by IntelliJ IDEA.
  service.User: 38096
  Date: 01.09.2021
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--@declare id="firstname"--%>
<%--@declare id="lastname"--%>
<%--@declare id="email"--%>
<%--@declare id="password"--%>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>i-shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="main-login">
    <!-- Sing in  Form -->
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-image">
                    <figure><img src="images/signin-image.jpg" alt="sing up image"></figure>
                    <a href="index.jsp" class="signup-image-link">Create an account</a>
                </div>

                <div class="signin-form">
                    <h2 class="form-title">Sign up</h2>

                    <form action="${pageContext.request.contextPath}/LoginServlet" method="POST" class="login-form">

                        <div class="alert alert-warning" role="alert">
                            You are registered?
                        </div>

                        <div class="form-group">
                            <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" class="email" placeholder="Your Email"/>
                        </div>

                        <div class="form-group">
                            <label><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" class="password" placeholder="Password"/>
                        </div>

                        <div class="form-group">
                            <input type="checkbox" name="remember-me" id="remember-me" class="agree-term"/>
                            <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember
                                me</label>
                        </div>

                        <div class="form-group form-button">
                            <input type="submit" name="signin" id="signin" class="email-submit" value="Log in"/>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </section>

</div>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<script src="js/login.js"></script>
</body>
</html>






