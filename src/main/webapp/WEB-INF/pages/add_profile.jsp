<%@ page isErrorPage="true" %>
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
            <input type="number" placeholder="Enter phone" name="phone" required>
            <br> <br>
            <button type="submit">Save</button>
            <br>
        </div>
    </form>
    <br> <br>

    <table>
        <tr>
            <th >Id</th>
            <th >Address</th>
            <th >Phone</th>
            <th ></th>
        </tr>
        <tr>
            <td>${id}</td>
            <td>${address}</td>
            <td>${phone}</td>

        </tr>
    </table>

    <form method="post" action="/profile">
        <input type="hidden" name="_method" value="delete">
        <div class="container">
            <button type="submit">Delete</button>
        </div>
    </form>


</body>
</html>
