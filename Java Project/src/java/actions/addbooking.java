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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sayur
 */
public class addbooking extends HttpServlet {
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
            String uid = (String) session.getAttribute("LoggedInUserId");
            if ("customer".equals(urole)) {
                
            DateTimeFormatter in = DateTimeFormatter.ofPattern("yyyy MM dd");
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

                String sql = "insert into cart (adults, children, cidate, codate, total, uid) values(?,?,?,?,?,?)";
                Class.forName("com.mysql.jdbc.Driver");
                
                ps = connection.prepareStatement(sql);
                ps.setInt(1, adults);
                ps.setInt(2, children);
                ps.setString(3, ciidate);
                ps.setString(4, coodate);
                ps.setInt(5, (int) Total);
                ps.setInt(6,uidnum);
                
                ps.executeUpdate();

                String sql2 = "select fname,lname,mobile,email from users where uid=?";
                Class.forName("com.mysql.jdbc.Driver");
                ps = connection.prepareStatement(sql2);
                ps.setString(1, uid);

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
            
                request.setAttribute("livefname",fname);
                request.setAttribute("livelname",lname);
                request.setAttribute("livemobile",mobile);
                request.setAttribute("liveemail",email);
                request.setAttribute("liveadults",adult);
                request.setAttribute("livechildren",child);
                request.setAttribute("livecidate",ciidate);
                request.setAttribute("livecodate",coodate);
                request.setAttribute("livedays",daysBetween);
                request.setAttribute("subtotal",subTotal);
                request.setAttribute("scharge",servCharge);
                request.setAttribute("total",Total);
                RequestDispatcher rd = request.getRequestDispatcher("booking-confirmation.jsp");
                rd.include(request,response);
            }
            else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Please sign in as a customer to continue !!');");
                out.println("location='sign-in.jsp';");
                out.println("</script>");
            }
      
        } catch (SQLException ex) {
            out.println(ex);
        } catch (ClassNotFoundException ex) {
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

}
