package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.BasicDBObject;

public final class adminviewbc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Birth Certification</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"birth.css\" media=\"all\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            //Printing BC
            String email = request.getParameter("email");
           MongoClient mongo = new MongoClient("localhost", 27017 );             
            DB db = mongo.getDB("CivilDB");
           DBCollection colBirthReg = db.getCollection("BirthReg");
           DBCollection colBirthParetnInfo = db.getCollection("BirthParetnInfo");
           DBCollection colBirthBasicInfo  = db.getCollection("BirthBasicInfo");
           DBCollection colBirthHospital  = db.getCollection("BirthHospital");
           DBCollection colUserGender  = db.getCollection("UserGender");
           DBCollection colUserLoc  = db.getCollection("UserLoc");
           DBCollection colUserReg  = db.getCollection("UserReg");
           
           
            DBObject whereQuery = new BasicDBObject();
             whereQuery.put("email", email);            
             DBObject dbobjBirthReg = colBirthReg.findOne(whereQuery);
             DBObject dbobjBirthParetnInfo = colBirthParetnInfo.findOne(whereQuery);
             DBObject dbobjBirthBasicInfo = colBirthBasicInfo.findOne(whereQuery);
             DBObject dbobjUserGender = colUserGender.findOne(whereQuery);
             DBObject dbobjUserReg = colUserReg.findOne(whereQuery);
             DBObject whereQuery2 = new BasicDBObject();
             //whereQuery2.put("addr", dbobjUserReg.get("addr").toString());              
             DBObject dbobjUserLoc = colUserLoc.findOne(whereQuery2);
             DBObject whereQuery1 = new BasicDBObject();
             //whereQuery1.put("hospitalAddr", dbobjBirthReg.get("hospitaladdr").toString()); 
             DBObject dbobjBirthHospital = colBirthHospital.findOne(whereQuery1);

             
             //BirthReg             
             String maddr = dbobjBirthReg.get("addr").toString();
             String mhospitaladdr = dbobjBirthReg.get("hospitaladdr").toString();
             String mdelTime = dbobjBirthReg.get("delTime").toString();
             //BirthParentInfo
             String mmothername = dbobjBirthParetnInfo.get("mothername").toString();
             String mmotheroccupation = dbobjBirthParetnInfo.get("motheroccupation").toString();
             String mfathername = dbobjBirthParetnInfo.get("fathername").toString();
             String mfatheroccupation = dbobjBirthParetnInfo.get("fatheroccupation").toString();
             //BirthInfo
             String mfname = dbobjBirthBasicInfo.get("fname").toString();
             String mlname = dbobjBirthBasicInfo.get("lname").toString();
             String mdob = dbobjBirthBasicInfo.get("dob").toString();
             //BirthHospital            
             String mhospitalName = dbobjBirthHospital.get("hospitalName").toString();
             //UserReg
             String mgender = dbobjUserGender.get("gender").toString();
             //UserLoc
             String mcity = dbobjUserLoc.get("city").toString();             
           
        
      out.write("\n");
      out.write("        <script src=\"birth.js\"></script>       \n");
      out.write("       <form id=\"msform\" > \n");
      out.write("         <fieldset>\n");
      out.write("             <input type=\"text\" name=\"email\" value=");
      out.print(email);
      out.write(">\n");
      out.write("    <h2 class=\"fs-title\">Birth Certificate</h2>    \n");
      out.write("    <p>Name</p>\n");
      out.write("    <input type=\"text\" name=\"fname\" value=");
      out.print(mfname);
      out.write(" readonly />\n");
      out.write("    <input type=\"text\" name=\"lname\" value=");
      out.print(mlname);
      out.write(" readonly /><br>\n");
      out.write("    <p>Date of Birth</p> \n");
      out.write("    <input type=\"text\" name=\"dob\" value=");
      out.print(mdob);
      out.write(" readonly /><br>\n");
      out.write("    <p>Gender</p> \n");
      out.write("    <input type=\"text\" name=\"gender\" value=");
      out.print(mgender);
      out.write(" readonly /><br>\n");
      out.write("    <p>Parents</p>\n");
      out.write("    <input type=\"text\" name=\"fathername\" value=");
      out.print(mfathername);
      out.write(" readonly />\n");
      out.write("    <input type=\"text\" name=\"mothername\" value=");
      out.print(mmothername);
      out.write(" readonly /><br>\n");
      out.write("    <p>Occupation</p>\n");
      out.write("    <input type=\"text\" name=\"fatheroccupation\" value=");
      out.print(mfatheroccupation);
      out.write(" readonly />\n");
      out.write("    <input type=\"text\" name=\"motheroccupation\" value=");
      out.print(mmotheroccupation);
      out.write(" readonly /><br>\n");
      out.write("    <p>City</p>\n");
      out.write("    <input type=\"text\" name=\"city\"value=");
      out.print(mcity);
      out.write(" readonly /><br>\n");
      out.write("    <p>Address</p>\n");
      out.write("    <textarea name=\"address\" readonly>");
      out.print(maddr);
      out.write("</textarea> <br>\n");
      out.write("       <p>Hospital Name </p>\n");
      out.write("    <input type=\"text\" name=\"hospitalname\"  value=");
      out.print(mhospitalName);
      out.write(" readonly /><br>\n");
      out.write("    <p>Hospital Address</p>    \n");
      out.write("    <textarea name=\"hospitaladdress\"   readonly>");
      out.print(mhospitaladdr);
      out.write("</textarea> <br>\n");
      out.write("    <p>Delivery Time </p>\n");
      out.write("    <input type=\"text\" name=\"deltime\"  value=");
      out.print(mdelTime);
      out.write(" readonly/><br>\n");
      out.write("    <input type=\"submit\" name=\"submit\" class=\"action-button\" formaction=\"/CivilRegisterSystem/AdminVerified\" value=\"Approve\" />\n");
      out.write("    <input type=\"submit\" name=\"submit\" class=\"action-button\" formaction=\"/CivilRegisterSystem/AdminDisApproved\" value=\"DisApprove\" />\n");
      out.write("    <input type=\"hidden\" name=\"whatverified\" value=\"birthcert\">\n");
      out.write("  </fieldset>   \n");
      out.write("</form>\n");
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
