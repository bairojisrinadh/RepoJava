package com.highradius;

/*
 * This Program in not completed fully need to work more on this program given by HighRadius Company
 * 
 */

import java.util.Scanner;
import java.util.Stack;


public class EvaluateExpressions {

	public static void main(String... args){
		Scanner sc = null;
		try{
			sc = new Scanner(System.in);
			String inputExp = sc.nextLine();
			computeExpression(evaluateExpression(inputExp));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sc != null){
			sc.close();
			}
		}
	}

	public static void computeExpression(StringBuffer exp) {
		int op1 = 0,op2 = 0;
		char op = 0;
		int size = exp.length();
		Stack<Character> operand = new Stack<>();
		Stack<Integer> values = new Stack<>();
			for(int i = 0; i<size-1;i++){
				if(exp.charAt(i) == '('|| exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*' || exp.charAt(i) == '/' ){
					operand.push(exp.charAt(i));
				}else if(exp.charAt(i) == ')'){
					op2 = values.pop();
					op = operand.pop();
					op1 = values.pop();
					int value = compute(op1,op2,op);
					if(operand.peek() == '('){
					operand.pop();
					}
					values.push(value);
				}else {
					values.push((int) exp.charAt(i));	
				}
			}
	}

	public static int compute(int op1, int op2, char op) {
		if(op == '*')
			return op1 * op2;
		else if(op == '+')
			return op1 + op2;
		else if(op == '-')
			return op1 - op2;
		else if(op == '/')
			return op1/op2;
		else 
			return 0;
	}

	public static StringBuffer evaluateExpression(String inputExp) {
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
			System.out.print(element);
			str.append(element);
		}
		
		return str;
	}

}
