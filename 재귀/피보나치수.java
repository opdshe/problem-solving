package 재귀;

import java.util.Arrays;
import java.util.Scanner;

public class 피보나치수 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int[] dp = new int[target + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		int answer = fibonacci(dp, target);
		System.out.println(answer);
	}

	private static int fibonacci(int[] dp, int target) {
		if (dp[target] != -1) {
			return dp[target];
		}
		return dp[target] = fibonacci(dp, target - 1) + fibonacci(dp, target - 2);
	}
}
