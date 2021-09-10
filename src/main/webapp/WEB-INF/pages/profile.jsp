<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile Page</title>
</head>
<body>
    <h2>User Profile</h2>
    <h3>create result:  ${result}</h3>

        <form method="post" action="/profile">
        <div class="container">
            <label>Address : </label>
            <input type="text" placeholder="Enter address" name="address" required>
            <br> <br>
            <label>Phone : </label>
            <input type="text" placeholder="Enter phone" name="phone" required>
            <br> <br>
            <button type="submit">Save</button>
            <br>
        </div>
    </form>
    <br> <br>
</body>
</html>
