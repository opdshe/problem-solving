package 시뮬레이션;

import java.util.*;

public class 아기상어 {
	private static final Scanner scanner = new Scanner(System.in);
	private static final int INITIAL_SHARK_SIZE = 2;
	private static int mapSize;
	private static int time = 0;
	private static int[][] map;
	private static Shark shark;
	private static List<Fish> fishList = new ArrayList<>();
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	private static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		mapSize = scanner.nextInt();
		map = new int[mapSize][mapSize];
		for (int row = 0; row < mapSize; row++) {
			for (int column = 0; column < mapSize; column++) {
				int num = scanner.nextInt();
				if (num == 9) {
					shark = new Shark(row, column);
				} else if (num > 0) {
					map[row][column] = num;
					fishList.add(new Fish(num, row, column));
				}
			}
		}
		while (getNextFish().isPresent()) {
			Fish fish = getNextFish().get();
			shark.eat(fish);
		}
		System.out.println(time);
	}

	private static Optional<Fish> getNextFish() {
		initDistance();
		return fishList.stream()
				.filter(f -> f.size < shark.size && f.distance != INF)
				.min(new Comparator<Fish>() {
					@Override
					public int compare(Fish o1, Fish o2) {
						if (o1.distance > o2.distance) {
							return 1;
						} else if (o1.distance == o2.distance) {
							if (o1.row > o2.row) {
								return 1;
							} else if (o1.row == o2.row) {
								if (o1.column > o2.column) {
									return 1;
								}
							}
						}
						return -1;
					}
				});
	}

	private static void initDistance() {
		fishList.forEach(Fish::setDistance);
	}

	private static class Shark {
		private int size = INITIAL_SHARK_SIZE;
		private int row;
		private int column;
		private int count;

		public Shark(int row, int column) {
			this.row = row;
			this.column = column;
		}

		public void eat(Fish fish) {
			this.count++;
			map[fish.row][fish.column] = 0;
			this.row = fish.row;
			this.column = fish.column;
			time += fish.distance;
			if (count == this.size) {
				this.count = 0;
				this.size++;
			}
			fishList.remove(fish);
		}
	}

	private static class Fish {
		private int size;
		private int row;
		private int column;
		private int distance = INF;

		public Fish(int size, int row, int column) {
			this.size = size;
			this.row = row;
			this.column = column;
		}

		private void setDistance() {
			Queue<int[]> queue = new ArrayDeque<>();
			int[][] visited = new int[mapSize][mapSize];
			for (int idx = 0; idx < mapSize; idx++) {
				Arrays.fill(visited[idx], INF);
			}
			visited[shark.row][shark.column] = 0;
			queue.add(new int[]{shark.row, shark.column});
			while (!queue.isEmpty()) {
				int[] current = queue.poll();
				if (current[0] == this.row && current[1] == this.column) {
					this.distance = visited[current[0]][current[1]];
					return;
				}
				for (int[] direction : directions) {
					int nextRow = current[0] + direction[0];
					int nextColumn = current[1] + direction[1];
					if (isValidPosition(nextRow, nextColumn)) {
						if (visited[nextRow][nextColumn] == INF &&
								map[nextRow][nextColumn] <= shark.size) {
							visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
							queue.add(new int[]{nextRow, nextColumn});
						}
					}
				}
			}
		}
	}

	private static boolean isValidPosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < mapSize &&
				nextColumn >= 0 && nextColumn < mapSize;
	}
}
