package 다이나믹프로그래밍;

import java.util.Scanner;

public class RGB거리 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int[][] board = new int[size + 1][size];
		for (int row = 1; row <= size; row++) {
			for (int column = 0; column < 3; column++) {
				board[row][column] = scanner.nextInt();
			}
		}
		int[][] dp = new int[size + 1][3];
		for (int idx = 1; idx <= size; idx++) {
			for (int color = 0; color < 3; color++) {
				if (color == 0) {
					dp[idx][color] = Math.min(dp[idx - 1][1], dp[idx - 1][2]) + board[idx][color];
				} else if (color == 1) {
					dp[idx][color] = Math.min(dp[idx - 1][0], dp[idx - 1][2]) + board[idx][color];
				} else {
					dp[idx][color] = Math.min(dp[idx - 1][0], dp[idx - 1][1]) + board[idx][color];
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int color = 0; color < 3; color++) {
			answer = Math.min(answer, dp[size][color]);
		}

		System.out.println(answer);
	}
}
