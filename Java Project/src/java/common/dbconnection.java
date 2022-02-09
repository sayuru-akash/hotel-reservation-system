/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;


import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
    public static void main(String[] args) {
		dbconnection obj_dbconnection = new dbconnection();
		System.out.println(obj_dbconnection.get_connection());
	}

	public Connection get_connection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrhotel", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}
