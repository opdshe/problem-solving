package 그래프.위상정렬;

import java.util.*;

public class 음악프로그램 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int singerCount = scanner.nextInt();
		int pdCount = scanner.nextInt();
		List<Integer>[] adjacent = new ArrayList[singerCount + 1];
		int[] inDegree = new int[singerCount + 1];
		for (int idx = 1; idx <= singerCount; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int i = 0; i < pdCount; i++) {
			int orderCount = scanner.nextInt();
			int[] order = new int[orderCount];
			for (int idx = 0; idx < orderCount; idx++) {
				order[idx] = scanner.nextInt();
			}
			for (int idx = 1; idx < orderCount; idx++) {
				inDegree[order[idx]]++;
				adjacent[order[idx - 1]].add(order[idx]);
			}
		}
		sort(adjacent, inDegree, singerCount);
	}

	private static void sort(List<Integer>[] adjacent, int[] inDegree, int singerCount) {
		Queue<Integer> queue = new ArrayDeque<>();
		Queue<Integer> answer = new ArrayDeque<>();
		for (int singer = 1; singer <= singerCount; singer++) {
			if (inDegree[singer] == 0) {
				queue.add(singer);
			}
		}

		int count = 0;
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			count++;
			answer.add(current);
			for (Integer adj : adjacent[current]) {
				inDegree[adj]--;
				if (inDegree[adj] == 0) {
					queue.add(adj);
				}
			}
		}
		if (count == singerCount) {
			while (!answer.isEmpty()) {
				System.out.println(answer.poll());
			}
		} else {
			System.out.println(0);
		}
	}
}
