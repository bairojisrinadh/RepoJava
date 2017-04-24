package com.MySpring;

public class Triangle implements Shape {

	private int base;
	private int height;
	
	public Triangle(int base,int height){
		this.base = base;
		this.height = height;
	}
	
	public double draw(){
		System.out.println("Triangle Drawn");
		return (base*height)/2;
	}
}
