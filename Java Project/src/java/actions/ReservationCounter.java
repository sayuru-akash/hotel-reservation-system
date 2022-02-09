/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import common.dbconnection;
import common.mailer;
import common.smssender;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sayur
 */
public class ReservationCounter {
    private int maxAdults = 5;
    

    void makeRes(int adults, int children, String cidate, String codate, int total, int uidnum, String fname, String email, String mobile) {
        if(maxAdults>=adults){
            try {
                //out.println("Hi, Reservation Success!");
                maxAdults=maxAdults-adults;dbconnection obj_dbconnection = new dbconnection();
                Connection connection = obj_dbconnection.get_connection();
                PreparedStatement ps = null;
                ResultSet rs = null;
                
                String sql3 = "insert into bookings (adults, children, cidate, codate, amount, ptype, uid) values(?,?,?,?,?,'OFFLINE',?)";
                Class.forName("com.mysql.jdbc.Driver");
                
                ps = connection.prepareStatement(sql3);
                ps.setInt(1, adults);
                ps.setInt(2, children);
                ps.setString(3, cidate);
                ps.setString(4, codate);
                ps.setInt(5, total);
                ps.setInt(6,uidnum);
                
                ps.executeUpdate();
                

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ReservationCounter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            out.println("Hi, Maximum Adult Limit Per Room is exceeded");
        }
    }

}