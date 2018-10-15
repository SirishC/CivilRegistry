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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BirthReg_DB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BirthReg_DB at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet BirthReg_DB at " + request.getContextPath() + "</h1>");
            
           
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
