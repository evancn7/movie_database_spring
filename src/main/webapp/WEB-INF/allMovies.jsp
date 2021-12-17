<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Movies</title>
        </head>

        <body>

            <jsp:include page="menu.jsp" />

            <h2>Movies in database</h2>
            <div>${message}</div>

            <table>

                <tr>
                    <th>Name</th>
                    <th>Genre</th>
                </tr>

                <c:forEach items="${allMovies}" var="movie">
                    <tr>
                        <td>${movie.name}</td>
                        <td>${movie.genre}</td>
                        <td>${movie.releaseDate}</td>
                        <td><a href="EditMovie/${movie.movieId}">edit</a></td>
                    </tr>
                </c:forEach>

            </table>

            <br>
            <div><a href="AddMovie">Add new movie</a></div>

        </body>

        </html>
