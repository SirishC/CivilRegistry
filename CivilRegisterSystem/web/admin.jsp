<%-- 
    Document   : admin
    Created on : 14 Oct, 2018, 6:16:33 PM
    Author     : Ravibalg
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
        <title>Admin Page</title>
    </head>
    <body>
       <% 
           MongoClient mongo = new MongoClient("localhost", 27017 ); 
            
            DB db = mongo.getDB("CivilDB");
           DBCollection colReqForm = db.getCollection("RequestForm");

 //BirthCert!
           out.println("Birth-Cert Requests");
           BasicDBObject whereQuery = new BasicDBObject();  
           whereQuery.append("reqBCer", true);
           whereQuery.append("errBCer",false);
           whereQuery.append("verBCer", false);
           DBCursor cursor = colReqForm.find(whereQuery);
           List<DBObject> reqBcerobj = cursor.toArray();
           out.println("<table>");
           out.println("<tr>\n" +
                "    <th>Email</th>\n" +
                "  </tr>");
           
           for(int i=0;i<reqBcerobj.size();i++){
               
               String emailid = reqBcerobj.get(i).get("email").toString();
               out.println("<tr>\n" +
                "<td>"+ "<a href=\"adminviewbc.jsp?email=" + emailid +"\">" + emailid + "</a>" +       
                "</td>\n" +
                "</tr>");
            }
           out.println("</table>");
           out.println("<br>");
          
           //Passport
           out.println("Passport Requests");
           BasicDBObject whereQuery1 = new BasicDBObject();  
           whereQuery1.append("reqPassport", true);
           whereQuery1.append("errPassport",false);
           whereQuery1.append("verPassport", false);
           DBCursor cursor1 = colReqForm.find(whereQuery1);
           List<DBObject> reqPassport = cursor1.toArray();
           out.println("<table>");
           out.println("<tr>\n" +
                "    <th>Email</th>\n" +
                "  </tr>");
           
           for(int i=0;i<reqPassport.size();i++){
               
               String emailid = reqPassport.get(i).get("email").toString();
               out.println("<tr>\n" +
                "<td>"+ "<a href=\"adminviewpp.jsp?email=" + emailid +"\">" + emailid + "</a>" +       
                "</td>\n" +
                "</tr>");
            }
           out.println("</table>");

           out.println("</table>");

           
%>

    </body>
</html>
