package org.sri.javaInterview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckExpressionInString {

	public static void main(String[] args) {
		String provided = "how are you";
		String expression = "h.a";
		checkIfExpressionExists(expression,provided);
	}

	public static void checkIfExpressionExists(String expression,
			String provided) {
		Pattern regex = Pattern.compile(expression);
		Matcher match = regex.matcher(provided);
		System.out.println(match.find());
	}

}
