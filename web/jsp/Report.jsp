<%-- 
    Document   : Report
    Created on : 2022-3-19, 0:43:01
    Author     : CYN
--%>

<%@page import="java.util.List"%>
<%@page import="org.bd.DB"%>
<%@page import="org.object.Finance"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/j.css" rel="stylesheet" type="text/css"/>
        <title>报告</title>
    </head>
    <body id="reportpage" >
        <%
            // 获取报告数据
            List<Finance> list_finance = (List<Finance>) request.getAttribute("finance");
            out.println("<h1>" + list_finance.get(1).getCompany().getChineseName() + "</h1>");
            // Lecture de la liste et affichage
            out.println("<table border=\"1\">");
            out.println("<tr><th>Date</th><th>Liabilities</th>"
                    + "<th>Assets</th><th>Current_assets</th><th>Current_liabilities</th>"
                    + "<th>Inventories</th><th>Shareholders_equity</th><th>Profits_payable</th>"
                    + "<th>Short_loans</th><th>Long_loans</th><th>Net_profit</th>"
                    + "<th>Operating_profit</th><th>Operating_cost</th><th>Income_tax_paid</th>"
                    + "<th>AEADNGL</th><th>Selling_expenses</th><th>Business_tariff_and_annex</th>"
                    + "<th>CPDDP</th><th>NCFOA</th><th>Cash_from_borrow</th><th>CRAB</th><th>CPFAIALA</th>"
                    + "<th>DFAOGAPBA</th><th>Deferred_assets</th><th>SCOSE</th></tr>");
            for (Finance f : list_finance) {
                out.println("<tr><td>" + f.getDateF().toString() + "</td>"
                        + "<td>" + f.getLiabilities() + "</td>"
                        + "<td>" + f.getAssets() + "</td>"
                        + "<td>" + f.getCurrent_assets() + "</td>"
                        + "<td>" + f.getCurrent_liabilities() + "</td>"
                        + "<td>" + f.getInventories() + "</td>"
                        + "<td>" + f.getShareholders_equity() + "</td>"
                        + "<td>" + f.getProfits_payable() + "</td>"
                        + "<td>" + f.getShort_loans() + "</td>"
                        + "<td>" + f.getLong_loans() + "</td>"
                        + "<td>" + f.getNet_profit() + "</td>"
                        + "<td>" + f.getOperating_profit() + "</td>"
                        + "<td>" + f.getOperating_cost() + "</td>"
                        + "<td>" + f.getIncome_tax_paid() + "</td>"
                        + "<td>" + f.getAEADNGL() + "</td>"
                        + "<td>" + f.getSelling_expenses() + "</td>"
                        + "<td>" + f.getBusiness_tariff_and_annex() + "</td>"
                        + "<td>" + f.getCPDDP() + "</td>"
                        + "<td>" + f.getNCFOA() + "</td>"
                        + "<td>" + f.getCash_from_borrow() + "</td>"
                        + "<td>" + f.getCRAB() + "</td>"
                        + "<td>" + f.getCPFAIALA() + "</td>"
                        + "<td>" + f.getDFAOGAPBA() + "</td>"
                        + "<td>" + f.getDeferred_assets() + "</td>"
                        + "<td>" + f.getSCOSE() + "</td></tr>");
            }
            out.println("</table>");
        %>      
        <!--翻页-->
        <div>
            <%
                int thisPage =  (int) request.getAttribute("page");
                int nbPage = (int) request.getAttribute("nbPage");
                out.println("<ul>");
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
        <div>${requestScope.avert}<div>
                <br/>
                <a id="welcome" href="WelcomePageCtrl?fct"> Return home </a>
                </body>
                </html>
