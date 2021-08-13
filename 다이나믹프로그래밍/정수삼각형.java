package 다이나믹프로그래밍;

public class 정수삼각형 {
	public static int solution(int[][] triangle) {
		int answer = 0;
		int[][] dp = new int[triangle.length + 1][triangle.length + 1];
		for (int row = 1; row <= triangle.length; row++) {
			for (int column = 1; column <= row; column++) {
				int value = triangle[row - 1][column - 1];
				dp[row][column] = Math.max(dp[row - 1][column] + value, dp[row - 1][column - 1] + value);
			}
		}
		for (int column = 1; column <= triangle.length; column++) {
			answer = Math.max(answer, dp[triangle.length][column]);
		}
		return answer;
	}
}
