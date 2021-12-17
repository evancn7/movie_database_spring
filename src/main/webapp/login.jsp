<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Login</title>
    </head>

    <body>
        <h1>MovieDB Login</h1>
        <div>${message}</div>
        <form action="Login" method="post">
            <div>
                <label for="username">username</label>
                <input type="text" name="username" required="required" value="test">
            </div>
            <div>
                <label for="password">password</label>
                <input type="password" name="password" required="required" value="password">
            </div>

            <div>
                <button type="submit">Login</button>
            </div>
        </form>
    </body>

    </html>
