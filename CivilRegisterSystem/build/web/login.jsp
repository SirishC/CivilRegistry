<%-- 
    Document   : login
    Created on : 3 Sep, 2018, 7:28:34 PM
    Author     : sirish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
         <link rel="stylesheet" type="text/css" href="signstyle.css" media="all" />         
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    </head>    
    <body>
      <h1 style="color: white">Ravi Topper !!</h1>
      <form id="msform" action ="/CivilRegisterSystem/logincheck"> 
          <fieldset>
    <h2 class="fs-title">Login</h2>
    <h3 class="fs-subtitle">Find comfort in the chaos.</h3>
    <input type="email" name="email" placeholder="Email" />
    <input type="password" name="pass" placeholder="Password" />
    <input type="submit" name="submit" class="submit action-button" value="Login" />
  </fieldset>   
</form>
        
        
        
        <script src="signjs.js"></script>
            
    </body>
</html>
