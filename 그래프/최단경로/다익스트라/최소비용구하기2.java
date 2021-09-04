package 그래프.최단경로.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기2 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int countOfCity;
	private static int countOfBus;
	private static List<Bus>[] buses;
	private static List<Integer>[] route;

	public static void main(String[] args) throws IOException {
		countOfCity = Integer.parseInt(br.readLine());
		countOfBus = Integer.parseInt(br.readLine());
		buses = new ArrayList[countOfCity + 1];
		route = new ArrayList[countOfCity + 1];
		for (int idx = 1; idx <= countOfCity; idx++) {
			buses[idx] = new ArrayList<>();
			route[idx] = new ArrayList<>();
		}
		for (int idx = 1; idx <= countOfBus; idx++) {
			int[] busInfo = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			buses[busInfo[0]].add(new Bus(busInfo[1], busInfo[2]));
		}
		int[] routeInfo = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		int minCost = getMinCost(routeInfo[0], routeInfo[1]);
		System.out.println(minCost);
		System.out.println(route[routeInfo[1]].size());
		for (Integer integer : route[routeInfo[1]]) {
			System.out.print(integer + " ");
		}
	}

	private static int getMinCost(int source, int dest) {
		Queue<City> queue = new PriorityQueue<>(Comparator.comparingInt(city -> city.cost));
		queue.add(new City(source, 0));
		int[] costs = new int[countOfCity + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		costs[source] = 0;

		while (!queue.isEmpty()) {
			City current = queue.poll();
			if (current.cost > costs[current.idx]) {
				continue;
			}
			route[current.idx].add(current.idx);
			for (Bus bus : buses[current.idx]) {
				int cost = current.cost + bus.cost;
				if (costs[bus.dest] > cost) {
					costs[bus.dest] = cost;
					List<Integer> currentRoute = new ArrayList<>(route[current.idx]);
					route[bus.dest] = currentRoute;
					queue.add(new City(bus.dest, cost));
				}
			}
		}
		return costs[dest];
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
