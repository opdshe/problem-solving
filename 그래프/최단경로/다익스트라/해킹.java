package 그래프.최단경로.다익스트라;

import java.util.*;

public class 해킹 {
	private static final Scanner scanner = new Scanner(System.in);
	private static final int INF = 100000000;

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int i = 0; i < testcase; i++) {
			int size = scanner.nextInt();
			int dependencyCount = scanner.nextInt();
			int start = scanner.nextInt();
			List<Dependency>[] dependencies = new ArrayList[size + 1];
			for (int idx = 1; idx <= size; idx++) {
				dependencies[idx] = new ArrayList<>();
			}
			for (int d = 0; d < dependencyCount; d++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int time = scanner.nextInt();
				dependencies[b].add(new Dependency(a, time));
			}
			solution(dependencies, size, start);
		}
	}

	private static void solution(List<Dependency>[] dependencies, int size, int start) {
		Queue<Computer> queue = new PriorityQueue<>(Comparator.comparingLong(c -> c.time));
		int[] times = new int[size + 1];
		Arrays.fill(times, INF);
		times[start] = 0;
		queue.add(new Computer(start, 0));

		while (!queue.isEmpty()) {
			Computer current = queue.poll();
			if (current.time > times[current.idx]) {
				continue;
			}
			for (Dependency dependency : dependencies[current.idx]) {
				int time = current.time + dependency.time;
				if (times[dependency.dest] > time) {
					times[dependency.dest] = time;
					queue.add(new Computer(dependency.dest, time));
				}
			}
		}
		int time = 0;
		int count = 0;
		for (int idx = 1; idx <= size; idx++) {
			if (times[idx] != INF) {
				count++;
				time = Math.max(time, times[idx]);
			}
		}
		System.out.println(count + " " + time);
	}

	private static class Computer {
		private int idx;
		private int time;

		public Computer(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
	}

	private static class Dependency {
		private int dest;
		private int time;

		public Dependency(int dest, int time) {
			this.dest = dest;
			this.time = time;
		}
	}
}
