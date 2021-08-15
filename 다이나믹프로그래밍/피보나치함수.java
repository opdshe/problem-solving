package 다이나믹프로그래밍;

import java.io.*;
import java.util.Arrays;

public class 피보나치함수 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		int[][] dp = new int[41][2];
		for (int idx = 0; idx <= 40; idx++) {
			Arrays.fill(dp[idx], -1);
		}
		dp[0] = new int[]{1, 0};
		dp[1] = new int[]{0, 1};
		for (int test = 0; test < testcase; test++) {
			int target = Integer.parseInt(br.readLine());
			int[] answer = fibonacci(dp, target);
			bw.write(answer[0] + " " + answer[1]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}


	private static int[] fibonacci(int[][] dp, int target) {
		if (target == 0 || target == 1) {
			return dp[target];
		}
		if (dp[target][0] == -1 || dp[target][1] == -1) {
			dp[target][0] = fibonacci(dp, target - 1)[0] + fibonacci(dp, target - 2)[0];
			dp[target][1] = fibonacci(dp, target - 1)[1] + fibonacci(dp, target - 2)[1];
		}
		return dp[target];
	}
}
