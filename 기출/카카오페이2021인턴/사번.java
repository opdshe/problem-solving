package 기출.카카오페이2021인턴;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 사번 {
	private static List<Node> nodes = new ArrayList<>();
	private static List<Integer> answer = new ArrayList<>();

	public static void main(String[] args) {
		solution(new long[]{8, 13, 5, 8}, new int[][]{{1, 3, 10}, {3, 4, 1}, {4, 2, 2}, {2, 1, 3}});
	}

	public static int[] solution(long[] ages, int[][] wires) {
		nodes.add(new Node(0, 0));
		for (int idx = 0; idx < ages.length; idx++) {
			nodes.add(new Node(idx + 1, ages[idx]));
		}
		for (int[] wire : wires) {
			nodes.get(wire[0]).edgeList.add(new Edge(wire[1], wire[2]));
		}
		int day = 0;
		for (int idx = 1; idx <= ages.length; idx++) {
			Node node = nodes.get(idx);
			node.plus =1;
		}
		while (answer.size() < ages.length) {

			for (int idx = 1; idx <= ages.length; idx++) {
				Node node = nodes.get(idx);
				node.pass();
			}
			for (int idx = 1; idx <= ages.length; idx++) {
				Node node = nodes.get(idx);
				node.setPlus();
			}

			day++;

		}
		int[] arr = answer.stream().
				mapToInt(Integer::valueOf)
				.toArray();
		System.out.println(Arrays.toString(arr));
		return arr;
	}

	private static class Node {
		private int idx;
		private long health;
		private long plus;
		private List<Edge> edgeList = new ArrayList<>();
		private boolean dead;

		public Node(int idx, long health) {
			this.idx = idx;
			this.health = health;
		}

		public void setPlus() {
			if (health > 0 || plus > 0) {
				for (Edge edge : edgeList) {
					Node node = nodes.get(edge.dest);
					node.plus = Math.max(node.plus, edge.cost);
				}
			}
		}

		public void pass() {
			this.health--;
			this.plus--;
			if ((health >= 0 || plus <= 0) && !dead) {
				dead= true;
				answer.add(this.idx);
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
