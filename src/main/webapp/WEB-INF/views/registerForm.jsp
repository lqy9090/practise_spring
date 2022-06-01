<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" href="<c:url value=""/>" >
    </head>
    <body>
        <h1>Register</h1>
        <form method="post">
            First Name: <input type="text" name="firstName"/><br/>
            Last Name: <input type="text" name="lastName"/><br/>
            Username: <input type="text" name="username"/><br/>
            Password: <input type="password" name="password"/><br/>
        </form>
    </body>
</html>

