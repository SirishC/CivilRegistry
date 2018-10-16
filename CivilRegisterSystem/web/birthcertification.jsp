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
        <title>Birth Certification</title>
        <link rel="stylesheet" type="text/css" href="birth.css" media="all" />        
    </head>
    <body>
        <%
            String email = request.getParameter("email");
        %>
        <script src="birth.js"></script>       
       <form id="msform" action ="/CivilRegisterSystem/BirthReg_DB"> 
         <fieldset>
             <input type="text" name="email" value=<%=email%>>
    <h2 class="fs-title">Birth Certificate</h2>    
    <p>Name</p>
    <input type="text" name="fname" placeholder="First Name" />
    <input type="text" name="lname" placeholder="Last  Name" /><br>
    <p>Date of Birth</p> 
    <input type="text" name="dob" placeholder="dd/mm/yyyy" /><br>
    <p>Gender</p> 
    <input type="text" name="gender" placeholder="It should be a radio button !!" /><br>
    <p>Parents</p>
    <input type="text" name="fathername" placeholder="Father Name" />
    <input type="text" name="mothername" placeholder="Mother Name" /><br>
    <p>Occupation</p>
    <input type="text" name="fatheroccupation" placeholder="Father's Occupation" />
    <input type="text" name="motheroccupation" placeholder="Mother's Occupation" /><br>
    <p>City</p>
    <input type="text" name="city" placeholder="City" /><br>
    <p>Address</p>
    <textarea name="address" placeholder="Address"></textarea> <br>
       <p>Hospital Name </p>
    <input type="text" name="hospitalname"  placeholder="Hospital Name" /><br>
    <p>Hospital Address</p>    
    <textarea name="hospitaladdress" placeholder="Hospital Address"></textarea> <br>
    <p>Delivery Time </p>
    <input type="text" name="deltime" placeholder="HH:MM AM/PM" /><br>
    <input type="submit" name="submit" class="action-button" value="Login" />
  </fieldset>   
</form>
    </body>
</html>
