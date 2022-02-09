/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.dbconnection;
import common.mailer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registeruser extends HttpServlet {

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
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String pwd = request.getParameter("password");
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            String genpwd = null;
            try {
                genpwd = MD5(pwd);
            } catch (Exception ex) {
                Logger.getLogger(registeruser.class.getName()).log(Level.SEVERE, null, ex);
            }

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
            ps.setString(5, genpwd);

            ps.executeUpdate();
            
            String subject = "Account Registration Success - HR Hotels";
            String msg = ("Hi ").concat(fname).concat(", \nYou have sucessfully registered at HR hotels. \nIf it was not you please contact us to secure your account. \nThis email was intended for the user registered with the following email. \n").concat(email);
            mailer.send(email, subject, msg);
            
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Registration Completed Successfully !!');");
            out.println("location='sign-in.jsp';");
            out.println("</script>");

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
    }// </editor-fold>

    private static String MD5(String s) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        return new BigInteger(1, m.digest()).toString(16);
    }
}
