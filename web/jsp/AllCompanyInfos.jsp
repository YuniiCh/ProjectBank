
<%@page import="org.bd.DB"%>
<%@page import="org.object.Company"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/j.css" type="text/css" />
        <title>获取数据</title>
    </head>
    <body id="companypage">
        <h1>获取数据</h1>
        <table id="companyt" border="1">
        <%
            int thisPage = (int) request.getAttribute("page");
            int nbPerPage = (int) request.getAttribute("nbPerPage");
            int nbPage = (int) request.getAttribute("nbPage");
            int num = thisPage * nbPerPage + 1;
            List<Company> liste = (List<Company>) DB.readCompanies(nbPerPage, thisPage);

            // Lecture de la liste et affichage
            out.println("<tr><th>Number</th><th>Company Id</th><th>EnglishName</th>"
                    + "<th>ChineseName</th><th>SecurityCode</th>"
                    + "<th>SecurityType</th><th>ListingExchange</th>"
                    + "<th>Chairman</th><th>Employees</th><th>Website</th><th>Detail</th></tr>");
            for (Company c : liste) {
                out.println("<tr><td>" + (num++) + "</td>"
                        + "<td><a id='idcompany' href='ReportCtrl?idC=" + c.getIdC() + "'>" + c.getIdC() + "</a></td>"
                        + "<td>" + c.getEnglishName() + "</td>"
                        + "<td>" + c.getChineseName() + "</td>"
                        + "<td>" + c.getSecurityCode() + "</td>"
                        + "<td>" + c.getSecurityType() + "</td>"
                        + "<td>" + c.getListingExchange() + "</td>"
                        + "<td>" + c.getChairman() + "</td>"
                        + "<td>" + c.getEmployees() + "</td>"
                        + "<td>" + c.getWebsite() + "</td>"
                        + "<td><a id='idcompany' href='CompanyInfoCtrl?idC=" + c.getIdC() + "'>Detail</a></td></tr>");
            }
        %>
        <table>
        <!--翻页-->
        <div id="page">
            <%
//                int nbCompany = DB.countCompany();
//                int nbPerPage = 20;
//                int nbPage = (int) nbCompany / 20 + 1;
//                int thisPage = 1;
//                if(!request.getParameter("page").isEmpty()){
//                    thisPage = Integer.valueOf(request.getParameter("page"));
//                }
                out.println("<ul>");
                int nb = 0;
                if (thisPage != 1) {
                    out.println("<a href='AllCompanyInfosCtrl?page=1'><li id='pre'>首页</li></a>");
                    out.println("<a href='AllCompanyInfosCtrl?pre=" + thisPage + "'><li id='pre'>前页</li></a>");
                }
                for (int i = 1; i <= nbPage; i++) {
                    if (i == thisPage) {
                        out.println("<li style='background-color:gray;'>" + i + "</li>");
                    } else {
                        out.println("<a href='AllCompanyInfosCtrl?page=" + i + "'><li>" + i + "</li></a>");
                    }
                }
                if (thisPage != nbPage) {
                    out.println("<a href='AllCompanyInfosCtrl?next=" + thisPage + "'><li id='next'>后页</li></a></ul>");
                    out.println("<a href='AllCompanyInfosCtrl?page=" + nbPage + "'><li id='pre'>末页</li></a>");
                }               
            %>
        </div>

        <div>
            <!-- 登录公司访问失败信息 -->
            <%
                String avert = (String) request.getAttribute("avert");
                if (avert != null)
                    out.println("<div class=\"avertissement\">" + avert + "</div>");
            %>
            <div>
                <br/>
                <a id="welcome" href="WelcomePageCtrl?fct"> Return home </a>
                </body>
                </html>
