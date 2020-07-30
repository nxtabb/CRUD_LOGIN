package com.hrbeu.servlet;

import com.hrbeu.Dao.EmpDao;
import com.hrbeu.Entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/crud")
public class CRUDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if(method.equals("insert")){
            resp.sendRedirect("insert.jsp");
        }
        else if(method.equals("delete")){
            String EMPID = req.getParameter("id");
            EmpDao empDao = new EmpDao();
            empDao.deleteById(EMPID);
            resp.sendRedirect("/welcome");
        }
        else if(method.equals("selectById")){
            String EMPID = req.getParameter("id");
            EmpDao empDao = new EmpDao();
            Emp emp = null;
            emp = empDao.selectById(EMPID);
            req.setAttribute("emp",emp);
            req.getRequestDispatcher("update.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if(method.equals("insert")){
            String EMPID = req.getParameter("EMPID");
            String DEPTNO = req.getParameter("DEPTNO");
            String EMPNAME = req.getParameter("EMPNAME");
            String AGEStr = req.getParameter("AGE");
            String ADDRESS = req.getParameter("ADDRESS");
            String SALStr = req.getParameter("SAL");
            int AGE = Integer.parseInt(AGEStr);
            int SAL = Integer.parseInt(SALStr);
            EmpDao empDao = new EmpDao();
            empDao.insert(EMPID,DEPTNO,EMPNAME,AGE,ADDRESS,SAL);
            resp.sendRedirect("/welcome");


        }
        else if(method.equals("update")){
            String EMPID = req.getParameter("EMPID");
            String DEPTNO = req.getParameter("DEPTNO");
            String EMPNAME = req.getParameter("EMPNAME");
            String AGEStr = req.getParameter("AGE");
            String ADDRESS = req.getParameter("ADDRESS");
            String SALStr = req.getParameter("SAL");
            int AGE = Integer.parseInt(AGEStr);
            int SAL = Integer.parseInt(SALStr);
            EmpDao empDao = new EmpDao();
            empDao.update(DEPTNO,EMPNAME,AGE,ADDRESS,SAL,EMPID);
            resp.sendRedirect("/welcome");
        }
    }
}
