package com.alem.palindrome.bean;

/**
 * @author Alemberhan Getahun
 *
 */

public class EnglishText {

	private String word;
	private String reverse;
	private String palindrome;

	public EnglishText(String word) {
		this.word = word;
		this.reverse = new StringBuffer(word).reverse().toString();
		this.palindrome = this.word.equals(this.reverse) ? "YES" : "NO";
	}

	public String getWord() {
		return word;
	}

	public String getReverse() {
		return reverse;
	}

	public String getPalindrome() {
		return palindrome;
	}

}
