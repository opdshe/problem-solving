package 그래프.최단경로.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 네트워크복구 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static List<Edge>[] adjacent;
	private static List<Edge> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		initAdjacent(input[0]);
		for (int edge = 0; edge < input[1]; edge++) {
			int[] edgeInfo = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			adjacent[edgeInfo[0]].add(new Edge(edgeInfo[0], edgeInfo[1], edgeInfo[2]));
			adjacent[edgeInfo[1]].add(new Edge(edgeInfo[1], edgeInfo[0], edgeInfo[2]));
		}
		dijkstra(input[0]);
		System.out.println(answer.size());
		for (Edge edge : answer) {
			System.out.println(edge.source + " " + edge.dest);
		}
	}

	private static void dijkstra(int N) {
		int[] costs = new int[N + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[1] = 0;
		Queue<Computer> queue = new PriorityQueue<>(Comparator.comparingInt((computer) -> computer.cost));
		queue.add(new Computer(1, 0));

		while (!queue.isEmpty()) {
			Computer current = queue.poll();
			if (current.cost > costs[current.idx]) {
				continue;
			}
			for (Edge edge : adjacent[current.idx]) {
				int cost = edge.cost + current.cost;
				if (costs[edge.dest] > cost) {
					costs[edge.dest] = cost;
					answer = answer.stream()
							.filter(e -> e.dest != edge.dest)
							.collect(Collectors.toList());
					queue.add(new Computer(edge.dest, cost));
					answer.add(edge);
				}
			}
		}
	}

	private static void initAdjacent(int N) {
		adjacent = new ArrayList[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
	}

	private static class Computer {
		private int idx;
		private int cost;

		public Computer(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
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
