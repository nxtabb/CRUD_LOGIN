<%@ page import="com.hrbeu.Entity.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/30
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%  Emp emp = (Emp) request.getAttribute("emp");
    %>
<form action="/crud" method="post">
    <h1 align="center">修改员工信息</h1>
    <table align="center">
        <td><input type="hidden" name="method" value="update"></td>
        <tr><th>EMPID:</th><td><input type="text" readonly name="EMPID" value="<%=emp.getEMPID()%>"></td></tr>
        <tr><th>DEPTNO:</th><td><input type="text" name="DEPTNO" value="<%=emp.getDEPTNO()%>"></td></tr>
        <tr><th>EMPNAME:</th><td><input type="text" name="EMPNAME" value="<%=emp.getEMPNAME()%>"></td></tr>
        <tr><th>AGE:</th><td><input type="text" name="AGE" value="<%=emp.getAGE()%>"></td></tr>
        <tr><th> ADDRESS:</th><td><input type="text" name="ADDRESS" value="<%=emp.getADDRESS()%>"></td></tr>
        <tr><th>SAL:</th><td><input type="text" name="SAL" value="<%=emp.getSAL()%>"></td></tr>
        <tr align="center"><td colspan="2"> <input type="submit" value="提交" style="width: 100px" ></td></tr>
    </table>
</form>
</body>
</html>
