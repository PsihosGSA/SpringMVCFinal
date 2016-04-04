<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login page</title>
    </head>
<body>
    <c:if test="${error}">
        <div class="alert alert-danger">
            Incorrect login or password
        </div>
    </c:if>
    <c:if test="${registerComplited}">
        Register complited. Entry you login and password.
    </c:if>

        <form action="<c:url value="/login"/>" method="post">
            <input type="text" name="user" placeholder="Login" > <br/>
            <input type="password" name="password" placeholder="Password"> <br/>
            <input type="submit" value="Sigh in"><br/>
        </form>


        <form action="<c:url value="/register"/>" method="get">
            <input type="submit" value="Register" >
        </form>
    </body>
</html>