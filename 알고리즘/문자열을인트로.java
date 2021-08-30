package 알고리즘;

public class 문자열을인트로 {
	public static void main(String[] args) {
		System.out.println(stringToInt("1234"));
	}

	private static int stringToInt(String origin) {
		int result = 0;
		char[] chars = origin.toCharArray();
		for (char c : chars) {
			result *= 10;
			result += c - '0';
		}
		return result;
	}
}
