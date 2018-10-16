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
        <link rel="stylesheet" type="text/css" href="signstyle.css" media="all" />         
        <title>DeathCertification</title>
        <style>            
             .main{
                background: white;
	border: 0 none;
	border-radius: 3px;
	box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
	padding: 20px 30px;
	box-sizing: border-box;
	width: 50%;
	margin: 15% 19%;  

            }
            input,textarea,button{
                padding: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
	margin-bottom: 10px;
	width: 60%;
	box-sizing: border-box;
	font-family: montserrat;
	color: #881c2f;
	font-size: 13px;
        
            }
            h1{
                color:#881c2f; 
            }
            .logout{
                width: 15%;
            }
           
        </style>    
    </head>    
    <body>
         <% 
        String email = request.getParameter("email");
        %>
        
        <form class="main" method="POST" >  <center>
            <h1>UserName :  <%=email%>!</h1>
            <input type="hidden"   name="email" value=<%=email%>>
            <p>Are You Sure,The User is Dead ?</p>
            <input type="submit" formaction="/CivilRegisterSystem/DeathReg_DB" value="YES">
            <input type="submit" formaction="/CivilRegisterSystem/admin.jsp" value="NO">

        </center></form>
    </body>
</html>
