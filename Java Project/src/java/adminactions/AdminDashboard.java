/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminactions;

import common.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sayur
 */
public class AdminDashboard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {

            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("LoggedInUserId");
            String urole = (String) session.getAttribute("LoggedInRole");
            
            if ("admin".equals(urole)) {
            String Totalusers = null;
            String Totalreservations = null;
            String Totalmessages = null;
            if(user == null || "".equals(user)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Please login first !!');");
                out.println("location='sign-in.jsp';");
                out.println("</script>");
            }
            else{

            dbconnection obj_dbconnection = new dbconnection();
            Connection connection = obj_dbconnection.get_connection();
            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "select count(*) from users";
            Class.forName("com.mysql.jdbc.Driver");
            ps = connection.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while (rs.next()){
                Totalusers = rs.getString(1);
            }
            
            
            String sql2 = "select count(*) from bookings";
            ps = connection.prepareStatement(sql2);
            
            rs = ps.executeQuery();
            while (rs.next()){
                Totalreservations = rs.getString(1);
            }
            
            String sql3 = "select count(*) from messages";
            ps = connection.prepareStatement(sql3);
            
            rs = ps.executeQuery();
            while (rs.next()){
                Totalmessages = rs.getString(1);
            }
                
            request.setAttribute("tusers",Totalusers);
            request.setAttribute("treservations",Totalreservations);
            request.setAttribute("tmessages",Totalmessages);
                RequestDispatcher rd = request.getRequestDispatcher("admin-dashboard.jsp");
                rd.include(request,response);
            }
            }
            else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('You are not allowed to perform this admin only task!');");
                out.println("location='sign-in.jsp';");
                out.println("</script>");
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            out.println(ex);
        }
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
