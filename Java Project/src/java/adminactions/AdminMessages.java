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
public class AdminMessages extends HttpServlet {

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
                    if (user == null || user == "") {
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Please login first !!');");
                        out.println("location='sign-in.jsp';");
                        out.println("</script>");
                    } else {

                        dbconnection obj_dbconnection = new dbconnection();
                        Connection connection = obj_dbconnection.get_connection();
                        PreparedStatement ps = null;
                        ResultSet rs = null;

                        String sql2 = "select name,email,message from messages order by mid desc limit 5";
                        Class.forName("com.mysql.jdbc.Driver");
                        ps = connection.prepareStatement(sql2);

                        ArrayList<String> dbnames = new ArrayList<String>();
                        ArrayList<String> dbemails = new ArrayList<String>();
                        ArrayList<String> dbmessages = new ArrayList<String>();

                        rs = ps.executeQuery();
                        while (rs.next()) {
                            dbnames.add(rs.getString(1));
                            dbemails.add(rs.getString(2));
                            dbmessages.add(rs.getString(3));
                        }

                        String[] namesArr = new String[dbnames.size()];
                        namesArr = dbnames.toArray(namesArr);
                        String[] emailsArr = new String[dbemails.size()];
                        emailsArr = dbemails.toArray(emailsArr);
                        String[] messagesArr = new String[dbmessages.size()];
                        messagesArr = dbmessages.toArray(messagesArr);

                        request.setAttribute("name1", namesArr[0]);
                        request.setAttribute("name2", namesArr[1]);
                        request.setAttribute("name3", namesArr[2]);
                        request.setAttribute("name4", namesArr[3]);
                        request.setAttribute("name5", namesArr[4]);
                        request.setAttribute("email1", emailsArr[0]);
                        request.setAttribute("email2", emailsArr[1]);
                        request.setAttribute("email3", emailsArr[2]);
                        request.setAttribute("email4", emailsArr[3]);
                        request.setAttribute("email5", emailsArr[4]);
                        request.setAttribute("message1", messagesArr[0]);
                        request.setAttribute("message2", messagesArr[1]);
                        request.setAttribute("message3", messagesArr[2]);
                        request.setAttribute("message4", messagesArr[3]);
                        request.setAttribute("message5", messagesArr[4]);
                        RequestDispatcher rd = request.getRequestDispatcher("admin-messages.jsp");
                        rd.include(request, response);
                    }
                } else {
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
