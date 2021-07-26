package 기출.카카오2020인턴;

import java.util.*;

public class 동굴탐험 {
	private static List<Integer>[] adjacent;
	private static int[] inDegree;

	public static void main(String[] args) {
		solution(9, new int[][]{{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}},
				new int[][]{{4,1}, {8, 7}, {6, 5}});
	}

	public static boolean solution(int n, int[][] path, int[][] order) {
		adjacent = new ArrayList[n];
		for (int idx = 0; idx < n; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int[] p : path) {
			adjacent[p[0]].add(p[1]);
			adjacent[p[1]].add(p[0]);
		}
		inDegree = new int[n];
		makeDirectedGraph(n);
		return search(n, order);
	}

	private static boolean search(int n, int[][] orders) {
		for (int[] order : orders) {
			adjacent[order[0]].add(order[1]);
			inDegree[order[1]]++;
		}

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		int count = 0;

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			count++;
			//System.out.println(current);
			for (Integer adj : adjacent[current]) {
				inDegree[adj]--;
				if (inDegree[adj] == 0) {
					queue.add(adj);
				}
			}
		}
		return count == n;
	}

	private static void makeDirectedGraph(int n) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[n];
		visited[0] = true;
		queue.add(0);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			for (Integer adj : adjacent[current]) {
				if (!visited[adj]) {
					visited[adj] = true;
					inDegree[adj]++;
					queue.add(adj);
				}
			}
		}
	}
}
