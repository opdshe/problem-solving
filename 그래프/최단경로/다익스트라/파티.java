package 그래프.최단경로.다익스트라;

import java.util.*;

public class 파티 {
	private static final Scanner scanner = new Scanner(System.in);
	private static List<Bus>[] adjacent;

	public static void main(String[] args) {
		int countOfCity = scanner.nextInt();
		int countOfBus = scanner.nextInt();
		int end = scanner.nextInt();
		init(countOfCity);
		for (int i = 0; i < countOfBus; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			adjacent[source].add(new Bus(dest, cost));
		}

		int answer = -1;
		for (int idx = 1; idx <= countOfCity; idx++) {
			if (idx == end) {
				continue;
			}
			int go = dijkstra(countOfCity, idx, end);
			int back = dijkstra(countOfCity, end, idx);
			answer = Math.max(answer, go + back);
		}
		System.out.println(answer);
	}

	private static int dijkstra(int countOfCity, int start, int end) {
		Queue<City> queue = new PriorityQueue<>(Comparator.comparing(city -> city.cost));
		int[] minCosts = new int[countOfCity + 1];
		Arrays.fill(minCosts, Integer.MAX_VALUE);
		minCosts[start] = 0;
		queue.add(new City(start, 0));
		while (!queue.isEmpty()) {
			City current = queue.poll();
			if (current.idx == end) {
				break;
			}
			if (current.cost > minCosts[current.idx]) {
				continue;
			}
			for (Bus bus : adjacent[current.idx]) {
				int cost = current.cost + bus.cost;
				if (minCosts[bus.dest] > cost) {
					minCosts[bus.dest] = cost;
					queue.add(new City(bus.dest, cost));
				}
			}
		}
		return minCosts[end];
	}

	private static void init(int countOfCity) {
		adjacent = new ArrayList[countOfCity + 1];
		for (int idx = 1; idx <= countOfCity; idx++) {
			adjacent[idx] = new ArrayList<>();
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

	private static class Bus {
		private int dest;
		private int cost;

		public Bus(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
