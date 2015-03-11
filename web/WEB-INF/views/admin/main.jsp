<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/includes/script/header.jsp"/>
<html>
<head>
    <title>Main admin</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h2>Welcome !</h2>
        <h5>Your user is : <div class="bg-info"><c:out value="${user}"></c:out></div> and you have password : <c:out value="${pwd}"></c:out><div class="bg-info"></div></h5>
    </div>



</div>
</body>
</html>
