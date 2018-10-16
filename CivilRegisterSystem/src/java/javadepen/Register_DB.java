package javadepen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DatabasePOJO.*;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author Ravibalg
 */
public class Register_DB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String cpass = request.getParameter("cpass");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String gender = request.getParameter("gender");
            String city = request.getParameter("city");
            String phno = request.getParameter("phno");
            String address = request.getParameter("address");
            
            
            UserReg userReg = new UserReg(email, pass, fname, lname, phno, address);
            UserGender userGender = new UserGender(email, gender);
            UserLoc userLoc = new UserLoc(address, city,null,null,null);
            DeathReg deathReg = new DeathReg(email,false);
            RequestForm requestForm = new RequestForm(email, false, false, false, false,false,false);
            MongoClient mongo = new MongoClient("localhost", 27017 ); 
            
            DB db = mongo.getDB("CivilDB");
            
            DBCollection colUserReg = db.getCollection("UserReg");
            DBCollection colUserGender = db.getCollection("UserGender");
            DBCollection colUserLoc = db.getCollection("UserLoc");
            DBCollection colReqForm = db.getCollection("RequestForm");
            DBCollection colDeathReg = db.getCollection("DeathReg");
            
            
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("email", email);
                DBCursor cursor = colUserReg.find(whereQuery);
            if(!cursor.hasNext()) {
                Gson gson = new Gson();
            
                
            BasicDBObject objDeathReg = (BasicDBObject)JSON.parse(gson.toJson(deathReg));    
            BasicDBObject objUserReg = (BasicDBObject)JSON.parse(gson.toJson(userReg));
            BasicDBObject objUserGender = (BasicDBObject)JSON.parse(gson.toJson(userGender));
            BasicDBObject objUserLoc = (BasicDBObject)JSON.parse(gson.toJson(userLoc));
            BasicDBObject objReqForm = (BasicDBObject)JSON.parse(gson.toJson(requestForm));
            colUserReg.insert(objUserReg);
            colUserGender.insert(objUserGender);
            colUserLoc.insert(objUserLoc);
            colReqForm.insert(objReqForm);
            colDeathReg.insert(objDeathReg);
            out.println("<html>\n" +
"<head>\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    <title>Sign Up </title>\n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Nanum+Gothic\" rel=\"stylesheet\">\n" +
"    <style>\n" +
"    @import url(https://fonts.googleapis.com/css?family=Montserrat);\n" +
"    html{\n" +
"      height: 100%;\n" +
"	background:\n" +
"		linear-gradient(rgba(0, 0, 0,1),rgba(115,39,47,1));\n" +
"    }\n" +
"    body{\n" +
"    padding-top: 14.5%;\n" +
"      text-align: center;\n" +
"      font-family: montserrat, arial, verdana;\n" +
"    }\n" +
"       input,textarea{\n" +
"width: 80%;\n" +
"padding: 12px 20px;\n" +
"margin: 8px 0;\n" +
"border: 1px solid #ccc;\n" +
"border-radius: 4px;\n" +
"box-sizing: border-box;\n" +
"display:inline-block;\n" +
"font-family: montserrat, arial, verdana;\n" +
"}\n" +
"button{\n" +
"  padding: 10px 20px;\n" +
"    color: black;\n" +
"    border: 0 none;\n" +
"    text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);\n" +
"    background: rgba(255, 235, 59, 1);\n" +
"    font-family: montserrat, arial, verdana;\n" +
"    border-color: black;\n" +
"    box-shadow: 0 0 2px 1px rgba(0, 0, 0, 0.4);\n" +
"\n" +
"}\n" +
"h1{\n" +
"  padding-top: 10%;\n" +
"}\n" +
"\n" +
"form{\n" +
"\n" +
"  padding-top: 20%;\n" +
"  background: white;\n" +
"  border: 0 none;\n" +
"  border-radius: 3px;\n" +
"  box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);\n" +
"  padding: 50px 10px;\n" +
"  box-sizing: border-box;\n" +
"  margin: 0 35%;\n" +
"  font-family: montserrat, arial, verdana;\n" +
"\n" +
"}\n" +
"        </style>\n" +
"</head>\n" +
"   <body>\n" +
"      <form action = \"/CivilRegisterSystem/index.html\">\n" +
"        <p><b>Successfully Signed Up</b><br>ThankYou For Using Our Service.</p><br>\n" +
"        <input type = \"submit\" value = \"back\">\n" +
"      </form>\n" +
"   </body>\n" +
"</html>");
            }
            else{      
                
                out.println("<html>\n" +
"<head>\n" +
"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    <title>Sign Up </title>\n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Nanum+Gothic\" rel=\"stylesheet\">\n" +
"    <style>\n" +
"    @import url(https://fonts.googleapis.com/css?family=Montserrat);\n" +
"    html{\n" +
"      height: 100%;\n" +
"	background:\n" +
"		linear-gradient(rgba(0, 0, 0,1),rgba(115,39,47,1));\n" +
"    }\n" +
"    body{\n" +
"    padding-top: 14.5%;\n" +
"      text-align: center;\n" +
"      font-family: montserrat, arial, verdana;\n" +
"    }\n" +
"       input,textarea{\n" +
"width: 80%;\n" +
"padding: 12px 20px;\n" +
"margin: 8px 0;\n" +
"border: 1px solid #ccc;\n" +
"border-radius: 4px;\n" +
"box-sizing: border-box;\n" +
"display:inline-block;\n" +
"font-family: montserrat, arial, verdana;\n" +
"}\n" +
"button{\n" +
"  padding: 10px 20px;\n" +
"    color: black;\n" +
"    border: 0 none;\n" +
"    text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);\n" +
"    background: rgba(255, 235, 59, 1);\n" +
"    font-family: montserrat, arial, verdana;\n" +
"    border-color: black;\n" +
"    box-shadow: 0 0 2px 1px rgba(0, 0, 0, 0.4);\n" +
"\n" +
"}\n" +
"h1{\n" +
"  padding-top: 10%;\n" +
"}\n" +
"\n" +
"form{\n" +
"\n" +
"  padding-top: 20%;\n" +
"  background: white;\n" +
"  border: 0 none;\n" +
"  border-radius: 3px;\n" +
"  box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);\n" +
"  padding: 50px 10px;\n" +
"  box-sizing: border-box;\n" +
"  margin: 0 35%;\n" +
"  font-family: montserrat, arial, verdana;\n" +
"\n" +
"}\n" +
"        </style>\n" +
"</head>\n" +
"   <body>\n" +
"      <form action = \"/CivilRegisterSystem/index.html\">\n" +
"        <p><b>Signed Up Unsuccessful </b><br>The Given Email Already Exist </p><br>\n" +
"        <input type = \"submit\" value = \"back\">\n" +
"      </form>\n" +
"   </body>\n" +
"</html>");
               
            }           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
