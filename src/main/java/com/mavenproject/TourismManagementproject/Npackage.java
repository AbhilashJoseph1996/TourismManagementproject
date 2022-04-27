package com.mavenproject.TourismManagementproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Npackage {
	private Connection con;
	private Statement st;
	Scanner sc=new Scanner(System.in);
	////Establishing a connection
	public Connection getConnect()throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","admin","Abhilash@123");
	return con;
	}
	//Method to add package
	public String addPackage() {
		try {
			
			con=getConnect();
			//Create a statement using connection object
			PreparedStatement pst= con.prepareStatement("insert into normal_package values(?,?,?,?,?,?)");
		System.out.println("Enter the no of values to enter:");
		int num=sc.nextInt();
		for(int i=1;i<=num;i++) {
			System.out.println("Enter the pkgNo:");
			String pkgNo=sc.next();
			System.out.println("Enter the first destination:");
			String d1=sc.next();
			System.out.println("Enter the second destination:");
			String d2=sc.next();
			System.out.println("Enter the third destination:");
			String d3=sc.next();
			System.out.println("Enter the duration:");
			int days=sc.nextInt();
			System.out.println("Enter the price:");
			int price=sc.nextInt();
			//setting place holder values
			pst.setString(1,pkgNo);
			pst.setString(2,d1);
			pst.setString(3,d2);
			pst.setString(4,d3);
			pst.setInt(5,days);
			pst.setInt(6,price);
			pst.executeUpdate();
			System.out.println(pkgNo +" Details got added");
		}
		con.close();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return "NormalPkg Added";
	}
	//View all package
	public void viewAllPackage() {
		try {
		
		con=getConnect();
		st=con.createStatement();
		String qry="select pkgNo,destination1,destination2,destination3,duration,price from normal_package";
		//Execute the query
		ResultSet rs=st.executeQuery(qry);
		//Process the ResultSet object
		while(rs.next()) {
			System.out.println("PkgNo:"+rs.getString(1));
			System.out.println("Destination1:"+ rs.getString(2));
			System.out.println("Destination2:"+rs.getString(3));
			System.out.println("Destination3:"+rs.getString(4));
			System.out.println("Duration:"+rs.getString(5));
			System.out.println("Price:"+rs.getString(6));
			System.out.println();
		}
		con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	//View package
	public String viewPackage() {
		try {
			con = getConnect();
			st = con.createStatement();
		
			System.out.println("Enter the pkgNo:");
			String pkgNo = sc.next();
			String qry = "select pkgNo,destination1,destination2,destination3,duration,price from normal_package where pkgNo='"+pkgNo+"';";
			ResultSet rs = st.executeQuery(qry);
			if (rs.next()) {
				System.out.println("PkgNo:"+rs.getString(1));
				System.out.println("Destination1:"+ rs.getString(2));
				System.out.println("Destination2:"+rs.getString(3));
				System.out.println("Destination3:"+rs.getString(4));
				System.out.println("Duration:"+rs.getString(5));
				System.out.println("Price:"+rs.getString(6));
			} else {
				System.out.println("User not available.....");
			}
			con.close();
	
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Package viewed";
	}
	//Update package
	public boolean updatePackage() {
		try {
			con = getConnect();
			st = con.createStatement();
		
			System.out.println("Enter the pkgNo:");
			String pkgNo = sc.next();
			System.out.println("Enter the price:");
			int price = sc.nextInt();
			String qry = "update normal_package set price =" +price + " where pkgNo='"+pkgNo+"';";
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
	//Delete package
	public boolean deletePackage() {
		try {
			con = getConnect();
			st = con.createStatement();
			System.out.println("Enter the pkgNo to delete:");
			String pkgNo = sc.next();
			String qry = "delete from normal_package where pkgNo='"+pkgNo+"';";
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

