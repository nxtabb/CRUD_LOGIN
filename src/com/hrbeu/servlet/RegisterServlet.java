package com.hrbeu.servlet;

import com.hrbeu.Dao.UserDao;
import sun.nio.cs.US_ASCII;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password1 = req.getParameter("password1");
        if(password.equals(password1)){
            UserDao userDao = new UserDao();
            userDao.register(username,password);
            resp.sendRedirect("index.jsp");
        }else {
            resp.sendRedirect("index.jsp");
        }

    }
}
