
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%=request.getContextPath()+"/css/jsp.css"%>" type="text/css" />
        <title>登录页面</title>
    </head>
    <body>
        
        <h1>公司登录</h1>
           
        <form action="VConnectionCtrl" methode="GET">
            <label for="user">Company ID</label> <input class="pseudo" type="text" name="psd" value="US0378331005"/><br>
            <label for="psw">Password </label><input class="psw" type="text" name="psw" value="0000"/><br>
            
            <input class="sb" type="submit" value="Connect"/>
            
        </form>
        
        <!-- 登录失败信息显示 -->
        <%
            String avert = (String)request.getAttribute("avert");
            if(avert != null)
                out.println("<div class=\"avertissement\">" + avert + "</div>");
        %>

        <br/>
        <a href="WelcomePage"> Retour vers l'acceuil</a>
        
    </body>
</html>
