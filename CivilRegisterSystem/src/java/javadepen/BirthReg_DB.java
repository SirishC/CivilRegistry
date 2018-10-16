/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadepen;

import DatabasePOJO.BirthBasicInfo;
import DatabasePOJO.BirthHospital;
import DatabasePOJO.BirthParentInfo;
import DatabasePOJO.BirthReg;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sirish
 */
public class BirthReg_DB extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            
           // geting the details form the form
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String mothername = request.getParameter("mothername");

            String fathername = request.getParameter("fathername");
            String motheroccupation = request.getParameter("motheroccupation");
            String fatheroccupation = request.getParameter("fatheroccupation");

            String city = request.getParameter("city");
            String address = request.getParameter("address");
            
            String hospitalname = request.getParameter("hospitalname");
            String hospitaladdress = request.getParameter("hospitaladdress");
            String deltime = request.getParameter("deltime");
            
            String email = request.getParameter("email");
            
            BirthBasicInfo birthBasicInfo = new BirthBasicInfo(email, fname, lname, dob);
            BirthReg birthReg = new BirthReg(email, address, hospitaladdress, deltime);
            BirthParentInfo birthParentInfo = new BirthParentInfo(email, mothername, motheroccupation, null, fathername, fatheroccupation, null);
            BirthHospital birthHospital = new BirthHospital(hospitaladdress, hospitalname);
            
             MongoClient mongo = new MongoClient("localhost", 27017 ); 
            
            DB db = mongo.getDB("CivilDB");
            
            DBCollection colBirthBasicInfo = db.getCollection("BirthBasicInfo");
            DBCollection colBirthReg = db.getCollection("BirthReg");
            DBCollection colBirthParetnInfo = db.getCollection("BirthParetnInfo");
            DBCollection colBirthHospital = db.getCollection("BirthHospital");
            
            Gson gson = new Gson();
            BasicDBObject objBirthBasicInfo = (BasicDBObject)JSON.parse(gson.toJson(birthBasicInfo));
            BasicDBObject objBirthReg = (BasicDBObject)JSON.parse(gson.toJson(birthReg));
            BasicDBObject objBirthParetnInfo = (BasicDBObject)JSON.parse(gson.toJson(birthParentInfo));
            BasicDBObject objBasicHospital = (BasicDBObject)JSON.parse(gson.toJson(birthHospital));
            colBirthBasicInfo.insert(objBirthBasicInfo);
            colBirthReg.insert(objBirthReg);
            colBirthParetnInfo.insert(objBirthParetnInfo);
            colBirthHospital.insert(objBasicHospital);
            //update ReqForm
             BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("email", email);
            DBCollection colRequestForm = db.getCollection("RequestForm");
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.append("$set", new BasicDBObject().append("reqBCer", true));         
            colRequestForm.update(whereQuery, newDocument);       
            
            
          // Page Display !!
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
"      <form action = \"/CivilRegisterSystem/user.jsp\">\n" +
"        <p><b>BirthCertificate</b><br>Successfully Applied</p><br>\n" +
"        <input type = \"submit\" value = \"back\">\n" +
"      </form>\n" +
"   </body>\n" +
"</html>");
            
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
