<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Directors</title>
        </head>

        <body>

            <jsp:include page="menu.jsp" />

            <h2>Directors in database</h2>
            <div>${message}</div>

            <table>

                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Email</th>
                </tr>

                <c:forEach items="${allDirectors}" var="director">
                    <tr>
                        <td>${director.firstname}</td>
                        <td>${director.lastname}</td>
                        <td>${director.age}</td>
                        <td>${director.email}</td>
                        <td><a href="EditDirector/${director.directorId}">edit</a></td>
                    </tr>
                </c:forEach>

            </table>

            <br>
            <div><a href="AddDirector">Add new director</a></div>

        </body>

        </html>
