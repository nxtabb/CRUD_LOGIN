package com.hrbeu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("username")){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("password")){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        resp.sendRedirect("index.jsp");
    }
}
