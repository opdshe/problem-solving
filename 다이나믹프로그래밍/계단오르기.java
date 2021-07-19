package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfStair = Integer.parseInt(br.readLine());
		int[] stairs = new int[countOfStair + 1];
		for (int i = 1; i <= countOfStair; i++) {
			int stair = Integer.parseInt(br.readLine());
			stairs[i] = stair;
		}
		System.out.println(dp(stairs, countOfStair));
	}

	private static int dp(int[] stairs, int countOfStair) {
		int[] dp = new int[countOfStair + 1];
		dp[1] = stairs[1];
		if (countOfStair >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}
		for (int floor = 3; floor <= countOfStair; floor++) {
			int score = stairs[floor];
			int beforeOne = dp[floor - 3] + stairs[floor-1];
			int beforeTwo = dp[floor - 2];
			dp[floor] = Math.max(beforeOne, beforeTwo) + score;
		}
		return dp[countOfStair];
	}
}
