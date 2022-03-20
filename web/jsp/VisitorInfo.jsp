
<%@page import="org.bd.DB"%>
<%@page import="org.object.Company"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/jsp.css" type="text/css" />
        <title>获取数据</title>
    </head>
    <body id="visitpage" style='background-image: url("../image/1.jfif")'>
        <h1>公司概况</h1>
        <%  
            // 获取数据
            HttpSession s = request.getSession(false);
            String idCompany = s.getAttribute("idC").toString();
            Company c = (Company) DB.findCompany(idCompany);
            if(c.getChineseName().isEmpty()){
                out.println("<h2>" + c.getEnglishName() + "</h2>");       
            }else{
                out.println("<h2>" + c.getChineseName() + "</h2>");       
            }
            
            out.println("<h3>公司简介</h3><table border=\"1\">"+
                    "<tr><th>ChineseName</th><td>" + c.getChineseName() + "</td><th>EnglishName</th><td>" + c.getEnglishName() + 
                    "</td></tr><tr><th>Id Company</th><td>" + c.getIdC() + "</td><th>CreateDate</th><td>" + c.getCreateDate() + 
                    "</td></tr><tr><th>Chairman</th><td>" + c.getChairman() + "</td><th>Employees</th><td>" + c.getEmployees() +
                    "</td></tr><tr><th>Tel</th><td>" + c.getTel() + "</td>" + "<th>Fax</th><td>" + c.getFax() + 
                    "</td></tr><tr><th>Email</th><td>" + c.getEmail() + "</td><th>Website</th><td>" + c.getWebsite() + 
                    "</td></tr><tr><th>RegisteredAddress</th><td>" + c.getRegisteredAddress() + "</td><th>OfficeAddress</th><td>" + c.getOfficeAddress() +
                     "</td></tr><tr><th>Industry</th><td>" + c.getIndustry() + "</td></tr></table>");
            
            out.println("<h3>股票信息</h3><table border=\"1\">"+
                    "<tr><th>SecurityCode</th><td>" + c.getSecurityCode() + "</td><th>SecurityType</th><td>" + c.getSecurityType() + 
                    "</td></tr><tr><th>ListingDate</th><td>" + c.getListingDate() + "</td><th>ListingExchange</th><td>" + c.getListingExchange() + "</td></tr></table>");
        %>
        <br/>
        <a id="welcome" href="WelcomePageCtrl?fct"> Return home </a>
    </body>
</html>
