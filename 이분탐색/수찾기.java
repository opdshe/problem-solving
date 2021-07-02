package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 수찾기 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int countOfCards = Integer.parseInt(br.readLine());
		List<Integer> cards = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.boxed()
				.sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		int countOfTargets = Integer.parseInt(br.readLine());
		int[] targets = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		for (int target : targets) {
			System.out.println(hasTarget(cards, target));
		}
	}

	private static int hasTarget(List<Integer> cards, int target) {
		int position = Collections.binarySearch(cards, target);
		return position >= 0 ? 1 : 0;
	}
}
