/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ctrl;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bd.DB;
import org.object.Finance;


public class ReportCtrl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String idC = request.getParameter("idC");
System.out.println("idC" + idC);
        int total = DB.countFinanceByIDCompany(idC);
System.out.println("idC total: " + total);
        int nbPerPage = 20;
        int thisPage = 1;
        int nbPage = (int) total / nbPerPage + 1;
        System.out.println("idC" + thisPage);
//        if (request.getQueryString().contains("page")) {
//            thisPage = Integer.valueOf(request.getParameter("page"));
//            System.out.println("page" + thisPage);
//        } else if (request.getQueryString().contains("next")) {
//            thisPage = Integer.valueOf(request.getParameter("next")) + 1;;
//            System.out.println("next" + thisPage);
//        } else if (request.getQueryString().contains("pre")) {
//            thisPage = Integer.valueOf(request.getParameter("pre")) - 1;
//            System.out.println("pre" + thisPage);
//        } else 
        List<Finance> f = (List<Finance>) DB.readFinanceByID(idC);
        if (f.size() > 0) {
        System.out.println("find data" + f.size());
            RequestDispatcher rd = request.getRequestDispatcher("Report");
            request.setAttribute("finance", f);
            request.setAttribute("page", thisPage);
            request.setAttribute("nbPage", nbPage);
            request.setAttribute("idC", idC);
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("NoReport");
            rd.forward(request, response);
        }

//        RequestDispatcher rd = request.getRequestDispatcher("Report");
//        request.setAttribute("page", thisPage);
//        request.setAttribute("nbPerPage", nbPerPage);
//        request.setAttribute("nbPage", nbPage);
//        rd.forward(request, response);
//        System.out.println("Go to Report");
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
        try {
            processRequest(request, response);
        } catch (Exception e) {
            e.getStackTrace();
        }
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
        try {
            processRequest(request, response);
        } catch (Exception e) {
            e.getStackTrace();
        }
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
