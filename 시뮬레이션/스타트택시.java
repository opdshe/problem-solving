package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스타트택시 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final int INF = 0xffffff;
	private static Taxi taxi;
	private static List<Person> people = new ArrayList<>();
	private static int size;
	private static int[][] board;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) throws IOException {
		String[] info = bf.readLine().split(" ");
		size = Integer.parseInt(info[0]);
		int countOfPeople = Integer.parseInt(info[1]);
		int fuel = Integer.parseInt(info[2]);
		board = new int[size + 1][size + 1];
		for (int row = 1; row <= size; row++) {
			int[] temp = Arrays.stream(bf.readLine().split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
			for (int column = 1; column <= size; column++) {
				board[row][column] = temp[column - 1];
			}
		}
		info = bf.readLine().split(" ");
		int row = Integer.parseInt(info[0]);
		int column = Integer.parseInt(info[1]);
		taxi = new Taxi(row, column, fuel);
		for (int i = 0; i < countOfPeople; i++) {
			info = bf.readLine().split(" ");
			int r = Integer.parseInt(info[0]);
			int c = Integer.parseInt(info[1]);
			int dr = Integer.parseInt(info[2]);
			int dc = Integer.parseInt(info[3]);
			people.add(new Person(r, c, dr, dc));
		}
		solution();
	}

	private static void solution() {
		while (getNextPerson().isPresent()) {
			Person person = getNextPerson().get();
			taxi.pickUp(person);
			if (taxi.isEnoughFuel(person)) {
				taxi.go(person);
			} else {
				taxi.fuel = -1;
				break;
			}
		}
		if (!people.isEmpty()) {
			taxi.fuel = -1;
		}
		System.out.println(taxi.fuel);
	}

	private static Optional<Person> getNextPerson() {
		initDistance();
		return people.stream()
				.filter(person -> person.distance <= taxi.fuel && person.distance != INF).min(new Comparator<Person>() {
					@Override
					public int compare(Person o1, Person o2) {
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
		int[][] distanceMap = getDistanceMap(taxi.row, taxi.column);
		for (Person person : people) {
			person.distance = distanceMap[person.row][person.column];
		}
	}

	private static boolean isValidPosition(int nextRow, int nextColumn) {
		return nextRow >= 1 && nextRow <= size &&
				nextColumn >= 1 && nextColumn <= size;
	}

	private static class Taxi {
		private int row;
		private int column;
		private int fuel;

		public Taxi(int row, int column, int fuel) {
			this.row = row;
			this.column = column;
			this.fuel = fuel;
		}

		public void pickUp(Person person) {
			fuel -= person.distance;
			this.row = person.row;
			this.column = person.column;
		}

		public boolean isEnoughFuel(Person person) {
			int distance = getMinDistance(row, column, person.destRow, person.destColumn);
			return distance <= fuel;
		}

		public void go(Person person) {
			int distance = getMinDistance(row, column, person.destRow, person.destColumn);
			this.row = person.destRow;
			this.column = person.destColumn;
			fuel += distance;
			people.remove(person);
		}
	}

	private static class Person {
		private int row;
		private int column;
		private int destRow;
		private int destColumn;
		private int distance;

		public Person(int row, int column, int destRow, int destColumn) {
			this.row = row;
			this.column = column;
			this.destRow = destRow;
			this.destColumn = destColumn;
		}
	}

	private static int getMinDistance(int sr, int sc, int dr, int dc) {
		int[][] distanceMap = getDistanceMap(sr, sc);
		return distanceMap[dr][dc];
	}

	private static int[][] getDistanceMap(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		int[][] distances = new int[size + 1][size + 1];
		for (int row = 1; row <= size; row++) {
			Arrays.fill(distances[row], INF);
		}
		distances[sr][sc] = 0;
		queue.add(new int[]{sr, sc});
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int[] direction : directions) {
				int nextRow = current[0] + direction[0];
				int nextColumn = current[1] + direction[1];
				if (isValidPosition(nextRow, nextColumn) && board[nextRow][nextColumn] == 0 &&
						distances[nextRow][nextColumn] == INF) {
					distances[nextRow][nextColumn] = distances[current[0]][current[1]] + 1;
					queue.add(new int[]{nextRow, nextColumn});
				}
			}
		}
		return distances;
	}
}
