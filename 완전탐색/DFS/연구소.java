package 완전탐색.DFS;

import java.util.*;

public class 연구소 {
	private static Scanner scanner = new Scanner(System.in);
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	private static List<int[]> blanks = new ArrayList<>();
	private static int[] orders = new int[3];
	private static int answer = 0;
	private static int rows;
	private static int columns;

	public static void main(String[] args) {
		rows = scanner.nextInt();
		columns = scanner.nextInt();
		int[][] map = new int[rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				map[r][c] = scanner.nextInt();
				if (map[r][c] == 0) {
					blanks.add(new int[]{r, c});
				}
			}
		}
		combine(map, new boolean[blanks.size()], 0, 0);
		System.out.println(answer);
	}


	private static void combine(int[][] map, boolean[] visited, int start, int count) {
		if (count == 3) {
			int[][] copy = deepCopy(map);
			for (int order : orders) {
				int[] wall = blanks.get(order);
				copy[wall[0]][wall[1]] = 1;
			}
			spread(copy);
			int safe = count(copy);
			answer = Math.max(answer, safe);
			return;
		}
		for (int idx = start; idx < blanks.size(); idx++) {
			if (!visited[idx]) {
				visited[idx] = true;
				orders[count] = idx;
				combine(map, visited, idx + 1, count + 1);
				visited[idx] = false;
			}
		}
	}

	private static void spread(int[][] map) {
		boolean[][] visited = new boolean[rows][columns];
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (map[row][column] == 2) {
					dfs(map, visited, row, column);
				}
			}
		}
	}

	private static int count(int[][] map) {
		int count = 0;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (map[row][column] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static void dfs(int[][] map, boolean[][] visited, int row, int column) {
		map[row][column] = 2;
		visited[row][column] = true;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isValidPosition(nextRow, nextColumn) && map[nextRow][nextColumn] == 0) {
				dfs(map, visited, nextRow, nextColumn);
			}
		}
	}

	private static boolean isValidPosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < rows &&
				nextColumn >= 0 && nextColumn < columns;
	}

	private static int[][] deepCopy(int[][] origin) {
		if (origin == null) return null;
		int[][] result = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
		}
		return result;
	}
}
