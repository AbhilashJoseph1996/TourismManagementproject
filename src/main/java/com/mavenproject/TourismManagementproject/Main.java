package com.mavenproject.TourismManagementproject;

import java.util.Scanner;

public class Main {
public static	void menu(){
		System.out.println("**********************USER DETAILS*************"
				+"\n1.Add User"
				+"\n2.ViewAll User"
				+"\n3.View User"
				+"\n4.Update User"
				+"\n5.Delete User"
				+"\n**********************AGENT DETAILS*******************"
				+"\n6.Add Agent"
				+"\n7.ViewAll Agent"
				+"\n8.View Agent"
				+"\n9.Update Agent"
				+"\n10.Delete Agent\n"
				+"\n**********************NORMAL PACKAGE DETAILS***********"
				+"\n11.Add Package"
				+"\n12.ViewAll Package"
				+"\n13.View Package"
		        +"\n14.Update Package"
		        +"\n15.Delete Package"
		        +"\n**********************PREMIUM PACKAGE DETAILS***********"
		        +"\n16.Add Package"
		        +"\n17.ViewAll Package"
				+"\n18.View Package"
		        +"\n19.Update Package"
		        +"\n20.Delete Package"
		        +"\n**********************HOTEL DETAILS***********"
		        +"\n21.Add Hotel"
				+"\n22.ViewAll Hotel"
				+"\n23.View Hotel"
		        +"\n24.Update Hotel"
		        +"\n25.Delete Hotel"
		        +"\n26.Exit from this application"
				);
		System.out.println("***************************************************");
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
UserDetails us=new UserDetails();
AgentDAO ag=new AgentDAO();
Npackage np=new Npackage();
PpackageDAO pp=new PpackageDAO();
HotelDAO ht=new HotelDAO();
menu();
System.out.println("Enter your choice");
int choice =sc.nextInt();
switch(choice) {

case 1:
	System.out.println(" ###Add User####");
	us.createUser();
	break;
case 2:
	System.out.println("###ViewAll User###");
	us.retriveUserAllDetails();
	break;
case 3:
	System.out.println("###View User###");
	us.retriveUserDetails();
	break;
case 4:
	System.out.println("###Update User###");
	if(us.updateUser()) {
	System.out.println("User detail updated");
	}
	else {
		System.out.println("Invalid User");
	}
	break;
case 5:
	System.out.println("###Delete User###");
	if(us.deleteUser()) {
		System.out.println("User detail Deleted");
		}
		else {
			System.out.println("Invalid User");
		}
	break;
case 6:
	System.out.println(" ###Add Agent####");
	ag.createAgent();
	break;
case 7:
	System.out.println("###ViewAll Agent###");
	ag.retriveAgentAllDetails();
	break;
case 8:
	System.out.println("###View  Agent###");
	ag.retriveAgentDetails();
	break;
case 9:
	System.out.println("###Update Agent###");
	if(ag.updateAgent()) {
	System.out.println("Agent details updated");
}
else {
	System.out.println("Invalid User");
}
	break;
case 10:
	System.out.println("###Delete Agent###");
	if(ag.deleteAgent()) {
	System.out.println("Agent details got deleted");
}
else {
	System.out.println("Invalid User");
}
	break;	
case 11:
	System.out.println("###Add package###");
	np.addPackage();
	break;
case 12:
	System.out.println("###ViewAll package###");
	np.viewAllPackage();
	break;
case 13:
	System.out.println("###View package###");
	np.viewPackage();
	break;
case 14:
	System.out.println("###Update package###");
	if(np.updatePackage()) {
		System.out.println("Package got updated");
	}
		else {
			System.out.println("package not found");
		}
	
	break;
case 15:
	System.out.println("###Delete package###");
	if(np.deletePackage()) {
		System.out.println("Package got deleted");
	}
	else {
		System.out.println("package not found");
	}
	break;
case 16:
	System.out.println("###Add package###");
	pp.addPackage();
	break;
case 17:
	System.out.println("###viewAll package###");
	pp.viewAllPackage();
	break;
case 18:
	System.out.println("###view package###");
	pp.viewPackage();
	break;
case 19:
	System.out.println("###Update package###");
	if(pp.updatePackage()) {
		System.out.println("Package got updated");
	}
		else {
			System.out.println("package not found");
		}
	
	break;
case 20:
	System.out.println("###Delete package###");
	if(pp.deletePackage()) {
		System.out.println("Package got deleted");
	}
	else {
		System.out.println("package not found");
	}
	break;
case 21:
	System.out.println("###Add Hotel###");
	ht.addHotel();
	break;	
case 22:
	System.out.println("###ViewAll Hotels###");
	ht.viewAllHotel();
	break;	
case 23:
	System.out.println("###View Hotel###");
	ht.viewHotel();
	break;	
case 24:
	System.out.println("###Update Hotel###");
	if(ht.updateHotel()) {
		System.out.println("Hotel got updated");
	}
		else {
			System.out.println("Hotel not found");
		}
	
	break;
case 25:
	System.out.println("###Delete Hotel###");
	if(ht.deleteHotel()) {
		System.out.println("Hotel got deleted");
	}
	else {
		System.out.println("Hotel not found");
	}
	break;
case 26:
	System.out.println("Thank you for using this application");
	System.exit(0);
default:
	System.out.println("Please enter valid choice");
	break;
	
}
	}
}


