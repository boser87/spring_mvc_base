<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07/04/2018
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Goals Report</title>
</head>
<body>
<table>
    <tr><th>Minutes</th><th>Exercise Minutes</th><th>Activity</th></tr>
    <c:forEach items="${goalReports}" var="goalReport">
        <tr>
            <td>${goalReport.goalMinutes}</td>
            <td>${goalReport.exerciseMinutes}</td>
            <td>${goalReport.exerciseActivity}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
