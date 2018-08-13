<%--
  Created by IntelliJ IDEA.
  User: Emma
  Date: 2018/8/13
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addfilm" method="post">
    title:<input type="text"name="title"><br><br>
    description:<input type="text" name="description"><br><br>
    language:<select select class="select" name="language"><br>
    <c:forEach items="${lans}" var="language">
        <option>${language.language_name}</option>
    </c:forEach>
    <br><br><br>
</select>
    <input type="submit" value="提交">
</form>
</body>
</html>
