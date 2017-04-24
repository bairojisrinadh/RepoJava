package com.myLogics;

import org.junit.Assert;
import org.junit.Test;

public class Practice5Test {
	
	@Test
	public void testcheckIfStringAreAnagrams(){
		Assert.assertTrue(Practice5.checkIfStringAreAnagrams("Mary","Army"));
		Assert.assertTrue(Practice5.checkIfStringAreAnagrams("Rammi","ammir"));
		Assert.assertFalse(Practice5.checkIfStringAreAnagrams("ashwini","wiash"));
		Assert.assertTrue(Practice5.checkIfStringAreAnagrams("Benny","yennb"));
	}
	
	
	@Test
	public void testcheckIfStringAreAnagramsUsingArraysClass(){
		Assert.assertTrue(Practice5.checkIfStringAreAnagramsUsingArraysClass("Mary","Army"));
		Assert.assertTrue(Practice5.checkIfStringAreAnagramsUsingArraysClass("Rammi","Ammir"));
		Assert.assertFalse(Practice5.checkIfStringAreAnagramsUsingArraysClass("Ashwini","Wiash"));
		Assert.assertTrue(Practice5.checkIfStringAreAnagramsUsingArraysClass("Benny","Yennb"));
	}
	
	
	@Test
	public void testcheckIfStringAreAnagramsUsingStringBuilder(){
		Assert.assertTrue(Practice5.checkIfStringAreAnagramsUsingStringBuilder("Mary","Army"));
		Assert.assertTrue(Practice5.checkIfStringAreAnagramsUsingStringBuilder("Rammi","ammir"));
		Assert.assertFalse(Practice5.checkIfStringAreAnagramsUsingStringBuilder("ashwini","wiash"));
		Assert.assertTrue(Practice5.checkIfStringAreAnagramsUsingStringBuilder("Benny","yennb"));
	}
	
	
	@Test
	public void testcheckIfStringAreAnagramsUsingSubString(){
		Assert.assertTrue(Practice5.checkIfStringAreAnagramsUsingSubString("Mary","Army"));
		Assert.assertTrue(Practice5.checkIfStringAreAnagramsUsingSubString("Rammi","ammir"));
		Assert.assertFalse(Practice5.checkIfStringAreAnagramsUsingSubString("ashwini","wiash"));
		Assert.assertTrue(Practice5.checkIfStringAreAnagramsUsingSubString("Benny","yennb"));
	}

}
