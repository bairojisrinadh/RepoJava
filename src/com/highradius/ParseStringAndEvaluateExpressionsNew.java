package com.highradius;

import java.util.Scanner;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ParseStringAndEvaluateExpressionsNew {

	public static String acceptString = "";

	public static void main(String... args){
		Scanner sc = null;
		try{
			sc = new Scanner(System.in);
			System.out.println("Enter Expression below which need to be Evaluated: ");
			acceptString = sc.nextLine();
			StringBuffer formattedExp = formatConversion(acceptString);
			String exp = formattedExp.toString();
			System.out.print("Output:" +acceptString + "  -->  "+ formattedExp);
			evaluate(exp);
		}finally{
			if(sc != null)
			sc.close();
		}
	}
	
	public static void evaluate(String formatConversion2) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		try {
			System.out.print(" = "+engine.eval(formatConversion2));
		} catch (ScriptException e) {
			System.err.println("Provide value expression string. Ex: (* 2 (- 7 3) 4)");
			e.printStackTrace();
		}
	}
		public static StringBuffer formatConversion(String inputExp) {
			char[] charList = inputExp.replaceAll("\\s", "").toCharArray();
			Stack<Character> stack = new Stack<>();
			char[] temp = new char[10];
			int i = 0,count = 0;
			for(char item : charList){
				if(item == '('){
					stack.push(item);
					count = 0;
				}else if(item == '*' || item == '/' || item == '+' || item == '-'){
					temp[i] = item;

				}else if(item != ')'){
					if(count == 0){
						stack.push(item);
						stack.push(temp[i]);
						i++;
						count++;}
					else {
						stack.push(item);
					}
				}else {
					stack.push(item);
					i = i - (count + 1);
					if(i >= 0)
					stack.push(temp[i]);
				}
			}
			
			StringBuffer str = new StringBuffer();
			for(char element : stack){
				str.append(element);
			}
			
			return str;
		}
}
