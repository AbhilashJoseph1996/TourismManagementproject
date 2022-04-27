package com.mavenproject.TourismManagementproject;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitTest {

	@Test
	public void testupdateUser() {
		System.out.println();
		System.out.println("update user");
		UserDetails ud=new UserDetails();
		assertEquals(true,ud.updateUser());
	}
	@Test
	public void testcreateUser() {
		System.out.println();
		System.out.println("create user");
		UserDetails ud=new UserDetails();
		assertEquals("User Added",ud.createUser());
	}
	@Test
	public void testdeleteUser() {
		System.out.println();
		System.out.println("delete user");
		UserDetails ud=new UserDetails();
		assertEquals(true,ud.deleteUser());
}
	@Test
	public void retriveUserDetails() {
		System.out.println();
		System.out.println("retrive user");
		UserDetails ud =new UserDetails ();
		assertEquals("User retrived",ud.retriveUserDetails());
}
	@Test
	public void testcreateAgent() {
		System.out.println();
		System.out.println("create agent");
		AgentDAO ad=new AgentDAO();
		assertEquals("Agent Added",ad.createAgent());
	}
	public void retriveAgentDetails() {
		System.out.println();
		System.out.println("retrive agent");
		AgentDAO ad =new AgentDAO();
		assertEquals("Agent retrived",ad.retriveAgentDetails());
	}
	@Test
	public void testupdateAgent() {
		System.out.println();
		System.out.println("update agent");
		AgentDAO ad=new AgentDAO();
		assertEquals(true,ad.updateAgent());
	}
	@Test
	public void testdeleteAgent() {
		System.out.println();
		System.out.println("delete agent");
		AgentDAO ad=new AgentDAO();
		assertEquals(true,ad.deleteAgent());
	}
	@Test
	public void testaddPackage() {
		System.out.println();
		System.out.println("add normal package");
		Npackage nd=new Npackage();
		assertEquals("NormalPkg Added",nd.addPackage());
	}
	@Test
	public void testviewPackage() {
		System.out.println();
		System.out.println("view normal package");
		Npackage nd=new Npackage();
		assertEquals("Package viewed",nd.viewPackage());
	}
	@Test
	public void testupdatePackage() {
		System.out.println();
		System.out.println("update normal package");
		Npackage nd=new Npackage();
		//nd.updatePackage();
		assertEquals(true,nd.updatePackage());
	}
	@Test
	public void testdeletePackage() {
		System.out.println();
		System.out.println("delete normal package");
		Npackage nd=new Npackage();
		assertEquals(true,nd.deletePackage());
	}
	@Test
	public void testaddPremiumPackage() {
		System.out.println();
		System.out.println("add premium package");
		PpackageDAO pd=new PpackageDAO();
		assertEquals("PremiumPkg Added",pd.addPackage());
	}
	@Test
	public void testviewPremiumPackage() {
		System.out.println();
		System.out.println("view premium package");
		PpackageDAO pd=new PpackageDAO();
		assertEquals("Package Viewed",pd.viewPackage());
	}
	@Test
	public void testupdatePremiumPackage() {
		System.out.println();
		System.out.println("update premium package");
		PpackageDAO pd=new PpackageDAO();
		assertEquals(true,pd.updatePackage());
	}
	@Test
	public void testdeletePremiumPackage() {
		System.out.println();
		System.out.println("delete premium package");
		PpackageDAO pd=new PpackageDAO();
		assertEquals(true,pd.deletePackage());
	}
	@Test
	public void testaddHotel() {
		System.out.println();
		System.out.println("add hotel");
		HotelDAO hd=new HotelDAO();
		assertEquals("Hotel Added",hd.addHotel());
	}
	@Test
	public void viewHotel() {
		System.out.println();
		System.out.println("view hotel");
		HotelDAO hd=new HotelDAO();
		assertEquals("Hotel viewed",hd.viewHotel());
	}
	@Test
	public void testupdateHotel() {
		System.out.println();
		System.out.println("update hotel");
		HotelDAO hd=new HotelDAO();
		assertEquals(true,hd.updateHotel());
	}
	@Test
	public void testdeleteHotel() {
		System.out.println();
		System.out.println("delete hotel");
		HotelDAO hd=new HotelDAO();
		assertEquals(true,hd.deleteHotel());
	}
	}

