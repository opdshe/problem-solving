package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 중량제한 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Map<Integer, List<Edge>> adjacent = new HashMap<>();

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		for (int idx = 1; idx <= input[0]; idx++) {
			adjacent.put(idx, new ArrayList<>());
		}

		for (int i = 0; i < input[1]; i++) {
			int[] edgeInfo = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
			List<Edge> source = adjacent.get(edgeInfo[0]);
			List<Edge> dest = adjacent.get(edgeInfo[1]);

			source.add(new Edge(edgeInfo[1], edgeInfo[2]));
			dest.add(new Edge(edgeInfo[0], edgeInfo[2]));

			adjacent.put(edgeInfo[0], source);
			adjacent.put(edgeInfo[1], dest);
		}

		int[] target = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		dijkstra(input[0], target[0], target[1]);
	}

	private static void dijkstra(int cityCount, int source, int dest) {
		Queue<City> queue = new PriorityQueue<>(Comparator.comparingInt(city -> city.cost));
		queue.add(new City(source, Integer.MAX_VALUE));
		int[] maxWeight = new int[cityCount + 1];
		Arrays.fill(maxWeight, -1);
		maxWeight[source] = 0;

		while (!queue.isEmpty()) {
			City current = queue.poll();
			if (current.cost < maxWeight[current.idx]) {
				continue;
			}

			for (Edge adj : adjacent.get(current.idx)) {
				int cost = Math.min(current.cost, adj.cost);
				if (cost > maxWeight[adj.dest]) {
					maxWeight[adj.dest] = cost;
					queue.add(new City(adj.dest, cost));
				}
			}
		}
		System.out.println(maxWeight[dest]);
	}

	private static class City {
		private int idx;
		private int cost;

		public City(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
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
