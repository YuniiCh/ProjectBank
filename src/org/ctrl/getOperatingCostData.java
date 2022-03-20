/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.ctrl;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bd.DB;
import org.object.Finance;


public class getOperatingCostData extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /*营业收入*/
            String idC = request.getParameter("idC");
            List<Finance> listFinances = new ArrayList<>();
            
            try {
                listFinances = DB.readFinanceByID(idC);
            } catch (Exception ex) {
                Logger.getLogger(getOperatingCostData.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            
            int lenFinances = listFinances.size();
            int[] operatingProfits = new int[lenFinances];
            int[] operatingCosts = new int[lenFinances];
            //List<Float> operatingProfits = new ArrayList<>();
            /*横轴 日期*/
            String[] dates = new String[lenFinances];
            //List<String> dates = new ArrayList<>();
            
            for(int i=0;i<lenFinances;i++){
                Finance f = listFinances.get(i);
                operatingCosts[i] = (int) f.getOperating_cost();
                operatingProfits[i] = (int) f.getOperating_profit();
                dates[i]=f.getDateF().toString();
            }

            Map<String, Object> map = new HashMap<>();
            map.put("operatingProfits",operatingProfits);
            map.put("operatingCosts",operatingCosts);
            map.put("dates", dates);

            out.println(JSON.toJSONString(map));
        
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
