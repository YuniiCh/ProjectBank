
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/jsp.css" rel="stylesheet" type="text/css"/>
        <title>登录页面</title>
    </head>
    <body id="connectpage" >
        <h1>客户经理登录</h1>
           
        <form action="BConnectionCtrl"
              methode="GET">
            <label for="user">Pseudo</label> <input class="pseudo" type="text" name="psd" value="banker"/>
            </p>
            <label for="psw">Password </label><input class="psw" type="text" name="psw" value="0000"/>
            </p>            
            <input class="sb" type="submit" value="Connect"/>
        </form>
        
        <!-- 登录失败信息显示 -->
        <% ///
            String avert = (String)request.getAttribute("avert");
            if(avert != null)
                out.println("<div class=\"avertissement\">" + avert + "</div>");
        %>

        <br/>
        <a id="welcome" href="WelcomePage"> Retour vers l'acceuil</a>
    </body>
</html>
