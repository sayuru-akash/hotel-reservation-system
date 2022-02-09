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
import common.smssender;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sayur
 */
public class userlogin extends HttpServlet {

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

            String email = request.getParameter("email");
            String pwd = request.getParameter("password");
            String dbfname = null;
            String dbmobile = null;
            String dbemail = null;
            String dbpwd = null;
            String dbrole = null;
            String dbuid = null;
            String genpwd = null;
            try {
                genpwd = MD5(pwd);
            } catch (Exception ex) {
                Logger.getLogger(registeruser.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbconnection obj_dbconnection = new dbconnection();
            Connection connection = obj_dbconnection.get_connection();
            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "select fname,mobile,email,pwd,role,uid from users where email=? and pwd=?";
            Class.forName("com.mysql.jdbc.Driver");
            ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, genpwd);

            rs = ps.executeQuery();
            while (rs.next()) {
                dbfname = rs.getString(1);
                dbmobile = rs.getString(2);
                dbemail = rs.getString(3);
                dbpwd = rs.getString(4);
                dbrole = rs.getString(5);
                dbuid = rs.getString(6);
            }

            HttpSession session = request.getSession();
            String msg = null;
            String subject = "New Login Detected On Your Account - HR Hotels";

            if (email.equals(dbemail) && genpwd.equals(dbpwd)) {
                msg = ("Hi ").concat(dbfname).concat(", \nNew login detected for your account at hrhotels. \nIf it was not you please reset your password and secure your account. \nThis email was intended for the user registered with the following email. \n").concat(dbemail);
                mailer.send(dbemail, subject, msg);
                //smssender.deliver(dbmobile,msg);

                if (dbrole.equals("admin")) {
                    session.setAttribute("LoggedInRole", dbrole);
                    session.setAttribute("LoggedInUserId", dbuid);
                    Cookie ck = new Cookie("ucookie", dbuid);
                    response.addCookie(ck);
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='AdminDashboard';");
                    out.println("</script>");

                }
                if (dbrole.equals("customer")) {
                    session.setAttribute("LoggedInRole", dbrole);
                    session.setAttribute("LoggedInUserId", dbuid);
                    Cookie ck = new Cookie("ucookie", dbuid);
                    response.addCookie(ck);
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='UserDashboard';");
                    out.println("</script>");
                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("location='index.html';");
                    out.println("</script>");
                }
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Username Or Password is wrong !!');");
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
    }// </editor-fold>

    private static String MD5(String s) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        return new BigInteger(1, m.digest()).toString(16);
    }

}
