<%-- 
    Document   : test
    Created on : 2022-3-20, 6:00:24
    Author     : CYN
--%>

<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="org.bd.DB"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            HashMap<String, HashMap<String,Float>> data = new HashMap<>();
            try{
                data = DB.findData();
                for (HashMap<String,Float> fl: data.values()) {
                for (float f : fl.values()) {
                    out.println(f);
                }
             }
            }catch (Exception ex) {
                Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }


        %>
    </body>
</html>
