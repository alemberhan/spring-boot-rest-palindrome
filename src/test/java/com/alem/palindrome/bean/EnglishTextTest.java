package com.alem.palindrome.bean;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EnglishTextTest {
	
	@Test
	public void testEnglishTextPalindrome() {
		EnglishText text = new EnglishText("aba");
		
		assertEquals(text.getWord(), "aba");
		assertEquals(text.getReverse(), "aba");
		assertEquals(text.getPalindrome(), "YES");
		
	}

	@Test
	public void testEnglishTextNotPalindrome() {
		EnglishText text = new EnglishText("word");
		
		assertEquals(text.getWord(), "word");
		assertEquals(text.getReverse(), "drow");
		assertEquals(text.getPalindrome(), "NO");
		
	}
}
