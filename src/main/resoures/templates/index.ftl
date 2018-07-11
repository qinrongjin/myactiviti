<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Activiti</title>
</head>
<body>
<#if user??>
    已经登录， ${user.name!''}， <a href="/user/logout">注销</a>
<#else>
    <a href="/user/login">登录</a>
</#if>
</body>
</html>