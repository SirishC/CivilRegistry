<%-- 
    Document   : user
    Created on : 5 Sep, 2018, 9:12:00 AM
    Author     : sirish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
         <%
            String email = (String)request.getAttribute("email");
            request.setAttribute("email", email);
            session.setAttribute("email", email);
            
        %>
             <input type="hidden" name="email" value=<%=email%>>
             <a href="/CivilRegisterSystem/login.jsp">LogOut</a><br>
             <a href="/CivilRegisterSystem/birthcertification.jsp">Birthcertification</a><br>
             <a href="/CivilRegisterSystem/passport.jsp">Passport</a><br>
        
    </body>
</html>
