<%-- 
    Document   : passport
    Created on : 5 Sep, 2018, 12:05:42 AM
    Author     : sirish
--%>

<%-- 
    Document   : birthcertification
    Created on : 4 Sep, 2018, 7:14:22 PM
    Author     : sirish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PassPort</title>
        <link rel="stylesheet" type="text/css" href="birth.css" media="all" />
    </head>
    <body>
        <script src="birth.js"></script>     
       <form id="msform" action ="/CivilRegisterSystem/PassportReg_DB"> 
         <fieldset>
             
             <%
            String email = (String)session.getAttribute("email");
            
        %>
        
             <input type="hidden" name="email" value=<%=email%>>
    <h2 class="fs-title">Passport Registration</h2>    
    <p>Name</p>
    <input type="text" name="fname" placeholder="First Name" />
    <input type="text" name="lname" placeholder="Last  Name" /><br>
    <p>Date of Birth</p> 
    <input type="text" name="dob" placeholder="dd/mm/yyyy" /><br>
    <p>Gender</p> 
    <select name="gender" class="dropdown"><br>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option></select><br>                 
    <p>Marital Status</p>
    <select name="maritalstat" class="dropdown"><br>
                <option value="Single">Single</option>
                <option value="Married">Married</option>
                <option value="Divocee">Divocee</option>
                <option value="Widowed">Widowed</option></select><br> 
    <p>Marital Status</p>
    <select name="emplomentstat" class="dropdown"><br>
                <option value="employee">Employee</option>
                <option value="selfemployee">Self Employee</option>
                <option value="worker">Worker</option>
                <option value="unemployed">Unemployed</option></select><br> 
    <p>Educational Qualification</p>
    <input type="text" name="eduqual" placeholder="Educational Qualification" /><br>
    <p>Parents</p>
    <input type="text" name="fathername" placeholder="Father' Name " /><br>        
    <input type="text" name="mothername" placeholder="Mother Name " /><br>
    <p>City</p>
    <input type="text" name="city" placeholder="City" /><br>
    <p>Address</p>
    <textarea name="address" placeholder="Address"></textarea> <br>
       <p>Place of Registration</p>
    <input type="text" name="por" placeholder="Place" /><br>   
    <p>Date of Registration </p>
    <input type="text" name="dor" placeholder="dd/mm/yyyy" /><br>
    <input type="submit" name="submit" class="action-button" value="Login" />
  </fieldset>   
</form>
    </body>
</html>
