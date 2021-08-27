package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 일학년 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfNumber = Integer.parseInt(br.readLine());
		int[] numbers = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		long answer = solution(numbers, countOfNumber);
		System.out.println(answer);
	}

	private static long solution(int[] numbers, int countOfNumber) {
		long[][] dp = new long[countOfNumber][21];
		dp[0][numbers[0]] = 1;
		for (int idx = 1; idx < countOfNumber; idx++) {
			int currentValue = numbers[idx];
			for (int num = 0; num <= 20; num++) {
				if (dp[idx - 1][num] != 0) {
					if (isValidNumber(num + currentValue)) {
						dp[idx][num + currentValue] += dp[idx - 1][num];
					}
					if (isValidNumber(num - currentValue)) {
						dp[idx][num - currentValue] += dp[idx - 1][num];
					}
				}
			}
		}
		return dp[countOfNumber - 2][numbers[countOfNumber - 1]];
	}

	private static boolean isValidNumber(int number) {
		return number >= 0 && number <= 20;
	}
}
