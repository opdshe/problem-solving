package 그래프.최단경로.다익스트라;

import java.util.*;

public class 특정거리의도시찾기 {
	private static final Scanner scanner = new Scanner(System.in);
	private static List<Integer>[] adjacent;
	private static final int INF = 0xffffff;

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int K = scanner.nextInt();
		int S = scanner.nextInt();

		adjacent = new ArrayList[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int e = 0; e < M; e++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			adjacent[source].add(dest);
		}
		dijkstra(N, K, S);
	}

	private static void dijkstra(int N, int K, int S) {
		int[] distances = new int[N + 1];
		Queue<City> queue = new PriorityQueue<>(Comparator.comparingInt(city -> city.cost));
		Arrays.fill(distances, INF);
		distances[S] = 0;
		queue.add(new City(S, 0));

		while (!queue.isEmpty()) {
			City current = queue.poll();
			if (current.cost > distances[current.idx]) {
				continue;
			}
			for (Integer adj : adjacent[current.idx]) {
				if (distances[adj] > current.cost + 1) {
					distances[adj] = current.cost + 1;
					queue.add(new City(adj, current.cost + 1));
				}
			}
		}
		boolean hasAnswer = false;
		for (int idx = 1; idx <= N; idx++) {
			if (distances[idx] == K) {
				hasAnswer = true;
				System.out.println(idx);
			}
		}
		if(!hasAnswer){
			System.out.println(-1);
		}
	}

	private static class City {
		private int idx;
		private int cost;

		public City(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
