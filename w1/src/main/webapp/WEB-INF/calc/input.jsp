<%--
  Created by IntelliJ IDEA.
  User: Hoon
  Date: 2025-03-10
  Time: 오후 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/calc/makeResult" method="post">    <!--action, method 속성 추가-->
    <input type="number" name="num1">
    <input type="number" name="num2">
    <button type="submit">SEND</button>
</form>

</body>
</html>
