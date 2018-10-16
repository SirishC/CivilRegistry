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
        <title>PassPort</title>
        <link rel="stylesheet" type="text/css" href="birth.css" media="all" />
    </head>
       <%
            String email = request.getParameter("email");
              MongoClient mongo = new MongoClient("localhost", 27017 );             
            DB db = mongo.getDB("CivilDB");
           
            
            DBObject whereQuery = new BasicDBObject();
            whereQuery.put("email", email);      
            DBCollection colBirthParetnInfo = db.getCollection("BirthParetnInfo");            
           DBCollection colUserEmpType = db.getCollection("UserEmpType");
           DBCollection colUserEduQual = db.getCollection("UserEduQual");
           DBCollection colUserMaritalStatus = db.getCollection("UserMaritalStatus");
           DBCollection colUserGender  = db.getCollection("UserGender");
           DBCollection colUserLoc  = db.getCollection("UserLoc");
           DBCollection colUserReg  = db.getCollection("UserReg");
           DBCollection colBirthBasicInfo  = db.getCollection("BirthBasicInfo");           
           DBCollection colPassportReg  = db.getCollection("PassportReg");
          
           DBObject dbobjUserReg = colUserReg.findOne(whereQuery);
           DBObject dbobjBirthParetnInfo = colBirthParetnInfo.findOne(whereQuery);
           DBObject dbobjBirthBasicInfo = colBirthBasicInfo.findOne(whereQuery);           
           DBObject dbobjUserGender = colUserGender.findOne(whereQuery);
           DBObject dbobjUserEmpType = colUserEmpType.findOne(whereQuery);
            DBObject dbobjUserEduQual = colUserEduQual.findOne(whereQuery);
             DBObject dbobjUserMaritalStatus = colUserMaritalStatus.findOne(whereQuery);
             DBObject whereQuery2 = new BasicDBObject();
             //whereQuery2.put("addr", dbobjUserReg.get("addr").toString());              
             DBObject dbobjUserLoc = colUserLoc.findOne(whereQuery2);
             DBObject dbobjPassportReg = colPassportReg.findOne(whereQuery);
             
             //UserReg
             String mgender = dbobjUserGender.get("gender").toString();
             //UserLoc
             String mcity = dbobjUserLoc.get("city").toString();
             //BirthParentInfo
             String mmothername = dbobjBirthParetnInfo.get("mothername").toString();            
             String mfathername = dbobjBirthParetnInfo.get("fathername").toString();
             //BirthInfo            
             String mfname = dbobjUserReg.get("fname").toString();
             String mlname = dbobjUserReg.get("lname").toString();
             String mdob = dbobjBirthBasicInfo.get("dob").toString();
             //PassportInfo
             String mmaritalStat =dbobjUserMaritalStatus.get("maritalStat").toString();           
             String mEmployeeStat =dbobjUserEmpType.get("empType").toString();
             String mEmployeeQual =dbobjUserEduQual.get("eduQual").toString();
             String maddr = dbobjUserReg.get("addr").toString();
             String mplace = dbobjPassportReg.get("place").toString();
             String mdate = dbobjPassportReg.get("date").toString();
             
             
             
                


        %>
    <body>
        <script src="birth.js"></script>     
       <form id="msform" action ="/CivilRegisterSystem/PassportReg_DB"> 
         <fieldset>
                     
             <input type="text" name="email" value=<%=email%> readonly>
    <h2 class="fs-title">Passport Registration</h2>    
    <p>Name</p>
    <input type="text" name="fname" value=<%=mfname%> readonly />
    <input type="text" name="lname" value=<%=mlname%> readonly /><br>
    <p>Date of Birth</p> 
    <input type="text" name="dob" value=<%=mdob%> readonly/><br>
    <p>Gender</p> 
    <input type="text" name="gender" value=<%=mgender%> readonly/><br>
    <p>Marital Status</p>
    <input type="text" name="maritalstat" value=<%=mmaritalStat%> readonly/><br>
    <p>Employment Status</p>
    <input type="text" name="emplomentstat" value=<%=mEmployeeStat%> readonly/><br>       
    <p>Educational Qualification</p>
    <input type="text" name="eduqual" value=<%=mEmployeeQual%> readonly /><br>
    <p>Parents</p>
    <input type="text" name="fathername" value=<%=mfathername%> readonly /><br>        
    <input type="text" name="mothername" value=<%=mmothername%> readonly /><br>
    <p>City</p>
    <input type="text" name="city" value=<%=mcity%> readonly /><br>
    <p>Address</p>
    <textarea name="address" readonly><%=maddr%></textarea> <br>
       <p>Place of Registration</p>
    <input type="text" name="por" value=<%=mplace%> readonly /><br>   
    <p>Date of Registration </p>
    <input type="text" name="dor"value=<%=mdate%> readonly/><br>
    <input type="submit" name="submit" class="action-button" formaction="/CivilRegisterSystem/AdminVerified" value="Approve" />
    <input type="submit" name="submit" class="action-button" formaction="/CivilRegisterSystem/AdminDisApproved" value="DisApprove" />
    <input type="hidden" name="whatverified" value="passport">

  </fieldset>   
</form>
    </body>
</html>
