package 그래프.서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 집합의표현 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		int[] parents = new int[Integer.parseInt(input[0]) + 1];
		for (int idx = 1; idx <= Integer.parseInt(input[0]); idx++) {
			parents[idx] = idx;
		}
		for (int i = 0; i < Integer.parseInt(input[1]); i++) {
			int[] order = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
			if (order[0] == 0) {
				union(parents, order[1], order[2]);
			} else if (order[0] == 1) {
				int parentA = find(parents, order[1]);
				int parentB = find(parents, order[2]);
				System.out.println(parentA == parentB ? "YES" : "NO");
			}
		}
	}

	private static void union(int[] parents, int a, int b) {
		int parentA = find(parents, a);
		int parentB = find(parents, b);
		if (parentA < parentB) {
			parents[parentB] = parentA;
		} else {
			parents[parentA] = parentB;
		}
	}

	private static int find(int[] parents, int a) {
		if (parents[a] != a) {
			return parents[a] = find(parents, parents[a]);
		}
		return a;
	}
}
