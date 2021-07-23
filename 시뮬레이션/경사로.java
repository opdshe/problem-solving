package 시뮬레이션;

import java.util.Scanner;

public class 경사로 {
	private static Scanner scanner = new Scanner(System.in);
	private static int size;
	private static int roadLength;

	public static void main(String[] args) {
		size = scanner.nextInt();
		roadLength = scanner.nextInt();
		int[][] map = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		int answer = solution(map);
		System.out.println(answer);
	}

	private static int solution(int[][] map) {
		int count = 0;
		boolean[][][] installed = new boolean[size][size][2];
		for (int row = 0; row < size; row++) {
			if (isPassable(map, installed, new int[]{row, 0}, new int[]{0, 1}, 0)) {
				count++;
			}
			if (isPassable(map, installed, new int[]{0, row}, new int[]{1, 0}, 1)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isPassable(int[][] map, boolean[][][] installed, int[] start, int[] offset, int dir) {
		int[] coordinate = start;
		int prev = map[coordinate[0]][coordinate[1]];
		for (int i = 0; i < size; i++) {
			int current = map[coordinate[0]][coordinate[1]];
			if (current != prev) {
				if (prev < current) {
					if (!checkRoad(map, installed, prev, coordinate, offset, 1, dir)) {
						return false;
					}
				} else {
					if (!checkRoad(map, installed, prev, coordinate, offset, 2, dir)) {
						return false;
					}
				}
			}
			prev = map[coordinate[0]][coordinate[1]];
			coordinate = new int[]{coordinate[0] + offset[0], coordinate[1] + offset[1]};
		}
		return true;
	}

	private static boolean checkRoad(int[][] map, boolean[][][] installed, int prev, int[] current, int[] offset, int direction, int dir) {
		try {
			//1이면 이전꺼보다 클때 (오르막길 확인)
			if (direction == 1) {
				prev = map[current[0]][current[1]];
				for (int i = 0; i < roadLength; i++) {
					current = new int[]{current[0] - offset[0], current[1] - offset[1]};
					if (map[current[0]][current[1]] != prev - 1 || installed[current[0]][current[1]][dir]) {
						return false;
					} else {
						installed[current[0]][current[1]][dir] = true;
					}
				}
			} else {
				for (int i = 0; i < roadLength; i++) {
					if (map[current[0]][current[1]] != prev - 1 || installed[current[0]][current[1]][dir]) {
						return false;
					} else {
						installed[current[0]][current[1]][dir] = true;
						current = new int[]{current[0] + offset[0], current[1] + offset[1]};
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
}
