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
<%--@declare id="confirm-password"--%>

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
<div class="main">
    <!-- Sign up form -->
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Registration</h2>

                    <form method="POST" class="register-form">
                        <div class="alert alert-success" role="alert">
                            Registration completed successfully!
                        </div>

                        <div class="form-group">
                            <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" class="firstName" placeholder="Your Name"/>
                        </div>

                        <div class="form-group">
                            <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" class="lastName" placeholder="Your Surname"/>
                        </div>

                        <div class="form-group">
                            <label><i class="zmdi zmdi-email"></i></label>
                            <input type="email" class="email" placeholder="Your Email"/>
                        </div>

                        <div class="form-group">
                            <label><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" class="password" placeholder="Password"/>
                        </div>

                        <div class="form-group">
                            <label><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" class="confirm-password"
                                   placeholder="Repeat your password"/>
                        </div>

                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="checkbox" class="agree-term"/>
                            <label for="checkbox" class="label-agree-term"><span><span></span></span>I agree all
                                statements in <a href="#" class="term-service">Terms of service</a></label>
                        </div>

                        <div class="form-button">
                            <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                        </div>

                    </form>
                </div>
                <div class="signup-image">
                    <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                    <a href="login.jsp" class="signup-image-link">I am already member</a>
                </div>
            </div>
        </div>
    </section>
</div>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
        integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<script src="js/login.js"></script>
</body>
</html>






