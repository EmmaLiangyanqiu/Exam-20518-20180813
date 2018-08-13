<%@ page import="entity.Film" %><%--
  Created by IntelliJ IDEA.
  User: Emma
  Date: 2018/8/13
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String title=request.getParameter("film_title");
String description=request.getParameter("film_description");
String film_id=request.getParameter("film_id");
request.getSession().setAttribute("film_id",film_id);%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/updatefilm" method="post">
    title:<input type="text"name="title" value="<%=title%>"><br><br>
    description:<input type="text" name="description" value="<%=description%>"><br><br>
    language:<select select class="select" name="language"><br>
    <c:forEach items="${lans}" var="language">
        <option>${language.language_name}</option>
    </c:forEach>
    <br><br><br>
</select>
    <input type="submit" value="提交" >
</form>
</body>
</html>
