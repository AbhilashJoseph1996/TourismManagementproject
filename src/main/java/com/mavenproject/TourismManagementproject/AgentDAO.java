package com.mavenproject.TourismManagementproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AgentDAO {
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
		//Add agent
		public String createAgent() {
			try {
				
				con=getConnect();
				//Create a statement using connection object
				PreparedStatement pst= con.prepareStatement("insert into agent values(?,?,?,?,?)");
			System.out.println("Enter the no of values to enter:");
			int num=sc.nextInt();
			for(int i=1;i<=num;i++) {
				System.out.println("Enter the id:");
				int ID=sc.nextInt();
				System.out.println("Enter the name:");
				String NAME=sc.next();
				System.out.println("Enter the place:");
				String PLACE=sc.next();
				System.out.println("Enter the role:");
				String ROLE=sc.next();
				System.out.println("Enter the salary:");
				int SALARY=sc.nextInt();
				//setting place holder values
				pst.setInt(1,ID);
				pst.setString(2,NAME);
				pst.setString(3,PLACE);
				pst.setString(4,ROLE);
				pst.setInt(5,SALARY);
				pst.executeUpdate();
				System.out.println(NAME +" Details got added");
			}
			con.close();
			}
			catch(Exception e) {
				System.out.println(e);
				
			}
			return "Agent Added";
		}
		//View agent
		public void retriveAgentAllDetails() {
			try {
			
			con=getConnect();
			st=con.createStatement();
			String qry="select ID,NAME,PLACE,ROLE,SALARY from agent";
			//Execute the query
			ResultSet rs=st.executeQuery(qry);
			//Process the ResultSet object
			while(rs.next()) {
				System.out.println("User Id:"+rs.getString(1));
				System.out.println("User Name:"+ rs.getString(2));
				System.out.println("Place:"+rs.getString(3));
				System.out.println("Role:"+rs.getString(4));
				System.out.println("Salary:"+rs.getString(5));
				System.out.println();
			}
			con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		//View all agent
		public String retriveAgentDetails() {
			try {
				con=getConnect();
				st=con.createStatement();
				
				System.out.println("Enter the id:");
				int id=sc.nextInt();
				String qry= "select ID,NAME,PLACE,ROLE,SALARY from agent where ID="+id;
				ResultSet rs=st.executeQuery(qry);
				if(rs.next()) {
					System.out.println("User Id:"+rs.getString(1));
					System.out.println("Name:"+ rs.getString(2));
					System.out.println("Place:"+rs.getString(3));
					System.out.println("Role:"+rs.getString(4));
					System.out.println("Salary:"+rs.getString(5));
				}
				else {
					System.out.println("User not available.....");
				}
				con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return "Agent Retrived";
		}
		//Update agent
		public boolean updateAgent() {
			try {
				con=getConnect();
				st=con.createStatement();
				
				System.out.println("Enter the id:");
				int ID=sc.nextInt();
				System.out.println("Enter the salary:");
				int SALARY=sc.nextInt();
				String qry="update agent set SALARY ="+SALARY+" where ID="+ID;
				int n=st.executeUpdate(qry);
				if(n>0) {
					return true;
				}
				else {
					return false;
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return false;
			}
		//Delete agent
		public boolean deleteAgent() {
			try {
				con=getConnect();
				st=con.createStatement();
				System.out.println("Enter the id to delete:");
				
				int ID=sc.nextInt();
				String qry="delete from agent where ID="+ID;
				st.executeUpdate(qry);
				int n=st.executeUpdate(qry);
				if(n>0) {
					return true;
				}
				else {
					return false;
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return false;
		}
		}



