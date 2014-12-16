/**
 * @author Zhihong Cheng 
 * 
 * The Class ReverseDigit.
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 
 * 
 */

public class ReverseDigit {
	public int reverse(int x) {
		boolean negative = false;
		if (x < 0) {
			x = -x;
			negative = true;
		}
		String digits = "" + x;
		digits = reverse(digits);
		int output = Integer.parseInt(digits);
		if (negative) output = -output;
		return output;
	}
	
	private String reverse(String s) {
		String output = "";
		if (!s.isEmpty()) {
			output = output + reverse(s.substring(1)) + s.charAt(0);
		}
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println(new ReverseDigit().reverse(1));
	}
	
}
