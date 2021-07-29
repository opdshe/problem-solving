package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 멀티탭스케줄링 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		int[] numbers = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		Set<Integer> plugs = new HashSet<>();
		int count = 0;
		for (int idx = 0; idx < input[1]; idx++) {
			int number = numbers[idx];
			if (plugs.contains(number)) {
				continue;
			}
			if (plugs.size() < input[0]) {
				plugs.add(number);
				continue;
			}
			int remove = number;
			int temp = idx;
			for (Integer plug : plugs) {
				int nextIdx = getNextIdx(numbers, plug, idx);
				if (nextIdx > temp) {
					temp = nextIdx;
					remove = plug;
				}
			}
			plugs.remove(remove);
			plugs.add(number);
			count++;
		}
		System.out.println(count);
	}

	private static int getNextIdx(int[] numbers, int target, int start) {
		for (int idx = start; idx < numbers.length; idx++) {
			if (numbers[idx] == target) {
				return idx;
			}
		}
		return numbers.length;
	}

}
