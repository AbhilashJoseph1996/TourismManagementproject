package com.mavenproject.TourismManagementproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HotelDAO {
	private Connection con;
	private Statement st;
	Scanner sc=new Scanner(System.in);
	//Establishing a connection
	public Connection getConnect()throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","admin","Abhilash@123");
	return con;
	}
	// method to add hotel
	public String addHotel() {
		try {
			
			con=getConnect();
			//Create a statement using connection object
			PreparedStatement pst= con.prepareStatement("insert into hotel values(?,?,?,?,?)");
		System.out.println("Enter the no of values to enter:");
		int num=sc.nextInt();
		for(int i=1;i<=num;i++) {
			System.out.println("Enter the HotelNo:");
			String hotelno=sc.next();
			System.out.println("Enter the HotelName:");
			String name=sc.next();
			System.out.println("Enter the Type:");
			String type=sc.next();
			System.out.println("Enter the location:");
			String location=sc.next();
			System.out.println("Enter the rate:");
			int rate=sc.nextInt();
			//setting place holder values
			pst.setString(1,hotelno);
			pst.setString(2,name);
			pst.setString(3,type);
			pst.setString(4,location);
			pst.setInt(5,rate);
			pst.executeUpdate();
			System.out.println(name +" Details got added");
		}
		con.close();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return "Hotel Added";
	}
	//View all hotel
	public void viewAllHotel() {
		try {
		
		con=getConnect();
		st=con.createStatement();
		String qry="select hotelNo,hotelName,hotelType,location,rate from hotel";
		//Execute the query
		ResultSet rs=st.executeQuery(qry);
		//Process the ResultSet object
		while(rs.next()) {
			System.out.println("HotelNo:"+rs.getString(1));
			System.out.println("HotelName:"+ rs.getString(2));
			System.out.println("HotelType:"+rs.getString(3));
			System.out.println("Location:"+rs.getString(4));
			System.out.println("Rate:"+rs.getString(5));
			System.out.println();
		}
		con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	//View hotel
	public String viewHotel() {
		try {
			con = getConnect();
			st = con.createStatement();
		
			System.out.println("Enter the hotelNo:");
			String hotelNo = sc.next();
			String qry = "select hotelNo,hotelName,hotelType,location,rate from hotel where hotelNo='"+hotelNo+"';";
			ResultSet rs = st.executeQuery(qry);
			if (rs.next()) {
				System.out.println("HotelNo:"+rs.getString(1));
				System.out.println("HotelName:"+ rs.getString(2));
				System.out.println("HotelType:"+rs.getString(3));
				System.out.println("Location:"+rs.getString(4));
				System.out.println("Rate:"+rs.getString(5));
				
			} else {
				System.out.println("User not available.....");
			}
			con.close();
	
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Hotel viewed";
	}
	//Update hotel
	public boolean updateHotel() {
		try {
			con = getConnect();
			st = con.createStatement();
		
			System.out.println("Enter the HotelNo:");
			String hotelNo = sc.next();
			System.out.println("Enter the Rate:");
			int rate = sc.nextInt();
			String qry = "update hotel set rate =" +rate + " where hotelNo='"+hotelNo+"';";
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
	//Delete hotel
	public boolean deleteHotel() {
		try {
			con = getConnect();
			st = con.createStatement();
			System.out.println("Enter the HotelNo to delete:");
			String hotelNo = sc.next();
			String qry = "delete from hotel where hotelNo='"+hotelNo+"';";
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


