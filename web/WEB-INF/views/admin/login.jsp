<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/includes/script/header.jsp"/>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h2>Admin section</h2>
        <c:choose>
            <c:when test="${error eq true}">
                <h5 class="bg-danger">${msg}</h5>
            </c:when>
            <c:otherwise>
                <h5 class="bg-success">${msg}</h5>
            </c:otherwise>
        </c:choose>
    </div>

    <form name='loginForm' <c:url value='j_spring_security_check' /> class="admin_login_center_div" method="POST">

        <div class="form-group">
            <label for="username">User:</label>
            <input class="form-control" id="username" name="username" placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    </form>

</div>
</body>
</html>
