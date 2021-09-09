<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1>Login</h1>
<h5>${errorMsg}</h5>
<form method="post">
    <div class="container">
        <label>Username : </label>
        <input type="text" placeholder="Enter Username" name="name" required>
        <br> <br>
        <label>Password : </label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <br> <br>
        <button type="submit">Login</button>
        <br>
    </div>
</form>
</body>
</html>
