package com.MySpring;

public class Circle implements Shape {

	private int radius;
	
	public Circle(int radius){
		this.radius = radius;
	}
	
	public double draw(){
		System.out.println("Circle Drawn");
		return (Math.PI*radius*radius);
				
	}
}
