package com.highradius;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ParseStringAndEvaluateExpressions {

	public static String acceptString = "";

	public static void main(String... args){
		Scanner sc = null;
		try{
			sc = new Scanner(System.in);
			System.out.println("Enter Expression below which need to be Evaluated: ");
			acceptString = sc.nextLine();
			String formattedExp = formatConversion(acceptString);
			System.out.print("Output:" +acceptString + "  -->  "+ formattedExp);
			evaluate(formattedExp);
		}finally{
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

	public static String formatConversion(String exp){
		char EMPTY = 0,temp = 0;
		int i=0;
		StringBuilder str = new StringBuilder();
		char[] chars = exp.replaceAll("\\s", "").toCharArray();
		char[] tempArrays = new char[25];
		for(char value : chars){
			switch (value){
			case '(' : str = str.append(value);
					   i++;
					   continue;
			case '+' : temp = value;
					   tempArrays[i]=value;
					   break;
			case '-' : temp = value;
					   tempArrays[i]=value;
					   break;
			case '*' : temp = value;
					   tempArrays[i]=value;
					   break;
			case '/' : temp = value;
					   tempArrays[i]=value;
					   break;
			case ')' : str=str.deleteCharAt(str.length() - 1);
					   i--;
					   temp = tempArrays[i];
					   str = str.append(value).append(temp);
					   continue;
			}
			if(value != temp){
				if(temp != EMPTY){
					str = str.append(value).append(temp);
				}
			}
		}
		return new String(str.deleteCharAt(str.length() - 1));
	}

}
