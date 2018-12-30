package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.SubjectDaoImpl;
import dao.LessonDaoImpl;
import dto.Lesson;
import dao.SectionContentDaoImpl;
import dto.SectionContent;
import dto.Section;
import java.util.List;
import java.util.ArrayList;
import dao.SectionDaoImpl;

public final class content_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/content.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"css/menu_vertical.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <title>Content</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");


            String msv = null;
            if (session.getAttribute("msv") == null) {
                response.sendRedirect("/JavaWebTutorial/login.jsp");
                return;
            }

            String name = null;
            String sessionId = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("msv")) {
                        name = cookie.getValue();
                    }
                }
            }
            String lessonId = request.getParameter("lesson_id");
            int idLesson = 1000;
            if (lessonId != null) {
                idLesson = Integer.parseInt(lessonId);
            }
            List<Lesson> listLesson = new ArrayList<Lesson>();
            LessonDaoImpl ldi = new LessonDaoImpl();
            SubjectDaoImpl sdi = new SubjectDaoImpl();
            listLesson = ldi.getListLessonBySubjectID(1000);
            String state = sdi.getSubjectBySubjectID(1000).getState();

            SectionDaoImpl secdi = new SectionDaoImpl();
            SectionContentDaoImpl scdi = new SectionContentDaoImpl();
            List<Section> ls = new ArrayList();
            List<SectionContent> lsc = new ArrayList();
            ls = secdi.getListSectionById(idLesson);
            for (Section s : ls) {
                lsc.add(scdi.getSectionContentBySecID(s.getIdSection()));
                System.out.println(s.getName());
            }
        
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <a href=\"/JavaWebTutorial/index.jsp\" class=\"logo\">FTUTORIAL</a>\n");
      out.write("            <div class=\"header-right\">\n");
      out.write("                <a class=\"active\" href=\"/JavaWebTutorial/content.jsp?lesson_id=1000\">HTML</a>\n");
      out.write("                <a href=\"/JavaWebTutorial/content.jsp?lesson_id=1028\">CSS</a>\n");
      out.write("                <a href=\"/JavaWebTutorial/content.jsp?lesson_id=1000\">JAVASCRIP</a>\n");
      out.write("                <form action=\"LogoutServlet\" method=\"post\">\n");
      out.write("                    <!--<a href=\"/JavaWebTutorial/index.jsp\">LOGOUT</a>-->\n");
      out.write("                    <input type=\"submit\" value =\"LOGOUT\"/>\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class =\"main\">\n");
      out.write("            ");
                for (int i = 0; i < lsc.size(); i++) {
                    SectionContent sc = lsc.get(i);
                    String nameSection = ls.get(i).getName();
            
      out.write("\n");
      out.write("            <h5> ");
      out.print(nameSection);
      out.write("</h5>\n");
      out.write("            <p>");
      out.print(sc.getContent());
      out.write("</p>\n");
      out.write("            <p>");
      out.print(sc.getDescription());
      out.write("</p>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class =\"left\">\n");
      out.write("            <div class=\"vertical-menu\" id=\"menu\">\n");
      out.write("                ");

                    for (Lesson l : listLesson) {
                        boolean isActice = false;
                        if (l.getId() == idLesson) {
                            isActice = true;
                        }
                
      out.write("\n");
      out.write("                <a href=\"content.jsp?lesson_id=");
      out.print(l.getId());
      out.write('"');

                    if (isActice) { 
      out.write("\n");
      out.write("                   class=\"active\" \n");
      out.write("                   ");
} else {
      out.write("\n");
      out.write("                   class=\"\"\n");
      out.write("                   ");
}
      out.write('>');
      out.print(l.getName());
      out.write("</a>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </div> \n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
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
