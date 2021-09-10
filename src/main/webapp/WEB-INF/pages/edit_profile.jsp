<%-- To solved to the put/delete method not supported by JSP --%>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User Profile Page</title>
</head>
<body>
<h2>User Profile</h2>
<h3>Edit result: ${result}</h3>

<form method="post" action="/profile">
    <div class="container">
        <input type="hidden" name="_method" value="put">
        <label>Id : </label>
        <input type="text" placeholder="${id}" name="id" readonly>
        <br> <br>
        <label>Address : </label>
        <input type="text" placeholder="${address}" name="address" required>
        <br> <br>
        <label>Phone : </label>
        <input type="number" placeholder="${phone}" name="phone" value="PUT" required>
        <br> <br>
        <button type="submit">Edit</button>
        <br>
    </div>
</form>
</body>
</html>
