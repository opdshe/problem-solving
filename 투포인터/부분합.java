package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 부분합 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] info = br.readLine().split(" ");
		int[] array = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		System.out.println(solution(array, Integer.parseInt(info[1])));

	}

	private static int solution(int[] array, int target) {
		int left = 0;
		int right = 0;
		int sum = 0;
		int minLength = Integer.MAX_VALUE;

		//right 는 exclusive
		while (true) {
			if (sum >= target) {
				minLength = Math.min(minLength, right - left);
				sum -= array[left];
				left++;
			} else if (right == array.length) {
				break;
			} else {
				sum += array[right];
				right++;
			}
		}
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
