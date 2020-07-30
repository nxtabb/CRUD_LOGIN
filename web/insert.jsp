<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/30
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <%  String username = (String)session.getAttribute("username");
        if(username==null||username.equals("")){
            request.setAttribute("error1","请登录");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        %>
<form action="/crud" method="post">
    <h1 align="center">插入员工信息</h1>
    <table align="center">
        <td><input type="hidden" name="method" value="insert"></td>
        <tr><th>EMPID:</th><td><input type="text" name="EMPID"></td></tr>
        <tr><th>DEPTNO:</th><td><input type="text" name="DEPTNO"></td></tr>
        <tr><th>EMPNAME:</th><td><input type="text" name="EMPNAME"></td></tr>
        <tr><th>AGE:</th><td><input type="text" name="AGE"><br></td></tr>
        <tr><th> ADDRESS:</th><td><input type="text" name="ADDRESS"></td></tr>
        <tr><th>SAL:</th><td><input type="text" name="SAL"><br></td></tr>
        <tr align="center"><td colspan="2"> <input type="submit" value="提交" style="width: 100px" ></td></tr>
    </table>
</form>
</div>
</body>
</html>
