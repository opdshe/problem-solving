package 그래프.위상정렬;

import java.util.*;

public class 문제집 {
	private static final Scanner scanner = new Scanner(System.in);
	private static List<Integer>[] adjacent;
	private static int problems;
	private static int hints;
	private static int[] inDegree;

	public static void main(String[] args) {
		init();
		sorting();
	}

	private static void sorting() {
		Queue<Integer> queue = new PriorityQueue<>();
		for (int idx = 1; idx <= problems; idx++) {
			if (inDegree[idx] == 0) {
				queue.add(idx);
			}
		}

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			System.out.print(current + " ");
			for (Integer integer : adjacent[current]) {
				inDegree[integer]--;
				if (inDegree[integer] == 0) {
					queue.add(integer);
				}
			}
		}
	}

	private static void init() {
		problems = scanner.nextInt();
		hints = scanner.nextInt();
		inDegree = new int[problems + 1];
		adjacent = new ArrayList[problems + 1];
		for (int idx = 1; idx <= problems; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int i = 0; i < hints; i++) {
			int smaller = scanner.nextInt();
			int higher = scanner.nextInt();
			inDegree[higher]++;
			adjacent[smaller].add(higher);
		}
	}
}
