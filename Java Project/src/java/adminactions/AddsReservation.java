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
public class AddsReservation extends HttpServlet {

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
            String urole = null;
            //Cookie ck[]=request.getCookies();  
            HttpSession session = request.getSession();
            urole = (String) session.getAttribute("LoggedInRole");
            
            if ("admin".equals(urole)) {
                DateTimeFormatter in = DateTimeFormatter.ofPattern("yyyy MM dd");
            String uid = request.getParameter("uid");
            String adult = request.getParameter("adults");
            String child = request.getParameter("children");
            String ciidate = request.getParameter("cidate");
            String coodate = request.getParameter("codate");
            
            int adults = 0;
            int children = 0;
            int uidnum = 0;

                adults = Integer.parseInt(adult);
                children = Integer.parseInt(child);
                uidnum = Integer.parseInt(uid);


            long daysBetween = 1;
            try {
                LocalDate date1 = LocalDate.parse(ciidate, in);
                LocalDate date2 = LocalDate.parse(coodate, in);
                daysBetween = ChronoUnit.DAYS.between(date1, date2);
                System.out.println ("Days: " + daysBetween);
            } catch (Exception e) {
            }
            
            long subTotal = 500*adults*daysBetween;
            subTotal=subTotal+250*children*daysBetween;
            long servCharge = subTotal/10;
            long Total = subTotal+servCharge;
            
                dbconnection obj_dbconnection = new dbconnection();
                Connection connection = obj_dbconnection.get_connection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                
                String sql2 = "select uid from users where uid=?";
                Class.forName("com.mysql.jdbc.Driver");
                ps = connection.prepareStatement(sql2);
                ps.setString(1, uid);

                String ucheck = null;
            
                rs = ps.executeQuery();
                while (rs.next()) {
                    ucheck = rs.getString(1);
                }
                
                if(ucheck!=null){
                String sql = "insert into bookings (adults, children, cidate, codate, amount, ptype, uid) values(?,?,?,?,?,'OFFLINE',?)";
                Class.forName("com.mysql.jdbc.Driver");
                
                ps = connection.prepareStatement(sql);
                ps.setInt(1, adults);
                ps.setInt(2, children);
                ps.setString(3, ciidate);
                ps.setString(4, coodate);
                ps.setInt(5, (int) Total);
                ps.setInt(6,uidnum);
                
                ps.executeUpdate();
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Reservation added Successfully !!');");
                out.println("location='./admin-add-data.jsp';");
                out.println("</script>");
                
                }
                else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User Does Not Exist. Please add the user before making a reservation !!');");
                out.println("location='./admin-add-data.jsp';");
                out.println("</script>");
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
