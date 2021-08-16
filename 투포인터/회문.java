package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int test = 0; test < testcase; test++) {
			String str = br.readLine();
			System.out.println(getNumber(str));
		}
	}

	private static int getNumber(String origin) {
		int count = 0;
		int left = 0;
		int right = origin.length() - 1;
		while (left < right) {
			char leftChar = origin.charAt(left);
			char rightChar = origin.charAt(right);
			if (leftChar == rightChar) {
				left++;
				right--;
			} else {
				if(isPalindrome(origin, left+1, right)){
					return 1;
				}
				if(isPalindrome(origin, left, right-1)){
					return 1;
				}
				return 2;
			}
		}
		return count;
	}

	private static boolean isPalindrome(String origin, int left, int right) {
		while (left <= right) {
			if (origin.charAt(left) == origin.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}
}
