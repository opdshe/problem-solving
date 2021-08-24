package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수찾기3 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfNumber = Integer.parseInt(br.readLine());
		int[] numbers = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.sorted()
				.toArray();
		int countOfTarget = Integer.parseInt(br.readLine());
		int[] targets = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		for (int target : targets) {
			System.out.println(hasTarget(numbers, target) ? "1" : "0");
		}
	}

	private static boolean hasTarget(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int midValue = numbers[mid];
			if (midValue > target) {
				right = mid - 1;
			} else if (midValue == target) {
				return true;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}
}
