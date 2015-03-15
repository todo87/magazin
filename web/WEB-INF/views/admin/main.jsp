<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/includes/script/header.jsp"/>
<html>
<head>
    <title>Main admin</title>
</head>
<body>
<div class="container">
    <p class="logout_paragraph">Logged as <strong>${pageContext.request.userPrincipal.name}</strong> | <a id="logout_link" onclick="formSubmit()">Logout</a></p>
    <div class="jumbotron">
        <h2>Welcome !</h2>
    </div>
</div>

<form action="/logout" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</form>

</body>
</html>
<script type="text/javascript">

    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }

</script>