package 그래프.최단경로.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 도로네트워크 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static List<Edge>[] adjacent;

	public static void main(String[] args) throws IOException {
		int countOfCity = Integer.parseInt(br.readLine());
		adjacent = new ArrayList[countOfCity + 1];
		for (int idx = 1; idx <= countOfCity; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int i = 0; i < countOfCity - 1; i++) {
			int[] edgeInfo = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
			adjacent[edgeInfo[0]].add(new Edge(edgeInfo[1], edgeInfo[2]));
			adjacent[edgeInfo[1]].add(new Edge(edgeInfo[0], edgeInfo[2]));
		}
		int order = Integer.parseInt(br.readLine());
		for (int i = 0; i < order; i++) {
			int[] orderInfo = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
			boolean[] visited = new boolean[countOfCity + 1];
			int shortestEdge = getShortestEdge(visited, orderInfo[0], orderInfo[1], Integer.MAX_VALUE);
			Arrays.fill(visited, false);
			int longestEdge = getLongestEdge(visited, orderInfo[0], orderInfo[1], 0);
			System.out.println(shortestEdge +" " + longestEdge);
		}
	}

	private static int getShortestEdge(boolean[] visited, int source, int dest, int current) {
		if (source == dest) {
			return current;
		}
		visited[source] = true;
		int shortestEdge = Integer.MAX_VALUE;
		for (Edge edge : adjacent[source]) {
			if (!visited[edge.dest]) {
				shortestEdge = Math.min(shortestEdge, getShortestEdge(visited, edge.dest, dest, Math.min(current, edge.cost)));
			}
		}
		return shortestEdge;
	}

	private static int getLongestEdge(boolean[] visited, int source, int dest, int current) {
		if (source == dest) {
			return current;
		}
		visited[source] = true;
		int longestEdge = 0;
		for (Edge edge : adjacent[source]) {
			if (!visited[edge.dest]) {
				longestEdge = Math.max(longestEdge, getLongestEdge(visited, edge.dest, dest, Math.max(current, edge.cost)));
			}
		}
		return longestEdge;
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
