package 알고리즘;

public class 문자열역순출력 {
	public static void main(String[] args) {
		printReverseOrder("print reverse");
	}

	private static void printReverseOrder(String origin) {
		char[] chars = origin.toCharArray();
		for(int idx = 0; idx < chars.length; idx++){
			System.out.print(chars[origin.length()-idx-1]);
		}
	}
}
