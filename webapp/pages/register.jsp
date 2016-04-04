<%--
  Created by IntelliJ IDEA.
  User: Anna
  Date: 04.04.2016
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>  
    <title>Register</title>
  </head>
  <body>
  <form name="register" id = "register" action="<c:url value="/register"/>" method="post">
    <h2>Регистрация</h2>

    <c:if test="${errorLogin}">
      <div class="alert">
        This login busy
      </div>
    </c:if>

    Login: <input name="login" type="text">


    <c:if test="${errorPassword}">
      <div class="alert">
        passwords do not match
      </div>
    </c:if> <br/>

    Password: <input placeholder="password" name="password" type="password"> <br/>
    Repeat password <input name="passwordRepeat" type="password"><br/>

    First name: <input name="firstName" type="text"><br/>
    Last name: <input name="lastName" type="text"><br/>
    Email: <input name="email" type="email"><br/>
    Birthday: <input name="birthday" type="date"><br/>
    <input type="submit" value="Register" />
  </form>
</body>
</html>

