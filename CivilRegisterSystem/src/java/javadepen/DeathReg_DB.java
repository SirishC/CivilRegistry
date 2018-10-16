/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadepen;

import DatabasePOJO.DeathReg;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ravibalg
 */
@WebServlet(name = "DeathReg_DB", urlPatterns = {"/DeathReg_DB"})
public class DeathReg_DB extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeathReg_DB</title>");            
            out.println("</head>");
            out.println("<body>");

            String email = request.getParameter("email");
            MongoClient mongo = new MongoClient("localhost", 27017 ); 
            
            DB db = mongo.getDB("CivilDB");
            DBCollection colDeathReg = db.getCollection("DeathReg");
          
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("email", email);
            BasicDBObject newDocument1 = new BasicDBObject();
            newDocument1.append("$set", new BasicDBObject().append("dead", true));         
            colDeathReg.update(whereQuery, newDocument1);
            
            //Deletion
        DBCollection colRequestForm = db.getCollection("RequestForm");
            BasicDBObject document = new BasicDBObject();
            document.put("email", email);
            colRequestForm.remove(document);
            
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
"      <form action = \"/CivilRegisterSystem/admin.jsp\">\n" +
"        <p><b>Successfully Removed the  </b><br> User : "+email+"</p><br>\n" +
"        <input type = \"submit\" value = \"back\">\n" +
"      </form>\n" +
"   </body>\n" +
"</html>");
            
            out.println("</body>");
            out.println("</html>");
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
