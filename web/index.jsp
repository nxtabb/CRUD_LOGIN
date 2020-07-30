<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/30
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>员工管理系统</title>
    <script>
      window.onload = function () {
        var flag = false;
        var username_input = document.getElementById("username");
        var password_input = document.getElementById("password");
        var btn = document.getElementById("btn");
        var span1 = document.getElementById("error1");
        var span2 = document.getElementById("error2");
        username_input.onblur = function () {
          if(username_input.value.length==0){
            span1.innerText="用户名不能为空";
              flag = false;
          }
          else {
            span1.innerText="";
            flag = true;
          }

        }
        password_input.onblur = function () {
          if(password_input.value.length==0){
            span2.innerText="密码不能为空";
            flag = false;
          }
          else {
            span2.innerText="";
            flag = true;
          }

        }

        btn.onclick = function () {
          if(flag==true){
            document.forms[0].submit();
          }
          else {
            alert("输入信息有误");
          }

        }
      }
    </script>
  </head>
  <body>
  <%  String username=null;
      String password=null;
      Cookie[] cookies = request.getCookies();
      for(Cookie cookie:cookies){
          if(cookie.getName().equals("username")){
            username = cookie.getValue();
          }
      }
      for(Cookie cookie:cookies){
        if(cookie.getName().equals("password")){
          password = cookie.getValue();
        }
      }
      if(username!=null){
        request.getRequestDispatcher("/check?username="+username+"&password="+password+"&rem=true&time=5").forward(request,response);
      }
  %>

  <%String error1 = (String) request.getAttribute("error1");
  String error2 = (String) request.getAttribute("error2");
  if(error1==null){
    error1="";
  }
  if(error2==null){
    error2="";
  }%>
  <h1 align="center">欢迎来到员工管理系统</h1>
  <form action="/check" method="post">
  <table align="center">
    <tr>
      <td>用户名：</td>
      <td><input type="text" name="username" id="username"><span id="error1"></span><%=error1%></td>
    </tr>
    <tr>
      <td>密码：</td>
      <td><input type="password" name="password" id="password"><span id="error2"></span><%=error2%></td>
    </tr>
    <tr>
      <td>记住登录信息<input type="checkbox" name="rem"></td>
      <td><select name="time">
        <option value="1">1分钟</option>
        <option value="5">5分钟</option>
        <option value="60">60分钟</option>
      </select></td>
    </tr>
    <tr>
      <td ><input type="button" value="登录" style="width: 100px" id="btn"></td>
      <td><a href="/register.jsp">注册</a></td>
    </tr>
  </table>
  </form>
  </body>
</html>
