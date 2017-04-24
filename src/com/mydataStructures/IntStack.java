package com.mydataStructures;

public class IntStack {
	
	private int stackSize;
	private int top;
	private int [] stack;
		
	public IntStack(){
		this.stackSize = 4;
		this.stack = new int[this.stackSize];
		System.out.println("Stack Size: "+this.stack.length);
		this.top = -1;
	}
	
	public IntStack(int size){
		this.stackSize = size;
		this.stack = new int[this.stackSize];
		System.out.println("Stack Size: "+this.stack.length);
		this.top = -1;
	}
	
	public void push(int item){
		if(!isFull()){
			top++;
			stack[top]= item;
		}else
			System.out.println("Stack is Full, Cannot insert more.");
	}
	
	public int pop(){
		if(!isEmpty()){
			return stack[top--];
		}else
			//return Integer.parseInt("Empty Stack");
			return 0;
	}
	
	public boolean isFull(){
		return (top == stack.length-1);
	}
	
	public boolean isEmpty(){
		return top == -1;
	}

}
