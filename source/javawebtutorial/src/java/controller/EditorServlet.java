/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.EditorCode;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.MyUtils;

/**
 *
 * @author Admin
 */
public class EditorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = req.getParameter("htmlEditor");
        String css = req.getParameter("cssEditor");
        String js = req.getParameter("jsEditor");

//       PrintWriter writer = resp.getWriter();
//       resp.setContentType("text/html");
//       writer.println("<h4>Your Comment Is :</h4>");
//
//       writer.println("<br><font color=black>" + "</font>");
//       writer.println(MyUtils.compileCode(html, css, js));
//       writer.close();
        HttpSession session = req.getSession();
        session.setAttribute("EditorCode", new EditorCode(html, css, js));
        session.setMaxInactiveInterval(60 * 60);
        
        resp.sendRedirect("/JavaWebTutorial/editor.jsp?subject_id=1004");
    }

}
