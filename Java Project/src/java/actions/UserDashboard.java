/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

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
public class UserDashboard extends HttpServlet {

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
            
            if ("customer".equals(urole)) {
                if(user == null || user==""){
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

            String sql = "select adults,children,cidate,codate from bookings where uid=? order by resid desc limit 3";
            Class.forName("com.mysql.jdbc.Driver");
            ps = connection.prepareStatement(sql);
            
            ps.setString(1, user);
            
            ArrayList<String> dbadults = new ArrayList<String>();
            ArrayList<String> dbchildren = new ArrayList<String>();
            ArrayList<String> dbcidate = new ArrayList<String>();
            ArrayList<String> dbcodate = new ArrayList<String>();
            
            rs = ps.executeQuery();
            while (rs.next()) {
                dbadults.add(rs.getString(1));
                dbchildren.add(rs.getString(2));
                dbcidate.add(rs.getString(3));
                dbcodate.add(rs.getString(4));
            }
            
            String sql2 = "select fname,lname,mobile,email from users where uid=?";
            ps = connection.prepareStatement(sql2);
            ps.setString(1, user);
            
            String fname = null;
            String lname = null;
            String mobile = null;
            String email = null;
            
            rs = ps.executeQuery();
            while (rs.next()) {
                fname = rs.getString(1);
                lname = rs.getString(2);
                mobile = rs.getString(3);
                email = rs.getString(4);
            }
            
            
            String[] adultsArr = new String[3];
            adultsArr = dbadults.toArray(adultsArr);
            String[] childrenArr = new String[3];
            childrenArr = dbchildren.toArray(childrenArr);
            String[] cidateArr = new String[3];
            cidateArr = dbcidate.toArray(cidateArr);
            String[] codateArr = new String[3];
            codateArr = dbcodate.toArray(codateArr);

            request.setAttribute("adults1",adultsArr[0]);
            request.setAttribute("adults2",adultsArr[1]);
            request.setAttribute("adults3",adultsArr[2]);
            request.setAttribute("children1",childrenArr[0]);
            request.setAttribute("children2",childrenArr[1]);
            request.setAttribute("children3",childrenArr[2]);
            request.setAttribute("cidate1",cidateArr[0]);
            request.setAttribute("cidate2",cidateArr[1]);
            request.setAttribute("cidate3",cidateArr[2]);
            request.setAttribute("codate1",codateArr[0]);
            request.setAttribute("codate2",codateArr[1]);
            request.setAttribute("codate3",codateArr[2]);
            request.setAttribute("fname",fname);
            request.setAttribute("lname",lname);
            request.setAttribute("mobile",mobile);
            request.setAttribute("email",email);
                RequestDispatcher rd = request.getRequestDispatcher("my-profile.jsp");
                rd.include(request,response);
            }
            }
            else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('You are not allowed to perform this customer only task!');");
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
