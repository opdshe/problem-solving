package 그래프.서로소집합;

import java.util.*;

public class 섬연결하기 {
	public int solution(int n, int[][] costs) {
		List<Edge> edges = new ArrayList<>();
		int[] parent = new int[n];
		for(int idx = 0; idx < n; idx++){
			parent[idx] = idx;
		}
		for(int[] cost : costs){
			edges.add(new Edge(cost[0], cost[1], cost[2]));
		}
		edges.sort(Comparator.comparing(edge->edge.cost));
		int answer = 0;
		int count = 0;
		for(Edge edge : edges){
			int parentOfSource = find(parent, edge.source);
			int parentOfDest = find(parent, edge.dest);
			if(parentOfSource != parentOfDest){
				answer += edge.cost;
				union(parent, edge.source, edge.dest);
			}
		}
		return answer;
	}

	private static int find(int[] parent, int target){
		if(parent[target] != target){
			return parent[target]= find(parent, parent[target]);
		}
		return target;
	}

	private static void union(int[] parent, int a, int b){
		int parentA = find(parent, a);
		int parentB = find(parent, b);
		if(parentA < parentB){
			parent[parentA] = parentB;
		} else {
			parent[parentB] = parentA;
		}

	}

	private static class Edge{
		private int source;
		private int dest;
		private int cost;

		public Edge(int source, int dest, int cost){
			this.source = source;
			this.dest = dest;
			this.cost= cost;
		}
	}
}
