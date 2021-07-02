package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 설탕배달 {
	private static final Scanner scanner = new Scanner(System.in);
	private static final int[] units = new int[]{5, 3};

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int[] dp = new int[target + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int unit : units) {
			for (int number = unit; number <= target; number++) {
				int prev = number - unit;
				if (dp[prev] != Integer.MAX_VALUE && dp[number] > dp[prev] + 1) {
					dp[number] = dp[prev] + 1;
				}
			}
		}
		System.out.println(dp[target] == Integer.MAX_VALUE ? -1 : dp[target]);
	}
}
