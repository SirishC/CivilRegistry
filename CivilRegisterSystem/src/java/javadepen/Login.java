/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadepen;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sirish
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            out.println("<title>Servlet Login</title>"); 
            out.println("<style>/*\n" +
"To change this license header, choose License Headers in Project Properties.\n" +
"To change this template file, choose Tools | Templates\n" +
"and open the template in the editor.\n" +
"*/\n" +
"/* \n" +
"    Created on : 2 Sep, 2018, 5:48:41 PM\n" +
"    Author     : sirish\n" +
"*/\n" +
"\n" +
"/*custom font*/\n" +
"@import url(https://fonts.googleapis.com/css?family=Montserrat);\n" +
"\n" +
"/*basic reset*/\n" +
"* {margin: 0; padding: 0;}\n" +
"\n" +
"html {\n" +
"	height: 100%;\n" +
"	/*Image only BG fallback*/\n" +
"	\n" +
"	/*background = gradient + image pattern combo*/\n" +
"	background: \n" +
"		linear-gradient(rgba(0, 0, 0,1),rgba(115,39,47,1));\n" +
"}\n" +
"\n" +
"body {\n" +
"	font-family: montserrat, arial, verdana;\n" +
"}\n" +
"/*form styles*/\n" +
"#msform {\n" +
"	width: 400px;\n" +
"	margin: 50px auto;\n" +
"	text-align: center;\n" +
"	position: relative;\n" +
"}\n" +
"#msform fieldset {\n" +
"	background: white;\n" +
"	border: 0 none;\n" +
"	border-radius: 3px;\n" +
"	box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);\n" +
"	padding: 20px 30px;\n" +
"	box-sizing: border-box;\n" +
"	width: 80%;\n" +
"	margin: 0 10%;\n" +
"	\n" +
"	/*stacking fieldsets above each other*/\n" +
"	position: relative;\n" +
"}\n" +
"/*Hide all except first fieldset*/\n" +
"#msform fieldset:not(:first-of-type) {\n" +
"	display: none;\n" +
"}\n" +
"/*inputs*/\n" +
"#msform input, #msform textarea {\n" +
"	padding: 15px;\n" +
"	border: 1px solid #ccc;\n" +
"	border-radius: 3px;\n" +
"	margin-bottom: 10px;\n" +
"	width: 100%;\n" +
"	box-sizing: border-box;\n" +
"	font-family: montserrat;\n" +
"	color: #881c2f;\n" +
"	font-size: 13px;\n" +
"}\n" +
"/*buttons*/\n" +
"#msform .action-button {\n" +
"	width: 100px;\n" +
"	background: #881c2f;\n" +
"	font-weight: bold;\n" +
"	color: white;\n" +
"	border: 0 none;\n" +
"	border-radius: 1px;\n" +
"	cursor: pointer;\n" +
"	padding: 10px 5px;\n" +
"	margin: 10px 5px;\n" +
"}\n" +
"#msform .action-button:hover, #msform .action-button:focus {\n" +
"	box-shadow: 0 0 0 2px white, 0 0 0 3px #881c2f;\n" +
"}\n" +
"/*headings*/\n" +
".fs-title {\n" +
"	font-size: 15px;\n" +
"	text-transform: uppercase;\n" +
"	color: #881c2f;\n" +
"	margin-bottom: 10px;\n" +
"}\n" +
".fs-subtitle {\n" +
"	font-weight: normal;\n" +
"	font-size: 13px;\n" +
"	color: #666;\n" +
"	margin-bottom: 20px;\n" +
"}\n" +
"/*progressbar*/\n" +
"#progressbar {\n" +
"	margin-bottom: 30px;\n" +
"	overflow: hidden;\n" +
"	/*CSS counters to number the steps*/\n" +
"	counter-reset: step;\n" +
"}\n" +
"#progressbar li {\n" +
"	list-style-type: none;\n" +
"	color: white;\n" +
"	text-transform: uppercase;\n" +
"	font-size: 9px;\n" +
"	width: 33.33%;\n" +
"	float: left;\n" +
"	position: relative;        \n" +
"}\n" +
"#progressbar li:before {\n" +
"	content: counter(step);\n" +
"	counter-increment: step;\n" +
"	width: 20px;\n" +
"	line-height: 20px;\n" +
"	display: block;\n" +
"	font-size: 10px;\n" +
"	color: #881c2f;\n" +
"	background: white;\n" +
"	border-radius: 3px;\n" +
"	margin: 0 auto 5px auto;\n" +
"}\n" +
"/*progressbar connectors*/\n" +
"#progressbar li:after {\n" +
"	content: '';\n" +
"	width: 100%;\n" +
"	height: 2px;\n" +
"	background: white;\n" +
"	position: absolute;\n" +
"	left: -50%;\n" +
"	top: 9px;\n" +
"	z-index: -1; /*put it behind the numbers*/\n" +
"}\n" +
"#progressbar li:first-child:after {\n" +
"	/*connector not needed before the first step*/\n" +
"	content: none; \n" +
"}\n" +
"/*marking active/completed steps green*/\n" +
"/*The number of the step and the connector before it = green*/\n" +
"#progressbar li.active:before,  #progressbar li.active:after{\n" +
"	background: #881c2f;\n" +
"	color: white;\n" +
"}\n" +
"\n" +
"\n" +
"\n" +
"/* Radio buttons !*/\n" +
"\n" +
"\n" +
"\n" +
".radio-containe {\n" +
"  position: relative;\n" +
"}\n" +
"\n" +
".radio-container input{\n" +
"  opacity: 0;\n" +
"  cursor: pointer;\n" +
"}\n" +
"\n" +
".radio-container input:checked ~ .custom-check {\n" +
"  background-color: transparent;\n" +
"  border: 4px solid #881c2f;\n" +
"  opacity: 1;\n" +
"  \n" +
"}\n" +
"\n" +
"\n" +
"\n" +
"\n" +
".custom-check {\n" +
"  position: absolute;\n" +
"\n" +
"  border-radius: 50%;\n" +
"  cursor: pointer;\n" +
"  width: 50px;\n" +
"  height: 50px;\n" +
"  border: none;\n" +
"  padding: 3px;\n" +
"  left: 50%;\n" +
"  top: 60%;\n" +
"  -webkit-transform: translate(-50%, -50%);\n" +
"     -moz-transform: translate(-50%, -50%);\n" +
"       -o-transform: translate(-50%, -50%);\n" +
"          transform: translate(-50%, -50%);\n" +
"}\n" +
"\n" +
"\n" +
".custom-check img {\n" +
"  position: absolute;\n" +
"  color: white;\n" +
"  width: 20px;\n" +
"  left: 50%;\n" +
"  top: 50%;\n" +
"  -webkit-transform: translate(-50%, -50%);\n" +
"     -moz-transform: translate(-50%, -50%);\n" +
"       -o-transform: translate(-50%, -50%);\n" +
"          transform: translate(-50%, -50%);\n" +
"}</style>");
            out.println("</head>");
            out.println("<body>");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            
            MongoClient mongo = new MongoClient("localhost",27017);
            DB db = mongo.getDB("CivilDB");
            DBCollection dBCollection = db.getCollection("UserReg");
            DBObject whereQuery = new BasicDBObject();
            whereQuery.put("email", email);
            DBObject dbobj = dBCollection.findOne(whereQuery);
            if(dbobj == null){
                 response.setContentType("text/html");  
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Account Not Found');");  
                out.println("</script>");
            }
            else{
                String dbpass = dbobj.get("pass").toString();
                 if(!pass.equals(dbpass)){                                       
                response.setContentType("text/html");  
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Password Wrong');");  
                out.println("</script>");                
                    }
                 else{
                     //forward to HomePage!
                     out.println("<h1>Welcome , Sirish </h1>");
                     request.setAttribute("email", email);
                     RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/user.jsp");
            requestDispatcher.forward(request, response);
            out.println("<form><form>");
                                           
                 }
            }

            
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
