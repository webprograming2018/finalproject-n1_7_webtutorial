package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.SubjectDaoImpl;
import dao.LessonDaoImpl;
import java.util.ArrayList;
import dto.Lesson;
import java.util.List;

public final class menu_005fvertical_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/menu_vertical.css\" rel='stylesheet' type='text/css' />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            List<Lesson> listLesson = new ArrayList<Lesson>();
            LessonDaoImpl ldi = new LessonDaoImpl();
            SubjectDaoImpl sdi = new SubjectDaoImpl();
            listLesson = ldi.getListLessonBySubjectID(1000);
            String state = sdi.getSubjectBySubjectID(1000).getState();
            int lessonID = 1002;
        
      out.write("\n");
      out.write("        <div class=\"vertical-menu\" id=\"menu\">\n");
      out.write("            ");

                for (Lesson l : listLesson) {
                    boolean isActice = false;
                    if (l.getId() == lessonID) {
                        isActice = true;
                    }
            
      out.write("\n");
      out.write("            <a href=\"content.jsp?lesson_id=");
      out.print(l.getId());
      out.write('"');

                if (isActice) { 
      out.write("\n");
      out.write("               class=\"active\" \n");
      out.write("               ");
} else {
      out.write("\n");
      out.write("               class=\"\"\n");
      out.write("               ");
}
      out.write('>');
      out.print(l.getName());
      out.write("</a>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div> \n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            // Add active class to the current button (highlight it)\n");
      out.write("            var header = document.getElementById(\"menu\");\n");
      out.write("            var btns = header.getElementsByClassName(\"a\");\n");
      out.write("            for (var i = 0; i < btns.length; i++) {\n");
      out.write("                btns[i].addEventListener(\"click\", function () {\n");
      out.write("                    var current = document.getElementsByClassName(\"active\");\n");
      out.write("                    current[0].className = current[0].className.replace(\"active\", \"\");\n");
      out.write("                    this.className += \"active\";\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
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
