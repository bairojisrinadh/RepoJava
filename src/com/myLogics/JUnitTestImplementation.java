/*
 * @author - Srinadh Biroji
 * 
 * Below are annotations used for JUnit Testing
 * 
 * @Test - This is used to test the exact method execution.
 * @Before - This will be executed before every test method execution starts.
 * @After - This will be executed after every test method execution completes.
 * @BeforeClass - This will be executed before all the Test Methods of JUnit class are start executing.
 * @AfterClass - This will be executed after all the Test Methods of JUnit class completes execution.
 *  
 */


package com.myLogics;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTestImplementation {

	@Test
	public void actualTest1(){
		System.out.println("In Actual Test1 for Test Annotation");
	}
	
	@Test
	public void actualTest2(){
		System.out.println("In Actual Test2 for Test Annotation");
	}

	@Before
	public void thisIsImpletmentedBeforeTest(){
		System.out.println("In Before, This is implemented before each Test is executed");
	}
	
	@After
	public void thisIsImpletmentedAfterTest(){
		System.out.println("In After, This is implemented after each Test is executed");
	}
	
	@BeforeClass
	public static void thisIsImplementedBeforeAllTestOfJUnitClass(){
		System.out.println("In Before Class, This is implemented before all Tests of JUnit class are executed");
	}
	
	@AfterClass
	public static void thisIsImplementedAfterAllTestOfJUnitClass(){
		System.out.println("In After Class, This is implemented after all Tests of JUnit class are executed");
	}
}
