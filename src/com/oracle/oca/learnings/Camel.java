package com.oracle.oca.learnings;

interface Rideable {
	String getGait();
	}

public class Camel implements Rideable {
	int weight = 2;
	public String getGait() { //previous code was just <code>String getGait()</code>
					    // --> cannot change the visibility of 
					   // inherited method of Rideable interface because all the method
					   // declarations in an interface are by default public abstract
					   // can't change public access modifier to default access modifier
					   // in sub class or implementation class.
							
		return " mph, lope";
	}
	
	void go(int speed) {
		++speed;
		weight++;
		int walkrate = speed * weight;
		System.out.print(walkrate + getGait());
		}
	
	public static void main(String[] args) {new Camel().go(8);}}
