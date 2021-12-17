<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Add Actor</title>
    </head>

    <body>
    	<jsp:include page="menu.jsp" />
        <h1>Add an actor</h1>
        <div>${message}</div>

        <form action="AddActorSubmit" method="post">
        
            <label for="firstname">First Name</label>
            <input type="text" name="firstname" required>
            
            <label for="lastname">Last Name</label>
            <input type="text" name="lastname" required>
            
            <label for="age">Age</label>
            <input type="number" name="age" required>
            
            <label for="email">Email</label>
            <input type="email" name="email" required>
            
            <input type="submit" value="add actor">
        </form>

    </body>

    </html>
