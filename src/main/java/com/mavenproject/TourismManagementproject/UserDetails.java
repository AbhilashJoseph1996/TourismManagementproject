package com.mavenproject.TourismManagementproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserDetails {

	private Connection con;
	private Statement st;
	Scanner sc=new Scanner(System.in);
	//Establishing a connection
	public Connection getConnect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism", "admin", "Abhilash@123");
		return con;
	}
//adding user
	public String createUser() {
		try {
		
			con = getConnect();
			//Create a statement using connection object
			PreparedStatement pst = con.prepareStatement("insert into user values(?,?,?,?)");
			System.out.println("Enter the no of values to enter:");
			int num = sc.nextInt();
			for (int i = 1; i <= num; i++) {
				System.out.println("Enter the id:");
				int ID = sc.nextInt();
				System.out.println("Enter the name:");
				String NAME = sc.next();
				System.out.println("Enter the age:");
				int AGE = sc.nextInt();
				System.out.println("Enter the place:");
				String PLACE = sc.next();
				//setting place holder values
				pst.setInt(1, ID);
				pst.setString(2, NAME);
				pst.setInt(3, AGE);
				pst.setString(4, PLACE);
				pst.executeUpdate();
				System.out.println(NAME + " Details got added");
			
				
			}
			con.close();
		
		} catch (Exception e) {
			System.out.println(e);

		}
		return "User Added";
	}
//view user
	public void retriveUserAllDetails() {
		try {

			con = getConnect();
			st = con.createStatement();
			String qry = "select ID,NAME,AGE,PLACE from user";
			//Execute the query
			ResultSet rs = st.executeQuery(qry);
			//Process the ResultSet object
			while (rs.next()) {
				System.out.println("User Id:" + rs.getString(1));
				System.out.println("User Name:" + rs.getString(2));
				System.out.println("User Age:" + rs.getString(3));
				System.out.println("Place:" + rs.getString(4));
				System.out.println();
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
//view all user
	public String retriveUserDetails() {
		try {
			con = getConnect();
			st = con.createStatement();
		
			System.out.println("Enter the id:");
			int id = sc.nextInt();
			String qry = "select ID,NAME,AGE,PLACE from user where ID=" + id;
			ResultSet rs = st.executeQuery(qry);
			if (rs.next()) {
				System.out.println("User Id:" + rs.getString(1));
				System.out.println("User Name:" + rs.getString(2));
				System.out.println("User Age:" + rs.getString(3));
				System.out.println("Place:" + rs.getString(4));
			} else {
				System.out.println("User not available.....");
			}
			con.close();
	
		} catch (Exception e) {
			System.out.println(e);
		}
		return "User retrived";
	}
//update user
	public boolean updateUser() {
		try {
			con = getConnect();
			st = con.createStatement();
		
			System.out.println("Enter the id:");
			int ID = sc.nextInt();
			System.out.println("Enter the age:");
			int AGE = sc.nextInt();
			String qry = "update user set AGE =" + AGE + " where ID=" + ID;
			int n=st.executeUpdate(qry);
			if(n>0) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
//Delete user
	public boolean deleteUser() {
		try {
			con = getConnect();
			st = con.createStatement();
	
			System.out.println("Enter the id to delete:");

			int ID = sc.nextInt();
			String qry = "delete from user where ID=" + ID;
			int n=st.executeUpdate(qry);
			if(n>0) {
				return true;
			}
			else {
				return false;
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
