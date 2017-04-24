package com.myLogics;

import org.junit.Assert;
import org.junit.Test;


public class Practice8Test {
	
	@Test
	public void removeCharacterAndPrintStringUsingRecursiveTest(){
		Assert.assertEquals("Srinah", Practice8.removeCharacterAndPrintStringUsingRecursive("Srinadh", 'd'));
		Assert.assertEquals("Vrn", Practice8.removeCharacterAndPrintStringUsingRecursive("Varan", 'a'));
		Assert.assertEquals("Sudir", Practice8.removeCharacterAndPrintStringUsingRecursive("Sudhir", 'h'));
		Assert.assertEquals("SiTej", Practice8.removeCharacterAndPrintStringUsingRecursive("SaiTeja", 'a'));
	}

	@Test
	public void removeCharacterAndPrintStringUsingIterativeTest(){
		Assert.assertEquals("Srinah", Practice8.removeCharacterAndPrintStringUsingIterative("Srinadh", 'd'));
		Assert.assertEquals("Vrn", Practice8.removeCharacterAndPrintStringUsingIterative("Varan", 'a'));
		Assert.assertEquals("Sudir", Practice8.removeCharacterAndPrintStringUsingIterative("Sudhir", 'h'));
		Assert.assertEquals("SiTej", Practice8.removeCharacterAndPrintStringUsingIterative("SaiTeja", 'a'));
	}
}
