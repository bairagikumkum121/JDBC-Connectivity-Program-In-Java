package com.jdbcdemo.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteMain {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter id of the "
				+ "product to be deleted : ");
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
		con.prepareStatement("DELETE FROM product"
				+ " WHERE id = ?");
		
		pst.setInt(1, pid);
		
		//4) execute the query
		int count = pst.executeUpdate();
		
		//6) process data from the ResultSet
		if(count > 0) {
			System.out.println("product deleted");
		}
		else {
			System.out.println("product was not"
		  + " deleted or no such product found");
		}
		
		//7) close the database Connection
		con.close();
		} catch (SQLException | 
				ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}
}





