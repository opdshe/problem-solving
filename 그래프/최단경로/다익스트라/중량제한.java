package 그래프.최단경로.다익스트라;

import java.util.*;

public class 중량제한 {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Edge>[] adjacent;

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		adjacent = new ArrayList[N + 1];

		for (int i = 0; i < M; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			if(adjacent[source] ==null){
				adjacent[source] = new ArrayList<>();
			}
			if(adjacent[dest] ==null){
				adjacent[dest] = new ArrayList<>();
			}
			adjacent[source].add(new Edge(dest, cost));
			adjacent[dest].add(new Edge(source, cost));
		}
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		solution(N, start, end);
	}

	private static void solution(int N, int start, int end) {
		Queue<Node> queue = new ArrayDeque<>();
		int[] maxWeights = new int[N + 1];
		Arrays.fill(maxWeights, 0);
		maxWeights[start] = Integer.MAX_VALUE;
		queue.add(new Node(start, Integer.MAX_VALUE));
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (maxWeights[current.idx] > current.maxWeight) {
				continue;
			}
			for (Edge edge : adjacent[current.idx]) {
				int maxWeight = Math.min(current.maxWeight, edge.maxWeight);
				if (maxWeights[edge.dest] < maxWeight) {
					maxWeights[edge.dest] = maxWeight;
					queue.add(new Node(edge.dest, maxWeight));
				}
			}
		}
		System.out.println(maxWeights[end]);
	}


	private static class Node {
		private int idx;
		private int maxWeight;

		public Node(int idx, int maxWeight) {
			this.idx = idx;
			this.maxWeight = maxWeight;
		}
	}

	private static class Edge {
		private int dest;
		private int maxWeight;

		public Edge(int dest, int maxWeight) {
			this.dest = dest;
			this.maxWeight = maxWeight;
		}
	}
}
