<%-- 
    Document   : admin
    Created on : 14 Oct, 2018, 6:16:33 PM
    Author     : Ravibalg
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="DatabasePOJO.DeathReg"%>
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
        <link rel="stylesheet" type="text/css" href="signstyle.css" media="all" />
        <title>Admin Page</title>
        <style>
            @import url(https://fonts.googleapis.com/css?family=Montserrat);
            #user {
                display: inline-table;
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 30%;
}
.button{
   
}
.main{
    background: white;
	border: 0 none;
	border-radius: 3px;
	box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);
	padding: 20px 30px;
	box-sizing: border-box;
	width: 80%;
	margin: 5% 5%;  
        padding-bottom: 35%;
        	
	
}
#user td, #user th {
    border: 1px solid #ddd;
    padding: 8px;
    font-family: montserrat, arial, verdana;
}

#user tr:nth-child(even){
    font-family: montserrat, arial, verdana;
    background-color: #f2f2f2;
}

#user tr:hover {background-color: #ddd;}

#user th {
    font-family: montserrat, arial, verdana;
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: white;
    border-radius: 2px;    
    color: #73272F;
}
h1{
    color: white;
    font-family: montserrat, arial, verdana;
}
tr,td,a{
    color: #73272F;    
    text-decoration: none;
    
}
button{
    background-color: white; /* Green */
    border: white;
    border-right: 3px;
    color: #73272F;
    padding: 12px 29px;
    text-align: center;
    text-decoration: none;
    float: left;
    display: inline-block;
    font-size: 16px;
        
    }   
            
            
        </style>
    </head>
    <body>      
        <form class="button" >
            <button   formaction="/CivilRegisterSystem/index.html">Logout</button>>
        </form>>
        
        <form class="main">
       <% 
           MongoClient mongo = new MongoClient("localhost", 27017 ); 
            
            DB db = mongo.getDB("CivilDB");
           DBCollection colReqForm = db.getCollection("RequestForm");
           DBCollection colUserReg = db.getCollection("UserReg");
           DBCollection colDeathReg = db.getCollection("DeathReg");
           

 //BirthCert!          
           BasicDBObject whereQuery = new BasicDBObject();  
           whereQuery.append("reqBCer", true);
           whereQuery.append("errBCer",false);
           whereQuery.append("verBCer", false);
           DBCursor cursor = colReqForm.find(whereQuery);
           List<DBObject> reqBcerobj = cursor.toArray();
           out.println("<table id=\"user\">");
           out.println("<tr>\n" +
                "    <th><center>Birth Certificate Requests<br>Email</center></th>\n" +
                "  </tr>");
           
           for(int i=0;i<reqBcerobj.size();i++){
               
               String emailid = reqBcerobj.get(i).get("email").toString();
               out.println("<tr>\n" +
                "<td>"+ "<a href=\"adminviewbc.jsp?email=" + emailid +"\">" + emailid + "</a>" +       
                "</td>\n" +
                "</tr>");
            }
           out.println("</table>");
           //out.println("<br>");
          
           //Passport           
           BasicDBObject whereQuery1 = new BasicDBObject();  
           whereQuery1.append("reqPassport", true);
           whereQuery1.append("errPassport",false);
           whereQuery1.append("verPassport", false);
           DBCursor cursor1 = colReqForm.find(whereQuery1);
           List<DBObject> reqPassport = cursor1.toArray();
           out.println("<table id=\"user\">");
           out.println("<tr>\n" +
                "    <th><center><b>Passport Requests<br>Email</center></th>\n" +
                "  </tr>");
           
           for(int i=0;i<reqPassport.size();i++){
               
               String emailid = reqPassport.get(i).get("email").toString();
               out.println("<tr>\n" +
                "<td>"+ "<a href=\"adminviewpp.jsp?email=" + emailid +"\">" + emailid + "</a>" +       
                "</td>\n" +
                "</tr>");
            }
           out.println("</table>");

         
           

        //ListofUsers
           DBCursor cursor2 = colUserReg.find();
           List<DBObject> listUsers = cursor2.toArray();
           out.println("<table id=\"user\">");
           out.println("<tr>\n" +
                "    <th><center><b>List of Users<br>Email</center></th>\n" +
                "  </tr>");
           
           for(int i=0;i<listUsers.size();i++){
               
               String emailid = listUsers.get(i).get("email").toString();                 
               DBObject whereQuery2 = new BasicDBObject();
            whereQuery2.put("email", emailid);
            Gson gson = new Gson();
            DBObject dbobj = colDeathReg.findOne(whereQuery2);
            if(dbobj.get("dead").toString() == "true" ){                
                continue;  
            }
            out.println("<tr>\n" +
                "<td>"+ "<a href=\"createDeathCert.jsp?email=" + emailid +"\">" + emailid + "</a>" +       
                "</td>\n" +
                "</tr>");
            
            }
           out.println("</table>");


           
%>
        </form>

    </body>
</html>
