package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 호탤 {
	private static final Scanner scanner = new Scanner(System.in);
	private static final int INF = 987654321;

	public static void main(String[] args) {
		int goal = scanner.nextInt();
		int cities = scanner.nextInt();
		int[] dp = new int[goal + 101];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int i = 0; i < cities; i++) {
			int cost = scanner.nextInt();
			int benefit = scanner.nextInt();
			for (int current = benefit; current < goal + 101; current++) {
				dp[current] = Math.min(dp[current], dp[current - benefit] + cost);
			}
		}
		int answer = INF;
		for (int idx = goal; idx < goal + 101; idx++) {
			answer = Math.min(answer, dp[idx]);
		}
		System.out.println(answer);
	}
}
