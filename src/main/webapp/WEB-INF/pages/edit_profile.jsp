<%-- To solved to the put/delete method not supported by JSP --%>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User Profile Page</title>
</head>
<body>
<h2>Edit User Profile</h2>

<form method="post" action="/profile">
    <div class="container">
        <input type="hidden" name="_method" value="put">
        <label>Id : </label>
        <input type="number" placeholder="${id}" name="id" value="${id}" readonly>
        <br> <br>
        <label>Address : </label>
        <input type="text" placeholder="${address}" value="${profile.address}" name="address">
        <br> <br>
        <label>Phone : </label>
        <input type="number" placeholder="${phone}" value="${profile.phone}" name="phone">
        <br> <br>
        <button type="submit">Edit</button>
        <br>
    </div>
</form>
</body>
</html>
