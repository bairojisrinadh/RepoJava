package com.highradius;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class EvaluateStringExpression {

	public static void main(String[] args) {
		String expression = "12+5/22*5";
		System.out.println("Result: "+evaluate(expression));

	}

	private static int evaluate(String expression) {
		Stack<String> operators = new Stack<>();
		Stack<String> operands = new Stack<>();
		
		String[] str = expression.split("(?<=[-+*/])|(?=[-+*/])");
		//System.out.println(Arrays.toString(str));
		//char[] charString = expression.toCharArray();
		for(String check : str){
			if(check.equals("+") || check.equals("-") || check.equals("/") || check.equals("*") ){
				operators.push(check);
			}else{
			operands.push(check);
			}
		}
		
		Integer result = 0;
		int size = operators.size();
		for(int i = 0 ; i < size; i++){
			String operator = operators.pop();
			/*int op1 = Character.getNumericValue(operands.pop());
			int op2 = Character.getNumericValue(operands.pop());*/
			int op1 = Integer.parseInt(operands.pop());
			int op2 = Integer.parseInt(operands.pop());
			switch(operator){
			case "*": result += op1 * op2;break;
			case "/": result += op1 / op2;break;
			case "+": result += op1 + op2;break;
			case "-": result += op1 - op2;break;
			}
			operands.push(result.toString());
		}
		return result;
		
	}

}
