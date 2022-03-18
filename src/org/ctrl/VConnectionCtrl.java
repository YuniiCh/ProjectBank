
package org.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VConnectionCtrl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        // 获取参数
        String idCompany = request.getParameter("psd");
        String password = request.getParameter("psw");

        // 测试参数
        String msg_avert = "";
        if(idCompany.isEmpty() || idCompany == "")
            msg_avert = "请输入Company ID";

        if(password.isEmpty() || password == "")
            msg_avert = "请输入密码";

        if(!msg_avert.isEmpty()){
            // KO - 返回登陆页面
            RequestDispatcher rd = request.getRequestDispatcher("VConnection");
            request.setAttribute("avert", msg_avert);
            rd.forward(request, response);

        }else if(idCompany.equals("US0378331005") && password.equals("0000")){
            // OK - 跳转到公司信息页面
            RequestDispatcher rd = request.getRequestDispatcher("VisitorInfo");
            HttpSession session = request.getSession(true);
            session.setAttribute("idC", idCompany);
            rd.forward(request, response);

        }else{
            // KO - 返回登陆页面
            msg_avert = "Company ID或密码不正确";
            RequestDispatcher rd = request.getRequestDispatcher("VConnection");
            request.setAttribute("avert", msg_avert);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
