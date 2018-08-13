<%--
  Created by IntelliJ IDEA.
  User: Emma
  Date: 2018/8/13
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>

    <tr>
        <th>序号</th>
        <th>标题</th>
        <th>内容</th>
        <th>语言</th>
    </tr>
    <c:forEach items="${sessionScope.filmlist}" var="film">
        <tr>
            <td><c:out value="${film.film_id}"/></td>
            <td><c:out value="${film.title}"/></td>
            <td><c:out value=" ${film.description}"/></td>
            <td><c:out value="${film.language}" /></td>
            <td><a href="/deletefilm?film_id=${film.film_id}">删除</a></td>
            <td><a href="editfilm.jsp?film_title=${film.title}&film_description=${film.description}&film_id=${film.film_id}">编辑</a></td>
        </tr>

    </c:forEach>


    <tr>
        <td><a href="addfilm.jsp">添加</a></td>
    </tr>
</table>

</body>
</html>
