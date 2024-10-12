<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Users</title>
</head>
<body>
    <h1>List Users</h1>
    <ol>
        <c:forEach items="${listUsers}" var="user">
            <li>${user.name} ${user.email}</li>
        </c:forEach>
    </ol>
</body>
</html>