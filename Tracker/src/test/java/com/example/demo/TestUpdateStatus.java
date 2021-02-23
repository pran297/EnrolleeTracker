package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.sql.Date;


import com.example.demo.controllers.WelcomeController;
import com.example.demo.entities.Enroller;


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


class TestUpdateStatus {
	private WelcomeController controller = new WelcomeController();
	private Enroller enrollee = new Enroller();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before all called  only once Before all tests");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("after all called only once after all tests ");
	}

	@BeforeEach
	void setUp(TestInfo info) throws Exception {
		System.out.println(info.getDisplayName()+"Called ");
	}

	@AfterEach
	void tearDown(TestInfo info) throws Exception {
		
		System.out.println(info.getDisplayName()+"Finished");
	}

	@Test
	void testStatus() {
		
		String str="2015-03-31";  
	    Date date=Date.valueOf(str);
	    
		enrollee.setId(1);
		enrollee.setDependent(null);
		enrollee.setBirthDate(date);
		enrollee.setFirstName("Apara");
		enrollee.setLastName("Gupta");
		enrollee.setPhoneNumber(12154087);
		enrollee.setStatus(true);
		
		int actual = controller.UpdateStatus(enrollee,false);
		int expected = 1;
		assertEquals(expected, actual);
	}

}
