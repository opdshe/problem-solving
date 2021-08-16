package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 예산 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfCity = Integer.parseInt(br.readLine());
		int[] cities = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.sorted()
				.toArray();
		int budget = Integer.parseInt(br.readLine());
		System.out.println(solution(cities, budget));
	}

	private static long solution(int[] cities, int budget) {
		long left = 0;
		long right = cities[cities.length - 1];
		long answer = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int city : cities) {
				sum += Math.min(city, mid);
			}
			if (sum > budget) {
				right = mid - 1;
			} else {
				answer = Math.max(answer, mid);
				left = mid + 1;
			}
		}
		return answer;
	}
}
