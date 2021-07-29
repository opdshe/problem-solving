package 세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 구간합구하기 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static long[] tree;
	private static long[] numbers;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		numbers = new long[input[0] + 1];
		tree = new long[input[0] * 4];
		for (int idx = 1; idx <= input[0]; idx++) {
			numbers[idx] = Integer.parseInt(br.readLine());
		}

		init(1, input[0], 1);
		for (int i = 0; i < input[1] + input[2]; i++) {
			long[] order = Arrays.stream(br.readLine().split(" "))
					.mapToLong(Long::parseLong)
					.toArray();
			if (order[0] == 1) {
				//update
				long offset = order[2] - numbers[(int) order[1]];
				numbers[(int) order[1]] = order[2];
				update(1, input[0], 1, (int) order[1], offset);
			} else if (order[0] == 2) {
				//sum
				long sum = sum(1, input[0], 1, (int) order[1], (int) order[2]);
				System.out.println(sum);
			}
		}
	}

	private static long init(long start, long end, int node) {
		if (start == end) {
			return tree[node] = numbers[(int) start];
		}
		long mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

	private static void update(long start, long end, int node, int target, long offset) {
		//target이 범위 밖에 있는 경우
		if (target < start || target > end) {
			return;
		}
		tree[node] += offset;
		if (start == end) {
			return;
		}
		long mid = (start + end) / 2;
		update(start, mid, node * 2, target, offset);
		update(mid + 1, end, node * 2 + 1, target, offset);
	}

	private static long sum(long start, long end, int node, int left, int right) {
		// 범위 밖
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && right >= end) {
			return tree[node];
		}
		long mid = (start + end) / 2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
}
