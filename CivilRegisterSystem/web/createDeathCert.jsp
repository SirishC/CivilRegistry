<%-- 
    Document   : createDeathCert
    Created on : 16 Oct, 2018, 6:45:33 PM
    Author     : Ravibalg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DeathCertification</title>
    </head>
    <body>
         <% 
        String email = request.getParameter("email");
        %>
        <h1>You gonna murder <%=email%>!</h1>
        <form method="POST" action="/CivilRegisterSystem/DeathReg_DB">  
<input type="hidden" name="email" value=<%=email%>>
<input type="submit"  value="Murder">
        </form>
    </body>
</html>
