package com.jdbcdemo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchMain {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter id of product"
				+ " to be searched : ");
		int pid = scanner.nextInt();
		
		try {
		//1) load the database Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2) get Connection with the database
		Connection con = 
		DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/12thjan24adv"
		+ "?useSSL=false","root","root");
		
		//3) create Statement to execute query
		PreparedStatement pst = 
				
		con.prepareStatement("SELECT * FROM"
		+ " product WHERE id = ?");
		
		pst.setInt(1, pid);
		
		//4) execute the query
		//5) store result of the query into ResultSet
		ResultSet rs = pst.executeQuery();
		
		//6) process data from the ResultSet
		if(rs.isBeforeFirst()) {
			rs.next();
			System.out.println(rs.getInt("id")
			+ " : " + rs.getString(2) + " : "
			+ rs.getInt("price"));
		}
		else {
			System.out.println("no such product"
					+ " found");
		}
		
		//7) close the database Connection
		con.clos
		e();
		} catch (SQLException | 
				ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}
}





