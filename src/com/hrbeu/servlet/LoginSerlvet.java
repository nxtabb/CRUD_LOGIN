package com.hrbeu.servlet;

import com.hrbeu.Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/check")
public class LoginSerlvet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password_sel = null;
        UserDao userDao = new UserDao();
        password_sel = userDao.selectByName(username);
        if(password_sel==null||password_sel.equals("")){
            req.setAttribute("error1","用户名不存在");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            return;
        }
        if(!password_sel.equals(password)){
            req.setAttribute("error2","密码错误");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            return;
        }
        String remStr = req.getParameter("rem");
        String timeStr = req.getParameter("time");
        if(remStr!=null){
            remStr = "true";
        }
        else {
            remStr = "flase";
        }
        boolean rem = Boolean.parseBoolean(remStr);
        int time = Integer.parseInt(timeStr);
        if(rem){
            Cookie cookie1 = new Cookie("username",username);
            Cookie cookie2 = new Cookie("password",password);
            cookie1.setMaxAge(time*60);
            cookie2.setMaxAge(time*60);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
        }
        HttpSession session = req.getSession();
        session.setAttribute("username",username);
        resp.sendRedirect("/welcome");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password_sel = null;
        UserDao userDao = new UserDao();
        password_sel = userDao.selectByName(username);
        if(password_sel==null||password_sel.equals("")){
            req.setAttribute("error1","用户名不存在");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            return;
        }
        if(!password_sel.equals(password)){
            req.setAttribute("error2","密码错误");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            return;
        }
        String remStr = req.getParameter("rem");
        String timeStr = req.getParameter("time");
        if(remStr!=null){
            remStr = "true";
        }
        else {
            remStr = "flase";
        }
        boolean rem = Boolean.parseBoolean(remStr);
        int time = Integer.parseInt(timeStr);
        if(rem){
            Cookie cookie1 = new Cookie("username",username);
            Cookie cookie2 = new Cookie("password",password);
            cookie1.setMaxAge(time*60);
            cookie2.setMaxAge(time*60);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
        }
        HttpSession session = req.getSession();
        session.setAttribute("username",username);
        resp.sendRedirect("/welcome");
    }
}
