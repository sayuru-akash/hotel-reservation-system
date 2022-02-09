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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sayur
 */
public class AddsCustomer extends HttpServlet {

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
        response.getWriter().append("Served at: ").append(request.getContextPath());
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
        PrintWriter out = response.getWriter();
        try {
            //Cookie ck[]=request.getCookies();  
            HttpSession session = request.getSession();
            String urole = (String) session.getAttribute("LoggedInRole");

            if ("admin".equals(urole)) {
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String mobile = request.getParameter("mobile");
                String email = request.getParameter("email");
                String pwd = request.getParameter("pwd");

                dbconnection obj_dbconnection = new dbconnection();
                Connection connection = obj_dbconnection.get_connection();
                PreparedStatement ps = null;

                String sql = "insert into users ( fname, lname, mobile, email, pwd) values(?,?,?,?,?)";
                Class.forName("com.mysql.jdbc.Driver");

                ps = connection.prepareStatement(sql);
                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, mobile);
                ps.setString(4, email);
                ps.setString(5, pwd);

                ps.executeUpdate();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Registration Completed Successfully !!');");
                out.println("location='admin-add-data.jsp';");
                out.println("</script>");
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
