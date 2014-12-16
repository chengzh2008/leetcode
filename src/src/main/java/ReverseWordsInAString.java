
public class ReverseWordsInAString {
	
	public  String reverseWords(String s) {
		String[] input = s.trim().split("\\s+");
		String output = "";
		if (input.length > 0) {
			output = input[input.length-1];
		}
		for (int i = input.length-2; i>=0; i--) {
			output = output + " " + input[i];
		}
		return output;
	}
	
	public static void main(String[] args) {
		String s = " 1";
		String[] split = s.split("\\s+");
		ReverseWordsInAString t = new ReverseWordsInAString();
		String output = t.reverseWords(s);
		System.out.println(output);
	}

}
