package 그래프.다익스트라;

import java.util.*;

public class 최단경로 {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Edge> adjacent[];

	public static void main(String[] args) {
		int countOfVertex = scanner.nextInt();
		int countOfEdge = scanner.nextInt();
		int start = scanner.nextInt();
		init(countOfVertex);
		for (int i = 0; i < countOfEdge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			adjacent[source].add(new Edge(dest, cost));
		}
		solution(countOfVertex, start);
	}

	private static void solution(int countOfVertex, int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::getCost));
		int[] costs = new int[countOfVertex + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[start] = 0;
		queue.add(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.cost > costs[current.idx]) {
				continue;
			}
			for (Edge edge : adjacent[current.idx]) {
				int cost = current.cost + edge.cost;
				if (costs[edge.dest] > cost) {
					costs[edge.dest] = cost;
					queue.add(new Node(edge.dest, cost));
				}
			}
		}
		for (int idx = 1; idx <= countOfVertex; idx++) {
			System.out.println(costs[idx] == Integer.MAX_VALUE ? "INF" : costs[idx]);
		}

	}

	private static class Node {
		private int idx;
		private int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		public int getCost() {
			return cost;
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

	private static void init(int countOfVertex) {
		adjacent = new ArrayList[countOfVertex + 1];
		for (int idx = 1; idx <= countOfVertex; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
	}
}
