/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ctrl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bd.DB;

/**
 *
 * @author CYN
 */
public class AllCompanyInfosCtrl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        int nbCompany = DB.countCompany();
        int nbPerPage = 20;
        int nbPage = (int) nbCompany / nbPerPage + 1;
        int thisPage = 1;
        if (request.getQueryString().contains("page")) {
            thisPage = Integer.valueOf(request.getParameter("page"));
        } else if (request.getQueryString().contains("next")) {
        } else if (request.getQueryString().contains("pre")) {
            thisPage = Integer.valueOf(request.getParameter("pre")) - 1;
        }
        RequestDispatcher rd = request.getRequestDispatcher("AllCompanyInfos");
        request.setAttribute("page", thisPage);
        request.setAttribute("nbPerPage", nbPerPage);
        request.setAttribute("nbPage", nbPage);
        rd.forward(request, response);
        System.out.println("Go to AllCompanyInfos");

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
