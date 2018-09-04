package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class birthcertification_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Birth Certification</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"birth.css\" media=\"all\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script src=\"birth.js\"></script>\n");
      out.write("        <h1>Ravi Topper !</h1>\n");
      out.write("       <form id=\"msform\" action =\"/CivilRegisterSystem/logincheck\"> \n");
      out.write("         <fieldset>\n");
      out.write("    <h2 class=\"fs-title\">Login</h2>\n");
      out.write("    <h3 class=\"fs-subtitle\">Find comfort in the chaos.</h3>\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />    \n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" /><input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"email\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <input type=\"password\" name=\"pass\" placeholder=\"Password\" />\n");
      out.write("    <input type=\"submit\" name=\"submit\" class=\"submit action-button\" value=\"Login\" />\n");
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
