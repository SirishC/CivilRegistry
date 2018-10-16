package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DatabasePOJO.RequestForm;
import com.google.gson.Gson;
import java.util.List;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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


            
        
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"signstyle.css\" media=\"all\" />         \n");
      out.write("        <title>Welcome</title>        \n");
      out.write("        <style>\n");
      out.write("            .main{\n");
      out.write("                background: white;\n");
      out.write("\tborder: 0 none;\n");
      out.write("\tborder-radius: 3px;\n");
      out.write("\tbox-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.4);\n");
      out.write("\tpadding: 20px 30px;\n");
      out.write("\tbox-sizing: border-box;\n");
      out.write("\twidth: 80%;\n");
      out.write("\tmargin: 5% 5%;  \n");
      out.write("        padding-bottom: 35%;\n");
      out.write("        \t\n");
      out.write("            }\n");
      out.write("            input,textarea{\n");
      out.write("                padding: 15px;\n");
      out.write("\tborder: 1px solid #ccc;\n");
      out.write("\tborder-radius: 3px;\n");
      out.write("\tmargin-bottom: 10px;\n");
      out.write("\twidth: 60%;\n");
      out.write("\tbox-sizing: border-box;\n");
      out.write("\tfont-family: montserrat;\n");
      out.write("\tcolor: #881c2f;\n");
      out.write("\tfont-size: 13px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("            \n");
      out.write("        <form class=\"main\">\n");
      out.write("            \n");
      out.write("            <h1>Welcome,");
      out.print(mfname+" "+mlname);
      out.write("</h1><br>\n");
      out.write("            <input type=\"text\" value=");
      out.print(email);
      out.write(" readonly><br>\n");
      out.write("            <input type=\"text\" value=");
      out.print(mphno);
      out.write(" readonly><br>\n");
      out.write("            <textarea cols=\"10\" rows=\"5\">");
      out.print(maddr);
      out.write("</textarea><br>    \n");
      out.write("            <input type=\"submit\" value=\"BirthCertificate\">\n");
      out.write("            <input type=\"text\"  name=\"statusBcer\" value=");
      out.print(statusBCer);
      out.write(">\n");
      out.write("            <input type=\"submit\" value=\"Passport\">\n");
      out.write("            <input type=\"text\"  name=\"statusPP\" value=");
      out.print(statusPassport);
      out.write(">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("         \n");
      out.write("<!--             <input type=\"text\" name=\"email\" value=");
      out.print(email);
      out.write(" readonly >\n");
      out.write("             <a href=\"/CivilRegisterSystem/index.html\">SignOut</a><br>\n");
      out.write("        <a href=\"/CivilRegisterSystem/birthcertification.jsp?email=");
      out.print(email);
      out.write("\">Apply for Birth-Cert</a><br>\n");
      out.write("        <a href=\"/CivilRegisterSystem/passport.jsp?email=");
      out.print(email);
      out.write("\">Apply for Passport</a><br>-->\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
