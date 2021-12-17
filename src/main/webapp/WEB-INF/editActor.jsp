<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Edit Actor</title>
        </head>

        <body>
            <jsp:include page="menu.jsp" />
            <h1>Edit actor</h1>
            <div>${message}</div>

            <sf:form action="${pageContext.request.contextPath}/EditActorSubmit" modelAttribute="actor">

                <sf:errors path="firstname" />
                <sf:label path="firstname">First Name</sf:label>
                <sf:input path="firstname" type="text" required="required" />

                <sf:errors path="lastname" />
                <sf:label path="lastname">Last Name</sf:label>
                <sf:input path="lastname" type="text" required="required" />

                <sf:errors path="age" />
                <sf:label path="age">Age</sf:label>
                <sf:input path="age" type="text" required="required" />

                <sf:errors path="email" />
                <sf:label path="email">Email</sf:label>
                <sf:input path="email" type="text" required="required" />

                <sf:hidden path="actorId" value="${actorId}" />

                <div>
                    <input type="submit" value="Update actor" />
                    <input type="submit" value="Delete" name="Delete" />
                </div>

            </sf:form>
        </body>

        </html>
