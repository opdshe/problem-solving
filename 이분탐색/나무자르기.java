package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나무자르기 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int[] woods = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int answer = search(woods, input[1]);
		System.out.println(answer);
	}

	private static int search(int[] woods, int goal) {
		int answer = -1;
		int left = 0;
		int right = Arrays.stream(woods)
				.max()
				.getAsInt();
		while (left <= right) {
			long sum = 0;
			int min = (left + right) / 2;
			for (int wood : woods) {
				if (wood > min) {
					sum += wood - min;
				}
			}
			if (sum >= goal) {
				answer = min;
				left = min + 1;
			} else {
				right = min - 1;
			}
		}
		return answer;
	}
}
