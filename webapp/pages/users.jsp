<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">

    <script src="<c:url value="/resources/js/vendors/jquery.js"/>"></script>
    <script src="<c:url value="/resources/js/vendors/underscore.js"/>"></script>
    <script>

        $.ajaxSetup({
            dataType: "json"
        });

        _.templateSettings = {
            interpolate: /\<\@\=(.+?)\@\>/gim,
            evaluate: /\<\@(.+?)\@\>/gim,
            escape: /\<\@\-(.+?)\@\>/gim
        };
    </script>

    <script>
        users = ${initialUsersList};
    </script>
    <script src="<c:url value="/resources/js/script.js"/>"></script>
</head>
<body>

<!-- Underscore шаблон строки в таблице юзеров -->
<script type="text/x-underscore-template" id="user-table-body-row">
<@ if(users.length == 0) { @>
<tr>
    <td colspan="4">No users found</td>
</tr>
<@ } else { @>
<@ _(users).each(function(user){ @>
<tr>
    <td><@= user.id @></td>
    <td><@= user.firstName @>, <@= user.lastName @></td>
    <td><@= user.email @></td>
    <td class="controls">
        <a class="edit btn btn-sm btn-primary"
           data-action="add friends"
           data-id="<@= user.id @>"
           href="/users/<@= user.id @>">
            Edit
        </a>
    </td>
</tr>
<@ }); @>
<@ }; @>
</script>


<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title pull-left">
                        Users
                    </h3>
                    <a class="add btn btn-primary pull-right" href="/userPage">My page</a>
                    <a class="add btn btn-primary pull-right" href="/logout">logout</a>
                    <div class="clearfix"></div>
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="table-responsive">
                        <table id="user-list-table" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>&nbsp;</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
                </div>
                <!-- /.panel-body -->
            </div>
        </div>
    </div>
</div>

</body>
</html>