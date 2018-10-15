/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadepen;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DatabasePOJO.*;
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
public class PassportReg_DB extends HttpServlet {

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
            out.println("<title>Servlet PassportReg_DB</title>");            
            out.println("</head>");
            out.println("<body>");
            
              String email = request.getParameter("email");
             
            
            //String fname = request.getParameter("fname");
            //String lname = request.getParameter("lname");
            //String dob = request.getParameter("dob");
            //String gender = request.getParameter("gender");
            
            String maritalstat = request.getParameter("maritalstat");
            String employmentstat = request.getParameter("emplomentstat");
            String eduqual = request.getParameter("eduqual");
            
            //String mothername = request.getParameter("mothername");
            //String fathername = request.getParameter("fathername");

            //String city = request.getParameter("city");
            String address = request.getParameter("address");
            
            String por = request.getParameter("por");
            String dor = request.getParameter("dor");
            
            UserMaritalStatus userMaritalStatus = new UserMaritalStatus(email, maritalstat);
            UserEmpType userEmpType = new UserEmpType(email, employmentstat);
            UserEduQual userEduQual = new UserEduQual(email, eduqual);
            PassportReg passportReg = new PassportReg(email, address, null, por, dor);
            
            MongoClient mongo = new MongoClient("localhost", 27017 ); 
            
            DB db = mongo.getDB("CivilDB");
            
            DBCollection colUserMaritalStatus = db.getCollection("UserMaritalStatus");
            DBCollection colUserEmpType = db.getCollection("UserEmpType");
            DBCollection colUserEduQual = db.getCollection("UserEduQual");
            DBCollection colPassportReg = db.getCollection("PassportReg");
            
            Gson gson = new Gson();
            BasicDBObject objUserMaritalStatus = (BasicDBObject)JSON.parse(gson.toJson(userMaritalStatus));
            BasicDBObject objUserEmpType = (BasicDBObject)JSON.parse(gson.toJson(userEmpType));
            BasicDBObject objUserEduQual = (BasicDBObject)JSON.parse(gson.toJson(userEduQual));
            BasicDBObject objPassportReg = (BasicDBObject)JSON.parse(gson.toJson(passportReg));
            
            colUserMaritalStatus.insert(objUserMaritalStatus);
            colUserEmpType.insert(objUserEmpType);
            colUserEduQual.insert(objUserEduQual);
            colPassportReg.insert(objPassportReg);
            
            //update ReqForm  
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("email", email);
            DBCollection colRequestForm = db.getCollection("RequestForm");
            BasicDBObject newDocument = new BasicDBObject();
            newDocument.append("$set", new BasicDBObject().append("reqPassport", true));
            colRequestForm.update(whereQuery, newDocument); 
            
            
                
            out.println("I GOtiT!\n-MongoDB");
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
