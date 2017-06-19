package com.programcreek.interviewPrograms;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static void main(String[] args) {

		String[] inputs = {"4","13","5","/","+"};
		int result = evaluate(inputs);
		System.out.println("Result: "+ result);
	}

	public static int evaluate(String[] input) {
		//String[] inputs = input.split("");
		String operators = "+-/*";
		Stack<String> stack = new Stack<>();
		for(String element : input){
			if(!operators.contains(element)){
				stack.push(element);
			}else{
				int result = 0;
				if(!stack.isEmpty()){
					int op2 = Integer.valueOf(stack.pop());
					int op1 = Integer.valueOf(stack.pop());
					int index = operators.indexOf(element);
					switch(index){
					case 0: result = op1 + op2; break;
					case 3: result = op1 * op2; break;
					case 2: result = op1 / op2; break;
					case 1: result = op1 - op2; break;
					}
					stack.push(String.valueOf(result));
				}
			}
		}
		return Integer.valueOf(stack.pop());
	}

}
