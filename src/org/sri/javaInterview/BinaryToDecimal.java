package org.sri.javaInterview;

public class BinaryToDecimal {

	public static void main(String[] args) {
		BinaryToDecimal b = new BinaryToDecimal();
		int x = 111;
		System.out.println(b.getConversion(x));
		System.out.println(b.usingParseInt(x));
	}

	private int getConversion(int x) {
		int decimal = 0;
		int power = 0;
		while(true){
			if(x==0){
				break;
			}else{
				int tmp = x%10;
				decimal += tmp*Math.pow(2,power);
				x=x/10;
				power++;
			}
		}
		return decimal;
		
	}
	
	public int usingParseInt(int x) {
		String binary = String.valueOf(x);
		int decimal = Integer.parseInt(binary, 2);
		return decimal;
	}

}
