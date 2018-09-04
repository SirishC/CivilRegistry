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
        <script src="birth.js"></script>
        <h1 style='color: white'>Ravi Topper !</h1>
       <form id="msform" action ="/CivilRegisterSystem/logincheck"> 
         <fieldset>
    <h2 class="fs-title">Birth Certificate</h2>    
    <p>Name</p>
    <input type="text" name="fname" placeholder="First Name" />
    <input type="text" name="lname" placeholder="Last  Name" /><br>
    <p>Date of Birth</p> 
    <input type="text" name="dob" placeholder="dd/mm/yyyy" /><br>
    <p>Gender</p> 
    <input type="email" name="email" placeholder="It should be a radio button !!" /><br>
    <p>Parents</p>
    <input type="text" name="fname" placeholder="Father Name" />
    <input type="text" name="fname" placeholder="Mother Name" /><br>
    <p>Occupation</p>
    <input type="text" name="fname" placeholder="Father's Occupation" />
    <input type="text" name="fname" placeholder="Mother's Occupation" /><br>
    <p>City</p>
    <input type="text" name="fname" placeholder="City" /><br>
    <p>Address</p>
    <textarea name="address" placeholder="Address"></textarea> <br>
       <p>Hospital Name </p>
    <input type="text" name="fname" placeholder="City" /><br>
    <p>Hospital Address</p>    
    <textarea name="address" placeholder="Address"></textarea> <br>
    <p>Delivery Time </p>
    <input type="text" name="fname" placeholder="City" /><br>
    <input type="submit" name="submit" class="action-button" value="Login" />
  </fieldset>   
</form>
    </body>
</html>
