package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 최솟값과최댓값 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int[] numbers;
	private static long[] maxTree;
	private static long[] minTree;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		numbers = new int[input[0] + 1];
		maxTree = new long[input[0] * 4];
		minTree = new long[input[0] * 4];

		for (int idx = 1; idx <= input[0]; idx++) {
			numbers[idx] = Integer.parseInt(br.readLine());
		}
		initMax(1, input[0], 1);
		initMin(1, input[0], 1);

		for (int i = 0; i < input[1]; i++) {
			long[] order = Arrays.stream(br.readLine().split(" "))
					.mapToLong(Long::parseLong)
					.toArray();
			long min = getMin(1, input[0], 1, order[0], order[1]);
			long max = getMax(1, input[0], 1, order[0], order[1]);
			System.out.println(min + " " + max);
		}
	}

	private static long getMin(long start, long end, int node, long left, long right) {
		if (left > end || right < start) {
			return Long.MAX_VALUE;
		}
		if (left <= start && right >= end) {
			return minTree[node];
		}
		long mid = (start + end) / 2;
		return Math.min(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
	}

	private static long getMax(long start, long end, int node, long left, long right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && right >= end) {
			return maxTree[node];
		}
		long mid = (start + end) / 2;
		return Math.max(getMax(start, mid, node * 2, left, right), getMax(mid + 1, end, node * 2 + 1, left, right));
	}

	private static long initMax(long start, long end, int node) {
		if (start == end) {
			return maxTree[node] = numbers[(int) start];
		}
		long mid = (start + end) / 2;
		return maxTree[node] = Math.max(initMax(start, mid, node * 2), initMax(mid + 1, end, node * 2 + 1));
	}

	private static long initMin(long start, long end, int node) {
		if (start == end) {
			return minTree[node] = numbers[(int) start];
		}
		long mid = (start + end) / 2;
		return minTree[node] = Math.min(initMin(start, mid, node * 2), initMin(mid + 1, end, node * 2 + 1));
	}
}
