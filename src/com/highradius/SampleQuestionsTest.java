package com.highradius;

import org.junit.Assert;
import org.junit.Test;

public class SampleQuestionsTest {
	
	@Test
	public void CharacterToCharTest(){
		Assert.assertEquals('C', SampleQuestions.convertCharactertochar(new Character('C')));
		Assert.assertEquals('A', SampleQuestions.convertCharactertochar(new Character('A')));
		Assert.assertNotEquals('g', SampleQuestions.convertCharactertochar(new Character('G')));
		Assert.assertEquals('E', SampleQuestions.convertCharactertochar(new Character('E')));
	}

}
