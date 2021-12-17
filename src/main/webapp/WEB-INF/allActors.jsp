<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Actors</title>
        </head>

        <body>

            <jsp:include page="menu.jsp" />

            <h2>Actors in database</h2>
            <div>${message}</div>

            <table>

                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Email</th>
                </tr>

                <c:forEach items="${allActors}" var="actor">
                    <tr>
                        <td>${actor.firstname}</td>
                        <td>${actor.lastname}</td>
                        <td>${actor.age}</td>
                        <td>${actor.email}</td>
                        <td><a href="EditActor/${actor.actorId}">edit</a></td>
                    </tr>
                </c:forEach>

            </table>

            <br>
            <div><a href="AddActor">Add new actor</a></div>

        </body>

        </html>
