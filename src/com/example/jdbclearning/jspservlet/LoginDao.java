package com.example.jdbclearning.jspservlet;

import java.io.IOException;
import java.sql.*;

public class LoginDao {
	private static Connection con;
	private static String MYSQL_URL = "jdbc:mysql://localhost:3306/test";
	private static String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	static ResultSet rs;
	static ResultSetMetaData rsmd;
	static int columnsNumber;
	String em, pw;
	static boolean status = false, nxt_store;
	PreparedStatement preparedStatement = null;

	// String insertTableSQL = "INSERT INTO LOGIN2"
	// + "(name, pass) VALUES"
	// + "(?,?)";
	public static boolean validate(String name, String pass) {
		// boolean status=false;
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Class Loaded....");
			con = DriverManager.getConnection(MYSQL_URL, "root", "root");
			System.out.println("Connected to the database....");

			PreparedStatement ps = con
					.prepareStatement("select * from login2 where name=? and pass=?");
			System.out.println("PreparedStatement " + ps);
			ps.setString(1, name);
			ps.setString(2, pass);

			rs = ps.executeQuery();
			System.out.println(" rs=ps.executeQuery() statement" + rs);
			rsmd = rs.getMetaData();

			columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				// Print one row
				System.out.println("inside while loop");
				System.out.println("rs.next() in validate method" + rs.next());
				for (int i = 1; i <= columnsNumber; i++) {
					System.out.println("columnsNum above while loop"
							+ columnsNumber);
					System.out.println(rs.getString(i) + " "); // Print one
																// element of a
																// row

				}

				System.out.println();// Move to the next line to print the next
										// row.

			}
			status = rs.next();
			// System.out.println("nxt to status line"+rs.next());
			return status;
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static ResultSet validategetResultSet(String name, String pass) {
		// boolean status=false;
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Class Loaded....");
			con = DriverManager.getConnection(MYSQL_URL, "root", "root");
			System.out.println("Connected to the database....");

			PreparedStatement ps = con
					.prepareStatement("select * from login2 where name=? and pass=?");
			System.out.println("PreparedStatement " + ps);
			ps.setString(1, name);
			ps.setString(2, pass);

			rs = ps.executeQuery();
			if (!rs.next()) {
				PreparedStatement ps_insert = con
						.prepareStatement("insert into login2(name,pass) values(?,?)");
				System.out.println("insert PreparedStatement " + ps_insert);
				ps_insert.setString(1, name);
				ps_insert.setString(2, pass);
				int i = ps_insert.executeUpdate();
				if (i != 0) {
					System.out.println("Record has been inserted");
				} else {
					System.out.println("failed to insert the data");
				}
			}
			System.out.println(" rs=ps.executeQuery() statement" + rs);
			rsmd = rs.getMetaData();

			columnsNumber = rsmd.getColumnCount();
			/*
			 * while (rs.next()) { //Print one row
			 * System.out.println("inside while loop");
			 * //System.out.println("rs.next() in validate method"+rs.next());
			 * for(int i = 1 ; i <= columnsNumber; i++){
			 * System.out.println("columnsNum above while loop"+columnsNumber);
			 * System.out.println(rs.getString(i) + " "); //Print one element of
			 * a row
			 * 
			 * }
			 * 
			 * System.out.println();//Move to the next line to print the next
			 * row.
			 * 
			 * }
			 */

			// System.out.println("nxt to status line"+rs.next());
			// return status;
		} catch (Exception e) {
			System.out.println(e);
		}
		return rs;
	}

	public static ResultSet getResultSet(String name, String pass) {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Class Loaded resultset method....");
			con = DriverManager.getConnection(MYSQL_URL, "root", "root");
			System.out
					.println("Connected to the database result set method....");

			PreparedStatement ps = con
					.prepareStatement("select * from login2 where name=? and pass=?");
			System.out.println("PreparedStatement " + ps);
			ps.setString(1, name);
			ps.setString(2, pass);

			rs = ps.executeQuery();
			System.out.println(" rs=ps.executeQuery() statement" + rs);
			System.out.println("name" + name);
			System.out.println("pass" + pass);
			rsmd = rs.getMetaData();

			columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				// Print one row
				// System.out.println("rs.next() in while loop in logindao"+rs.next());
				for (int i = 1; i <= columnsNumber; i++) {
					System.out.println("columnsNum above while loop"
							+ columnsNumber);
					System.out.println(rs.getString(i) + " "); // Print one
																// element of a
																// row

				}

				System.out.println();// Move to the next line to print the next
										// row.

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
		// TODO Auto-generated method stub

	}

}
