<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>奇丑无比</title>
</head>
<body>
<form action="/user/user" method="post">
    邮箱<input type="text" name="username"><br/>
    密码<input type="text" name="password"><br/>
    firstName<input type="text" name="firstName"><br/>
    lastName<input type="text" name="lastName"><br/>
    <input type="submit" value="添加">
</form>
<table>
    <thead>
    <tr>
        <th>firstName</th>
        <th>lastName</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.firstName!''}</td>
            <td>${user.lastName!''}</td>
            <td>${user.email!''}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>