package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 수찾기2 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.boxed()
				.sorted()
				.collect(Collectors.toList());

		int M = Integer.parseInt(br.readLine());
		int[] targets = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		for (int target : targets) {
			System.out.println(hasTarget(numbers, target) ? "1" : "0");
		}
	}

	private static boolean hasTarget(List<Integer> numbers, int target) {
		return Collections.binarySearch(numbers, target) >= 0;
	}
}
