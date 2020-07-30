package com.hrbeu.servlet;

import com.hrbeu.Dao.EmpDao;
import com.hrbeu.Entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("page");
        if(pageStr==null||pageStr.trim().equals("")){
            pageStr="1";
        }
        int page = Integer.parseInt(pageStr);
        req.setAttribute("current_page",page);
        EmpDao empDao = new EmpDao();
        int count = empDao.selectAllCount();
        List<Emp> emps = empDao.selectAllByPage(page,3);
        req.setAttribute("count",count);
        req.setAttribute("emps",emps);
        req.getRequestDispatcher("welcome.jsp").forward(req,resp);
    }
}
