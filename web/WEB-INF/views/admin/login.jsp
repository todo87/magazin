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
        <h5>Please login.</h5>
    </div>

    <form action="${pageContext.request.contextPath}/main" role="form" class="admin_login_center_div" method="post">

        <div class="form-group">
            <label for="user">User:</label>
            <input class="form-control" id="user" name="user" placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>

    </form>

</div>
</body>
</html>
