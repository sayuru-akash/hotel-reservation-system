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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sayur
 */

public class ReservationThread extends Thread{
    
    private ReservationCounter reservationcounter;
    private int adults;
    private int children;
    private String cidate;
    private String codate;
    private int total;
    private int uidnum;
    private String fname;
    private String email;
    private String mobile;
    
    public ReservationThread(ReservationCounter reservationcounter, int adults, int children, String cidate, String codate, int total, int uidnum, String fname, String email, String mobile) throws ClassNotFoundException, SQLException{
                this.reservationcounter = reservationcounter;
                this.adults = adults;
                this.children = children;
                this.cidate = cidate;
                this.codate = codate;
                this.total = total;
                this.uidnum = uidnum;
                this.fname = fname;
                this.email = email;
                this.mobile = mobile;
    }
    public void run(){
        reservationcounter.makeRes(adults,children,cidate,codate,total,uidnum,fname,email,mobile);
    }
}
