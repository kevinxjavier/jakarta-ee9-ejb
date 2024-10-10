<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Greetings</title>
</head>
<body>
    <h2>From EJB</h2>
    <h3>Hola ${greeting}</h3>
    <h3>Hola ${greeting2}</h3>
    <ol>
        <c:forEach items="${list}" var="element">
            <li>${element.name}</li>
        </c:forEach>
    </ol>
</body>
</html>