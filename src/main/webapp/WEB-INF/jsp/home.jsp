<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admissions Committee</title>
</head>
<body>
<h1>Admissions Committee</h1>
<ul>
    <c:forEach var="member" items="${admissionsCommittee}">
        <li>${member.name}, ${member.role}</li>
    </c:forEach>
</ul>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
