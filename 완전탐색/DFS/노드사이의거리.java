package 완전탐색.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 노드사이의거리 {
	private static final Scanner scanner = new Scanner(System.in);
	private static List<Edge>[] edges;
	protected static int distance;

	public static void main(String[] args) {
		int countOfNode = scanner.nextInt();
		int countOfEdge = scanner.nextInt();
		edges = new ArrayList[countOfNode + 1];
		for (int idx = 1; idx <= countOfNode; idx++) {
			edges[idx] = new ArrayList<>();
		}
		for (int i = 0; i < countOfNode - 1; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			edges[source].add(new Edge(dest, cost));
			edges[dest].add(new Edge(source, cost));
		}
		for (int i = 0; i < countOfEdge; i++) {
			distance = 0;
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			boolean[] visited = new boolean[countOfNode + 1];
			getDistance(visited, source, dest, 0);
			System.out.println(distance);
		}
	}

	private static void getDistance(boolean[] visited, int current, int dest, int count) {
		if (current == dest) {
			distance = count;
			return;
		}
		visited[current] = true;
		for (Edge edge : edges[current]) {
			if (!visited[edge.dest]) {
				getDistance(visited, edge.dest, dest, count + edge.cost);
			}
		}
	}

	private static class Edge {
		private int dest;
		private int cost;

		public Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
