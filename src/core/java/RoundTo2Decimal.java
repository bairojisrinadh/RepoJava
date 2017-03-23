package core.java;

public class RoundTo2Decimal {

	public static void main(String[] args) {
		double round = RoundTo2Decimal.round(14.5766422323, 3);
		System.out.println(round);

	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
