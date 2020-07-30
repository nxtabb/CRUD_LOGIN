<%@ page import="java.util.List" %>
<%@ page import="com.hrbeu.Entity.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/30
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%String username = (String) session.getAttribute("username");
int current_page = (int)request.getAttribute("current_page");
if(username==null||username.equals("")){
    request.setAttribute("error1","信息有误,请重新登录");
    request.getRequestDispatcher("index.jsp").forward(request,response);
}%>
<h1 align="center">欢迎您：<%=username%><a href="/logout">退出登录</a></h1>
<h4 align="center"><a href="/crud?method=insert">添加用户</a></h4>
<%  int count = (int) request.getAttribute("count");
    List<Emp> emps = (List<Emp>) request.getAttribute("emps");
    int max_page = 0;
    if(count<=3){
        max_page =1;
    }
    else if(count%3==0){
    max_page = count/3;
    }
    else {
    max_page = count/3+1;
    }
    int topage_next =current_page+1;
    int topage_pre = current_page-1;
    if(current_page+1>max_page){
        topage_next = max_page;
    }
    if(current_page-1<1){
        topage_pre = 1 ;
    }

%>
<table align="center">
    <tr>
        <th>EMPID</th>
        <th>DEPTNO</th>
        <th>EMPNAME</th>
        <th>AGE</th>
        <th>ADDRESS</th>
        <th>SAL</th>
        <th colspan="2">操作</th>
    </tr>
    <%for(Emp emp:emps){
        %>
    <tr>
        <td><%=emp.getEMPID()%></td>
        <td><%=emp.getDEPTNO()%></td>
        <td><%=emp.getEMPNAME()%></td>
        <td><%=emp.getAGE()%></td>
        <td><%=emp.getADDRESS()%></td>
        <td><%=emp.getSAL()%></td>
        <td><a href="/crud?method=selectById&id=<%=emp.getEMPID()%>">修改</a></td>
        <td><a href="/crud?method=delete&id=<%=emp.getEMPID()%>">删除</a></td>
    </tr>

    <%}%>
</table>
<div align="center">
    <a href="/welcome?page=1">首页</a>
    <a href="/welcome?page=<%=topage_pre%>">上一页</a>
    <a href="/welcome?page=<%=topage_next%>">下一页</a>
    <a href="/welcome?page=<%=max_page%>">尾页</a>
</div>
</body>
</html>
