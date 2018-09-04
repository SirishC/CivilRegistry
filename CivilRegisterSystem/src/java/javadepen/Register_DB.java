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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register_DB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register_DB at " + request.getContextPath() + "</h1>");
            
            
            
             
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
            
            MongoClient mongo = new MongoClient("localhost", 27017 ); 
            
            DB db = mongo.getDB("CivilDB");
            
            DBCollection colUserReg = db.getCollection("UserReg");
            DBCollection colUserGender = db.getCollection("UserGender");
            DBCollection colUserLoc = db.getCollection("UserLoc");
            
            
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("email", email);
                DBCursor cursor = colUserReg.find(whereQuery);
            if(!cursor.hasNext()) {
            Gson gson = new Gson();
            BasicDBObject objUserReg = (BasicDBObject)JSON.parse(gson.toJson(userReg));
            BasicDBObject objUserGender = (BasicDBObject)JSON.parse(gson.toJson(userGender));
            BasicDBObject objUserLoc = (BasicDBObject)JSON.parse(gson.toJson(userLoc));
            colUserReg.insert(objUserReg);
            colUserGender.insert(objUserGender);
            colUserLoc.insert(objUserLoc);
            }
            else{
                response.setContentType("text/html");  
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Already exisits');");  
                out.println("</script>");
            }
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
