
<%@page import="org.bd.DB"%>
<%@page import="org.object.Company"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/jsp.css" type="text/css" />
        <title>获取数据</title>
    </head>
    <body>
        <h1>获取数据</h1>
        <%  
            // 获取数据
            HttpSession s = request.getSession(false);
            String idCompany = s.getAttribute("idC").toString();
            Company c = (Company) DB.findCompany(idCompany);
                   
            out.println("<table border=\"1\" width=\"83%\">");
            out.println("<tr><th>Identifiant Company</th><th>EnglishName</th><th>ChineseName</th>"+
                    "<th>CreateDate</th><th>Industry</th><th>SecurityCode</th>"+
                    "<th>SecurityType</th><th>ListingDate</th><th>ListingExchange</th>"+
                    "<th>Chairman</th><th>Employees</th><th>Tel</th>"+
                    "<th>Fax</th><th>Email</th><th>Website</th>"+
                    "<th>RegisteredAddress</th><th>OfficeAddress</th></tr>");
            // 读取数据
            out.println("<tr><td>" + c.getIdC() + "</td>" + 
                        "<td>" + c.getEnglishName() + "</td>" +
                        "<td>" + c.getChineseName() + "</td>" +
                        "<td>" + c.getCreateDate() + "</td>" +
                        "<td>" + c.getIndustry() + "</td>" +
                        "<td>" + c.getSecurityCode() + "</td>" +
                        "<td>" + c.getSecurityType() + "</td>" +
                        "<td>" + c.getListingDate() + "</td>" +
                        "<td>" + c.getListingExchange() + "</td>" +
                        "<td>" + c.getChairman() + "</td>" +
                        "<td>" + c.getEmployees() + "</td>" +
                        "<td>" + c.getTel() + "</td>" +
                        "<td>" + c.getFax() + "</td>" +
                        "<td>" + c.getEmail() + "</td>" +
                        "<td>" + c.getWebsite() + "</td>" +
                        "<td>" + c.getRegisteredAddress() + "</td>" +
                        "<td>" + c.getOfficeAddress() + "</td></tr>");                                               
            
            out.println("</table>");
        %>
        <div>${requestScope.msg_reussi}<div>
        <br/>
        <a href="ctrlCentral?fct=welcome"> Retour vers l'acceuil</a>
    </body>
</html>
