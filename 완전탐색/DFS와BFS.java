package 완전탐색;

import java.io.IOException;
import java.util.*;

public class DFS와BFS {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Integer>[] adjacent;
	private static int vertex;
	private static int countOfEdge;
	private static int start;

	public static void main(String[] args) throws IOException {
		init();
		boolean[] visited = new boolean[vertex + 1];
		dfs(visited, start);
		System.out.println();
		bfs(start);
	}

	private static void dfs(boolean[] visited, int current) {
		visited[current] = true;
		System.out.print(current + " ");
		for (Integer next : adjacent[current]) {
			if (!visited[next]) {
				dfs(visited, next);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[vertex + 1];
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			System.out.print(current + " ");
			for (Integer next : adjacent[current]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}

	private static void init() throws IOException {
		vertex = scanner.nextInt();
		countOfEdge = scanner.nextInt();
		start = scanner.nextInt();
		adjacent = new ArrayList[vertex + 1];
		for (int idx = 0; idx < vertex + 1; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int idx = 0; idx < countOfEdge; idx++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			adjacent[source].add(dest);
			adjacent[dest].add(source);
		}
		for (int idx = 0; idx < vertex; idx++) {
			adjacent[idx].sort(Comparator.naturalOrder());
		}
	}
}
