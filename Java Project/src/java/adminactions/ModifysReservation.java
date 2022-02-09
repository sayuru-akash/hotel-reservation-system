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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sayur
 */
public class ModifysReservation extends HttpServlet {

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
                DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
            String rid = request.getParameter("rid");
            String adult = request.getParameter("adults");
            String child = request.getParameter("children");
            String ciidate = request.getParameter("cidate");
            String coodate = request.getParameter("codate");
            
            int adults = 0;
            int children = 0;
            int ridnum = 0;

                adults = Integer.parseInt(adult);
                children = Integer.parseInt(child);
                ridnum = Integer.parseInt(rid);


            long daysBetween = 1;
            
            try {
                Date date1 = formatter.parse(ciidate);
                Date date2 = formatter.parse(coodate);
                daysBetween = ChronoUnit.DAYS.between(date1.toInstant(), date2.toInstant());
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
                
                String sql2 = "select resid from bookings where resid=?";
                Class.forName("com.mysql.jdbc.Driver");
                ps = connection.prepareStatement(sql2);
                ps.setString(1, rid);

                String rcheck = null;
            
                rs = ps.executeQuery();
                while (rs.next()) {
                    rcheck = rs.getString(1);
                }
                
                if(rcheck!=null){
                String sql = "update bookings set adults=?, children=?, cidate=?, codate=?, amount=? where resid=?";
                Class.forName("com.mysql.jdbc.Driver");
                
                ps = connection.prepareStatement(sql);
                ps.setInt(1, adults);
                ps.setInt(2, children);
                ps.setString(3, ciidate);
                ps.setString(4, coodate);
                ps.setInt(5, (int) Total);
                ps.setInt(6,ridnum);
                
                ps.executeUpdate();
                
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Reservation modified Successfully !!');");
                out.println("location='./admin-modify-data.jsp';");
                out.println("</script>");
                
                }
                else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Reservation ID Does Not Exist!');");
                out.println("location='./admin-modify-data.jsp';");
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
