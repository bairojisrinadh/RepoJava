package org.sri.javaInterview;

public class SwapWithoutTemp {

	public static void main(String[] args) {
		SwapWithoutTemp s = new SwapWithoutTemp();
		int x=401, y=201;
		System.out.println("Before Swapping x= "+x+" & y= "+y);
		s.getSwap(x,y);
	}

	public void getSwap(int x, int y) {
		x = x+y;
		y = x-y;
		x = x-y;
		System.out.println("After Swapping x= "+x+" & y= "+y);
		
	}

}
