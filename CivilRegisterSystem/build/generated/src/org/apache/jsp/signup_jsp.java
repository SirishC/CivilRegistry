package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Sign Up !</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"signstyle.css\" media=\"all\" />         \n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("     \n");
      out.write("        <h1s style=\"color: white\">Ravi Balaji Topper !!<h1>\n");
      out.write("        <!-- multistep form -->\n");
      out.write("<form id=\"msform\">\n");
      out.write("  <!-- progressbar -->\n");
      out.write("  <ul id=\"progressbar\">\n");
      out.write("    <li class=\"active\">Account Setup</li>\n");
      out.write("    <li>Personal Details</li>\n");
      out.write("    <li>Contact Details</li>\n");
      out.write("  </ul>\n");
      out.write("  <!-- fieldsets -->\n");
      out.write("  <fieldset>\n");
      out.write("    <h2 class=\"fs-title\">Create your account</h2>\n");
      out.write("    <h3 class=\"fs-subtitle\">This is step 1</h3>\n");
      out.write("    <input type=\"text\" name=\"email\" placeholder=\"Email\" />\n");
      out.write("    <input type=\"password\" name=\"pass\" placeholder=\"Password\" />\n");
      out.write("    <input type=\"password\" name=\"cpass\" placeholder=\"Confirm Password\" />\n");
      out.write("    <input type=\"button\" name=\"next\" class=\"next action-button\" value=\"Next\" />\n");
      out.write("  </fieldset>\n");
      out.write("  <fieldset>\n");
      out.write("    <h2 class=\"fs-title\">Personal Details</h2>\n");
      out.write("    <h3 class=\"fs-subtitle\">We will never sell it</h3>\n");
      out.write("    <input type=\"text\" name=\"fname\" placeholder=\"First Name\" />\n");
      out.write("    <input type=\"text\" name=\"lname\" placeholder=\"Last Name\" />     \n");
      out.write("\n");
      out.write("    \n");
      out.write("    <h4 class=\"fs-subtitle\">Gender</h4>\n");
      out.write("<!-- First Radio Button -->\n");
      out.write("<label class=\"radio-container\"> <!-- Wrapper for all elements -->\n");
      out.write("  <input type=\"radio\" name=\"gender\" value=\"female\"> <!-- Radio Button -->\n");
      out.write("  \n");
      out.write("  <div class=\"custom-check\" style=\"margin-left: 100px;\"> <!-- Custom Radio button style is here -->\n");
      out.write("    <img src=\"https://hamidadib.com/api/venus.png\" alt=\"Mars\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("</label>\n");
      out.write("\n");
      out.write("<!-- Sec Radio Button -->\n");
      out.write("<label class=\"radio-container\">\n");
      out.write("  <input type=\"radio\" name=\"gender\" value=\"male\">\n");
      out.write("  \n");
      out.write("  <div class=\"custom-check\">\n");
      out.write("    <img src=\"https://hamidadib.com/api/mars.png\" alt=\"Mars\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write(" \n");
      out.write("</label>\n");
      out.write("\n");
      out.write("<!-- 3th Radio Button -->\n");
      out.write("<label class=\"radio-container\">\n");
      out.write("  <input type=\"radio\" name=\"gender\" value=\"transgender\">\n");
      out.write("  \n");
      out.write("  <div class=\"custom-check\" style=\"margin-left: -100px;\">\n");
      out.write("    <img src=\"https://hamidadib.com/api/intersex.png\" alt=\"Intersex\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("</label>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <input type=\"button\" name=\"previous\" class=\"previous action-button\" value=\"Previous\" />\n");
      out.write("    <input type=\"button\" name=\"next\" class=\"next action-button\" value=\"Next\" />\n");
      out.write("  </fieldset>  \n");
      out.write("  <fieldset>\n");
      out.write("    <h2 class=\"fs-title\">Contact Details</h2>\n");
      out.write("    <h3 class=\"fs-subtitle\">Your presence on the social network</h3>\n");
      out.write("    <input type=\"number\" name=\"phno\" placeholder=\"+91\" />\n");
      out.write("    <input type=\"text\" name=\"city\" placeholder=\"Eg.chennai\" />\n");
      out.write("    <textarea name=\"address\" placeholder=\"Address\"></textarea> \n");
      out.write("    <input type=\"button\" name=\"previous\" class=\"previous action-button\" value=\"Previous\" />\n");
      out.write("    <input type=\"submit\" name=\"submit\" class=\"submit action-button\" value=\"Submit\" />\n");
      out.write("  </fieldset>\n");
      out.write("  \n");
      out.write("</form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("         <script>\n");
      out.write("            \n");
      out.write("            var current_fs, next_fs, previous_fs; //fieldsets\n");
      out.write("var left, opacity, scale; //fieldset properties which we will animate\n");
      out.write("var animating; //flag to prevent quick multi-click glitches\n");
      out.write("\n");
      out.write("$(\".next\").click(function(){\n");
      out.write("\tif(animating) return false;\n");
      out.write("\tanimating = true;\n");
      out.write("\t\n");
      out.write("\tcurrent_fs = $(this).parent();\n");
      out.write("\tnext_fs = $(this).parent().next();\n");
      out.write("\t\n");
      out.write("\t//activate next step on progressbar using the index of next_fs\n");
      out.write("\t$(\"#progressbar li\").eq($(\"fieldset\").index(next_fs)).addClass(\"active\");\n");
      out.write("\t\n");
      out.write("\t//show the next fieldset\n");
      out.write("\tnext_fs.show(); \n");
      out.write("\t//hide the current fieldset with style\n");
      out.write("\tcurrent_fs.animate({opacity: 0}, {\n");
      out.write("\t\tstep: function(now, mx) {\n");
      out.write("\t\t\t//as the opacity of current_fs reduces to 0 - stored in \"now\"\n");
      out.write("\t\t\t//1. scale current_fs down to 80%\n");
      out.write("\t\t\tscale = 1 - (1 - now) * 0.2;\n");
      out.write("\t\t\t//2. bring next_fs from the right(50%)\n");
      out.write("\t\t\tleft = (now * 50)+\"%\";\n");
      out.write("\t\t\t//3. increase opacity of next_fs to 1 as it moves in\n");
      out.write("\t\t\topacity = 1 - now;\n");
      out.write("\t\t\tcurrent_fs.css({\n");
      out.write("        'transform': 'scale('+scale+')',\n");
      out.write("        'position': 'absolute'\n");
      out.write("      });\n");
      out.write("\t\t\tnext_fs.css({'left': left, 'opacity': opacity});\n");
      out.write("\t\t}, \n");
      out.write("\t\tduration: 800, \n");
      out.write("\t\tcomplete: function(){\n");
      out.write("\t\t\tcurrent_fs.hide();\n");
      out.write("\t\t\tanimating = false;\n");
      out.write("\t\t}, \n");
      out.write("\t\t//this comes from the custom easing plugin\n");
      out.write("\t\teasing: 'easeInOutBack'\n");
      out.write("\t});\n");
      out.write("});\n");
      out.write("\n");
      out.write("$(\".previous\").click(function(){\n");
      out.write("\tif(animating) return false;\n");
      out.write("\tanimating = true;\n");
      out.write("\t\n");
      out.write("\tcurrent_fs = $(this).parent();\n");
      out.write("\tprevious_fs = $(this).parent().prev();\n");
      out.write("\t\n");
      out.write("\t//de-activate current step on progressbar\n");
      out.write("\t$(\"#progressbar li\").eq($(\"fieldset\").index(current_fs)).removeClass(\"active\");\n");
      out.write("\t\n");
      out.write("\t//show the previous fieldset\n");
      out.write("\tprevious_fs.show(); \n");
      out.write("\t//hide the current fieldset with style\n");
      out.write("\tcurrent_fs.animate({opacity: 0}, {\n");
      out.write("\t\tstep: function(now, mx) {\n");
      out.write("\t\t\t//as the opacity of current_fs reduces to 0 - stored in \"now\"\n");
      out.write("\t\t\t//1. scale previous_fs from 80% to 100%\n");
      out.write("\t\t\tscale = 0.8 + (1 - now) * 0.2;\n");
      out.write("\t\t\t//2. take current_fs to the right(50%) - from 0%\n");
      out.write("\t\t\tleft = ((1-now) * 50)+\"%\";\n");
      out.write("\t\t\t//3. increase opacity of previous_fs to 1 as it moves in\n");
      out.write("\t\t\topacity = 1 - now;\n");
      out.write("\t\t\tcurrent_fs.css({'left': left});\n");
      out.write("\t\t\tprevious_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});\n");
      out.write("\t\t}, \n");
      out.write("\t\tduration: 800, \n");
      out.write("\t\tcomplete: function(){\n");
      out.write("\t\t\tcurrent_fs.hide();\n");
      out.write("\t\t\tanimating = false;\n");
      out.write("\t\t}, \n");
      out.write("\t\t//this comes from the custom easing plugin\n");
      out.write("\t\teasing: 'easeInOutBack'\n");
      out.write("\t});\n");
      out.write("});\n");
      out.write("\n");
      out.write("$(\".submit\").click(function(){\n");
      out.write("\treturn false;\n");
      out.write("})\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
