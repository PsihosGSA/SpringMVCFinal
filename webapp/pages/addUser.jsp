<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-primary">
                <div class="panel-body">
                <form action="/hello" method="POST">
                    <div class="form-group has-success has-feedback">
                        <label class="control-label" for="inputSuccess2">Успешный ввод</label>
                        <input type="text" class="form-control" id="inputSuccess2">
                        <span class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                    <div class="form-group has-warning has-feedback">
                        <label class="control-label" for="inputWarning2">Ввод с предупреждением</label>
                        <input type="text" class="form-control" id="inputWarning2">
                        <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
                    </div>
                    <div class="form-group has-error has-feedback">
                        <label class="control-label" for="inputError2">Ввод с ошибкой</label>
                        <input type="text" class="form-control" id="inputError2">
                        <span class="glyphicon glyphicon-remove form-control-feedback"></span>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Отправить" class="btn btn-primary">
                    </div>
                </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>