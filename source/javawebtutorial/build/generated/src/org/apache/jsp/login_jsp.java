package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/login.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <title>Đăng nhập</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String err = "";
            if (request.getAttribute("err") != null) {
                err = (String) request.getAttribute("err");
            }
        
      out.write("\n");
      out.write("        <!--/start-login-one-->\n");
      out.write("        <div class=\"login-01\">\n");
      out.write("            <div class=\"one-login  hvr-float-shadow\">\n");
      out.write("                <div class=\"one-login-head\">\n");
      out.write("                    <img src=\"images/top-lock.png\" alt=\"\" />\n");
      out.write("                    <h1>LOGIN</h1>\n");
      out.write("\n");
      out.write("                    <span></span>\n");
      out.write("                </div>\n");
      out.write("                <form action=\"LoginServlet\" method=\"post\">\n");
      out.write("                    ");
 String mess = "";
                                    if (request.getAttribute("mess") != null) {
                                        mess = (String) request.getAttribute("mess");
      out.write("\n");
      out.write("                    <li style=\"color: red\">");
      out.print(mess);
      out.write("</li>\t\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                    <li style=\"color: red\">");
      out.print(err);
      out.write("</li>\n");
      out.write("                    Tên người dùng\n");
      out.write("                    <li><input type=\"text\" class=\"text\" value=\"\"\n");
      out.write("                               name=\"msv\"><a href=\"#\" class=\" icon user\"></a></li>\n");
      out.write("                    Mật khẩu\n");
      out.write("                    <li><input type=\"password\" value=\"\"\n");
      out.write("                               name=\"password\"><a href=\"#\" class=\" icon lock\"></a></li>\n");
      out.write("                    <div class=\"p-container\">\n");
      out.write("                        <label class=\"checkbox\"><input type=\"checkbox\"\n");
      out.write("                                                       name=\"checkbox\" checked><i></i>Ghi nhớ mật khẩu</label>\n");
      out.write("                        <h6>\n");
      out.write("                            <!--<a href=\"resetpassword.jsp\">Khôi phục mật khẩu</a>-->\n");
      out.write("                        </h6>\n");
      out.write("                        <div class=\"clear\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"submit\">\n");
      out.write("                        <input type=\"submit\" value=\"SIGN IN\">\n");
      out.write("                    </div>\n");
      out.write("                    <!--\t\t\t\t<div class=\"social-icons\">\n");
      out.write("                                                            <p>Bạn có thể đăng nhập bằng tài khoản:</p>\n");
      out.write("                                                            <ul class=\"soc_icons2\">\n");
      out.write("                                                                    <li class=\"pic\"><a href=\"#\"><i class=\"icon_4\"></i></a></li>\n");
      out.write("                                                                    <li class=\"pic\"><a href=\"#\"><i class=\"icon_5\"></i></a></li>\n");
      out.write("                                                                    <li class=\"pic\"><a href=\"#\"><i class=\"icon_6\"></i></a></li>\n");
      out.write("                                                                    <div class=\"clear\"></div>\n");
      out.write("                                                            </ul>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <h5>\n");
      out.write("                                                            Bạn muốn đăng ký tài khoản?<a href=\"register.jsp\"> Đăng ký </a>\n");
      out.write("                                                    </h5>-->\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
