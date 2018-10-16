<%-- 
    Document   : birthcertification
    Created on : 4 Sep, 2018, 7:14:22 PM
    Author     : sirish
--%>
<%@page import="java.util.List"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="com.mongodb.BasicDBObject"%>
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
            //Printing BC
            String email = request.getParameter("email");
           MongoClient mongo = new MongoClient("localhost", 27017 );             
            DB db = mongo.getDB("CivilDB");
           DBCollection colBirthReg = db.getCollection("BirthReg");
           DBCollection colBirthParetnInfo = db.getCollection("BirthParetnInfo");
           DBCollection colBirthBasicInfo  = db.getCollection("BirthBasicInfo");
           DBCollection colBirthHospital  = db.getCollection("BirthHospital");
           DBCollection colUserGender  = db.getCollection("UserGender");
           DBCollection colUserLoc  = db.getCollection("UserLoc");
           DBCollection colUserReg  = db.getCollection("UserReg");
           
           
            DBObject whereQuery = new BasicDBObject();
             whereQuery.put("email", email);            
             DBObject dbobjBirthReg = colBirthReg.findOne(whereQuery);
             DBObject dbobjBirthParetnInfo = colBirthParetnInfo.findOne(whereQuery);
             DBObject dbobjBirthBasicInfo = colBirthBasicInfo.findOne(whereQuery);
             DBObject dbobjUserGender = colUserGender.findOne(whereQuery);
             DBObject dbobjUserReg = colUserReg.findOne(whereQuery);
             DBObject whereQuery2 = new BasicDBObject();
             //whereQuery2.put("addr", dbobjUserReg.get("addr").toString());              
             DBObject dbobjUserLoc = colUserLoc.findOne(whereQuery2);
             DBObject whereQuery1 = new BasicDBObject();
             //whereQuery1.put("hospitalAddr", dbobjBirthReg.get("hospitaladdr").toString()); 
             DBObject dbobjBirthHospital = colBirthHospital.findOne(whereQuery1);

             
             //BirthReg             
             String maddr = dbobjBirthReg.get("addr").toString();
             String mhospitaladdr = dbobjBirthReg.get("hospitaladdr").toString();
             String mdelTime = dbobjBirthReg.get("delTime").toString();
             //BirthParentInfo
             String mmothername = dbobjBirthParetnInfo.get("mothername").toString();
             String mmotheroccupation = dbobjBirthParetnInfo.get("motheroccupation").toString();
             String mfathername = dbobjBirthParetnInfo.get("fathername").toString();
             String mfatheroccupation = dbobjBirthParetnInfo.get("fatheroccupation").toString();
             //BirthInfo
             String mfname = dbobjBirthBasicInfo.get("fname").toString();
             String mlname = dbobjBirthBasicInfo.get("lname").toString();
             String mdob = dbobjBirthBasicInfo.get("dob").toString();
             //BirthHospital            
             String mhospitalName = dbobjBirthHospital.get("hospitalName").toString();
             //UserReg
             String mgender = dbobjUserGender.get("gender").toString();
             //UserLoc
             String mcity = dbobjUserLoc.get("city").toString();             
           
        %>
        <script src="birth.js"></script>       
       <form id="msform" > 
         <fieldset>
             <input type="text" name="email" value=<%=email%>>
    <h2 class="fs-title">Birth Certificate</h2>    
    <p>Name</p>
    <input type="text" name="fname" value=<%=mfname%> readonly />
    <input type="text" name="lname" value=<%=mlname%> readonly /><br>
    <p>Date of Birth</p> 
    <input type="text" name="dob" value=<%=mdob%> readonly /><br>
    <p>Gender</p> 
    <input type="text" name="gender" value=<%=mgender%> readonly /><br>
    <p>Parents</p>
    <input type="text" name="fathername" value=<%=mfathername%> readonly />
    <input type="text" name="mothername" value=<%=mmothername%> readonly /><br>
    <p>Occupation</p>
    <input type="text" name="fatheroccupation" value=<%=mfatheroccupation%> readonly />
    <input type="text" name="motheroccupation" value=<%=mmotheroccupation%> readonly /><br>
    <p>City</p>
    <input type="text" name="city"value=<%=mcity%> readonly /><br>
    <p>Address</p>
    <textarea name="address" readonly><%=maddr%></textarea> <br>
       <p>Hospital Name </p>
    <input type="text" name="hospitalname"  value=<%=mhospitalName%> readonly /><br>
    <p>Hospital Address</p>    
    <textarea name="hospitaladdress"   readonly><%=mhospitaladdr%></textarea> <br>
    <p>Delivery Time </p>
    <input type="text" name="deltime"  value=<%=mdelTime%> readonly/><br>
    <input type="submit" name="submit" class="action-button" formaction="/CivilRegisterSystem/AdminVerified" value="Approve" />
    <input type="submit" name="submit" class="action-button" formaction="/CivilRegisterSystem/AdminDisApproved" value="DisApprove" />
    <input type="hidden" name="whatverified" value="birthcert">
  </fieldset>   
</form>
    </body>
</html>
