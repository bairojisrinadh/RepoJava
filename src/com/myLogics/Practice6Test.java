package com.myLogics;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Practice6Test{
	
	@Test
	public void testprintFirstNonRepeatedCharacterOfString(){
		assertEquals('b', Practice6.printFirstNonRepeatedCharacterOfString("abcdefghija")); 
		assertEquals('h', Practice6.printFirstNonRepeatedCharacterOfString("hello")); 
		assertEquals('J', Practice6.printFirstNonRepeatedCharacterOfString("Java")); 
		assertEquals('i', Practice6.printFirstNonRepeatedCharacterOfString("simplest"));
	}
	
	@Test
	public void testprintFirstNonRepeatedCharacterOfStringUsingSetAndList(){
		assertEquals('b', Practice6.printFirstNonRepeatedCharacterOfStringUsingSetAndList("abcdefghija")); 
		assertEquals('h', Practice6.printFirstNonRepeatedCharacterOfStringUsingSetAndList("hello")); 
		assertEquals('J', Practice6.printFirstNonRepeatedCharacterOfStringUsingSetAndList("Java")); 
		assertEquals('i', Practice6.printFirstNonRepeatedCharacterOfStringUsingSetAndList("simplest"));
	}
	
	@Test
	public void testprintFirstNonRepeatedCharacterOfStringUsingHaspMap(){
		assertEquals('b', Practice6.printFirstNonRepeatedCharacterOfStringUsingHaspMap("abcdefghija")); 
		assertEquals('h', Practice6.printFirstNonRepeatedCharacterOfStringUsingHaspMap("hello")); 
		assertEquals('J', Practice6.printFirstNonRepeatedCharacterOfStringUsingHaspMap("Java")); 
		assertEquals('i', Practice6.printFirstNonRepeatedCharacterOfStringUsingHaspMap("simplest"));
	}
}

