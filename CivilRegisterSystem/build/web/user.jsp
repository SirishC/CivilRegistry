<%-- 
    Document   : user
    Created on : 5 Sep, 2018, 9:12:00 AM
    Author     : sirish
--%>
<%@page import="DatabasePOJO.RequestForm"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.MongoClient"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%          
            String email = (String)request.getAttribute("email");            
            if(email==null){
               email = request.getParameter("getemail");
            }
            
             Gson gson = new Gson();
            MongoClient mongo = new MongoClient("localhost", 27017 );             
            DB db = mongo.getDB("CivilDB");
            DBCollection colUserReg  = db.getCollection("UserReg");
            DBObject whereQuery = new BasicDBObject();
             whereQuery.put("email", email);            

             DBObject dbobjUserReg = colUserReg.findOne(whereQuery);
            
             //values ..
             String mfname = dbobjUserReg.get("fname").toString();
             String mlname = dbobjUserReg.get("lname").toString();
             String mphno = dbobjUserReg.get("phno").toString();
             String maddr = dbobjUserReg.get("addr").toString();
             
             //Status update
             DBCollection colReqForm = db.getCollection("RequestForm");
                              
            DBObject dbobj = colReqForm.findOne(whereQuery);
            //out.println(dbobj.toString());
            RequestForm requestForm = gson.fromJson(dbobj.toString(), RequestForm.class);
         
         //BirthCer Status
         String statusBCer = null;
            if(!requestForm.isReqBCer())statusBCer = "NotRequested";
            else if(requestForm.isErrBCer())statusBCer = "DisApproved";
            else if(requestForm.isReqBCer() && !requestForm.isVerBCer())statusBCer = "Requested";
            else if(requestForm.isReqBCer() && requestForm.isVerBCer())statusBCer = "Approved";
            
            
         //Passport Status
        String statusPassport = null;
            if(!requestForm.isReqPassport())statusPassport = "NotRequested";
            else if(requestForm.isErrPassport())statusPassport = "DisApproved";
            else if(requestForm.isReqPassport() && !requestForm.isVerPassport())statusPassport = "Requested";
            else if(requestForm.isReqPassport() && requestForm.isVerPassport())statusPassport = "Approved";


            
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="signstyle.css" media="all" />         
        <title>Welcome</title>        
        <style>
            .main{
                background: white;
	border: 0 none;
	border-radius: 3px;
	box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
	padding: 20px 30px;
	box-sizing: border-box;
	width: 80%;
	margin: 5% 5%;  

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
        <script>
            function checkBC(){
            var bcer = document.getElementById("statbc").value;
            var pp = document.getElementById("statpp").value;
            var bbcer = document.getElementById("statusBcer");
            var bpp = document.getElementById("statusPP");            
            alert("checkbb")
            if(bcer==="Requested"){
                alert("Already Requested For BirthCertificate");
                bbcer.disabled = "disabled";                
            }           
           else if(bcer==="Approved"){
                alert("BirthCertificate Already Approved");
                bbcer.disabled = "disabled";                
            }
            
        }
        function checkPP(){
            
            var bcer = document.getElementById("statbc").value;
            var pp = document.getElementById("statpp").value;
            var bbcer = document.getElementById("statusBcer");
            var bpp = document.getElementById("statusPP");
            
            if(bcer==="NotRequested" || bcer==="Requested"){
                alert("To Apply For  Passport You  Need To Have BirthCertificate")
                bpp.disabled="disabled";
            }
            else{
                
                if(pp==="Requested"){
                alert("Already Requested For Passport");
                bpp.disabled = "disabled";                
            }
            if(pp==="Approved"){
                alert("Passport Already Approved");
                bpp.disabled = "disabled";                
            }
                
                
            }
            
        }
                                
        </script>
            <form class="logout" >
            <button   formaction="/CivilRegisterSystem/index.html">Logout</button>>
        </form>
        <form class="main">
            <center>
            <h1>Welcome,<%=mfname+" "+mlname%></h1><br>
            <input type="text" value=<%=email%> readonly><br>
            <input type="text" value=<%=mphno%> readonly><br>
            <textarea cols="10" rows="5"><%=maddr%></textarea><br>    
            <input type="hidden" name="email" value=<%=email%>>
            <button  id="statusBcer"  formaction="/CivilRegisterSystem/birthcertification.jsp" onclick=checkBC()>BirthCertificate</button>
            <input type="text" id="statbc"  value=<%=statusBCer%>>
            <button  id="statusPP"  formaction="/CivilRegisterSystem/passport.jsp" onclick=checkPP()>Passport</button>
            <input type="text"  id="statpp" value=<%=statusPassport%>>                        
            </center>
        </form>
        
    </body>
</html>
