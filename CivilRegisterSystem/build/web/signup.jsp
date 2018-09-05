<%-- 
    Document   : signup
    Created on : 2 Sep, 2018, 5:39:46 PM
    Author     : sirish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In!</title>
        <link rel="stylesheet" type="text/css" href="signstyle.css" media="all" />         
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

        
    </head>
    <body>
       
             
        <!-- multistep form -->
<form id="msform" action ="/CivilRegisterSystem/Register_DB">
  <!-- progressbar -->
  <ul id="progressbar">
    <li class="active">Account Setup</li>
    <li>Personal Details</li>
    <li>Contact Details</li>
  </ul>
  <!-- fieldsets -->
  <fieldset>
    <h2 class="fs-title">Create your account</h2>
    <h3 class="fs-subtitle">This is step 1</h3>
    <input type="text" name="email" id="email" placeholder="Email" />
    <input type="password" name="pass" id="pass" placeholder="Password" />
    <input type="password" name="cpass" id="cpass" placeholder="Confirm Password" />
    <p class="fs-subtitle" id="alertpass"></p>
    <input type="button" name="next" class="next action-button" value="Next" />
  </fieldset>
  <fieldset>
    <h2 class="fs-title">Personal Details</h2>
    <h3 class="fs-subtitle">We will never sell it</h3>
    <input type="text" id="fname" name="fname" placeholder="First Name" />
    <input type="text" id="lname" name="lname" placeholder="Last Name" />         
    <h4 class="fs-subtitle">Gender</h4>
<!-- First Radio Button -->
<label class="radio-container"> <!-- Wrapper for all elements -->
    <input type="radio" name="gender" id="gender" value="female"> <!-- Radio Button -->
  
  <div class="custom-check" style="margin-left: 100px;"> <!-- Custom Radio button style is here -->
    <img src="https://hamidadib.com/api/venus.png" alt="Mars">
    
    
  </div>
  
  
</label>

<!-- Sec Radio Button -->
<label class="radio-container">
    <input type="radio" name="gender" id="gender" value="male" >
  
  <div class="custom-check">
    <img src="https://hamidadib.com/api/mars.png" alt="Mars">
    
    
  </div>
 
</label>

<!-- 3th Radio Button -->
<label class="radio-container">
    <input type="radio" name="gender" id="gender" value="transgender" >
  
  <div class="custom-check" style="margin-left: -100px;">
    <img src="https://hamidadib.com/api/intersex.png" alt="Intersex">
    
    
  </div>
  
</label>


    <p class="fs-subtitle" id="alertpass1"></p>

    <input type="button" name="previous" class="previous action-button" value="Previous" />
    <input type="button" name="next" class="next action-button" value="Next" />
  </fieldset>  
  <fieldset>
    <h2 class="fs-title">Contact Details</h2>
    <h3 class="fs-subtitle">Your presence on the social network</h3>
    <input type="number" name="phno" placeholder="+91" />
    <input type="text" name="city" placeholder="Eg.chennai" />
    <textarea name="address" placeholder="Address"></textarea> 
    <input type="button" name="previous" class="previous action-button" value="Previous" />
    <input type="submit" name="submit" class="submit action-button" value="Submit" />
  </fieldset>
  
</form>
        
        
        
        <script src="signjs.js"></script>
            
    
    </body>
</html>

