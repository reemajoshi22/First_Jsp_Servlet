package com.example.jdbclearning.jspservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class Hello_First extends HttpServlet {
	private static Connection con;
	  private static String MYSQL_URL = "jdbc:mysql://localhost:3306/test";
	  private static String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	  static ResultSet rs;
	  ResultSetMetaData rsmd_helloFirst;
	  static int columnsNumber;
	  int i;
	  String c,pa;
	 // Hello_First hl=new Hello_First();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/jsp");
		PrintWriter out = response.getWriter();
		//System.out.println("hello");
		String n=request.getParameter("username");
		String p=request.getParameter("userpass");
		System.out.println("username"+n +"password"+p);
		rs=LoginDao.validategetResultSet(n,p);
		
		//LoginDao.validate(n, p);
		System.out.println("result set in hello_first"+rs);
		try {
			while (rs.next()) {
			  	//Print one row    
				System.out.println("inside while");
				//c=rs.getString("name");
				//System.out.println("rs.next() in while loop"+rs.next());
			  	for( i = 1 ; i <= LoginDao.columnsNumber; i++){
			  		System.out.println("columnsNum above while loop"+columnsNumber);
			  	      System.out.println(rs.getString(i) + " "); //Print one element of a row
			  	   c= rs.getString(1);
			  	 pa= rs.getString(2);
			  	}

			  	  System.out.println();//Move to the next line to print the next row.           

			  	    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      
		if(n.equals(c)&p.equals(pa)){
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			request.setAttribute("passedName", c);
			request.setAttribute("passedPassword", pa);
			rd.include(request,response);
			System.out.println("logindao nxt system");
		}
		else{
			out.print("Sorry username or password error");
			RequestDispatcher rd=request.getRequestDispatcher("hello_first.jsp");
			rd.include(request,response);
		}
		
		out.close();
	}

	/*private boolean validate(String name, String pass) {
		// TODO Auto-generated method stub
		 boolean status=false;
		  try{
			  Class.forName(MYSQL_DRIVER);
		      System.out.println("Class Loaded....");
		       con = DriverManager.getConnection(MYSQL_URL,"root","root");
		      System.out.println("Connected to the database....");
		  	PreparedStatement ps=con.prepareStatement("select * from login2 where name=? and pass=?");
		  	ps.setString(1,name);
		  	ps.setString(2,pass);
		  	
		  	 rs=ps.executeQuery();
		  	 rsmd = rs.getMetaData();

		  	 columnsNumber = rsmd.getColumnCount();
		  	while (rs.next()) {
		  	//Print one row          
		  	for(int i = 1 ; i <= columnsNumber; i++){

		  	      System.out.println(rs.getString(i) + " "); //Print one element of a row

		  	}

		  	  System.out.println();//Move to the next line to print the next row.           

		  	    }
		  	status=rs.next();
		  	
		  	
		  }catch(Exception e){System.out.println(e);}
		  return status;
		  }*/
	}



