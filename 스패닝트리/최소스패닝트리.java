package 스패닝트리;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 최소스패닝트리 {
	private static final Scanner sc = new Scanner(System.in);
	private static final List<Edge> edges = new ArrayList<>();

	public static void main(String[] args) {
		int countOfVertex = sc.nextInt();
		int countOfEdge = sc.nextInt();
		for (int i = 0; i < countOfEdge; i++) {
			int source = sc.nextInt();
			int dest = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new Edge(source, dest, cost));
		}
		edges.sort(Comparator.comparing(edge -> edge.cost));

		int[] parents = new int[countOfVertex + 1];
		for (int idx = 1; idx <= countOfVertex; idx++) {
			parents[idx] = idx;
		}
		int answer = 0;
		for (Edge edge : edges) {
			int parentOfSource = find(parents, edge.source);
			int parentOfDest = find(parents, edge.dest);
			if (parentOfSource != parentOfDest) {
				union(parents, edge.source, edge.dest);
				answer += edge.cost;
			}
		}
		System.out.println(answer);
	}

	private static int find(int[] parents, int target) {
		if (parents[target] != target) {
			parents[target] = find(parents, parents[target]);
		}
		return parents[target];
	}

	private static void union(int[] parents, int a, int b) {
		int parentOfA = find(parents, a);
		int parentOfB = find(parents, b);
		if (parentOfA < parentOfB) {
			parents[parentOfB] = parentOfA;
		} else {
			parents[parentOfA] = parentOfB;
		}
	}

	private static class Edge {
		private int source;
		private int dest;
		private int cost;

		public Edge(int source, int dest, int cost) {
			this.source = source;
			this.dest = dest;
			this.cost = cost;
		}
	}
}
