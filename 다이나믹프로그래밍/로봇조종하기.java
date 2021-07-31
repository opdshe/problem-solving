package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 로봇조종하기 {
	private static final Scanner scanner = new Scanner(System.in);
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		int[][] map = new int[rows + 2][columns + 2];
		for (int row = 1; row <= rows; row++) {
			for (int column = 1; column <= columns; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		int[][] dp = new int[rows + 1][columns + 1];
		for (int row = 1; row <= rows; row++) {
			Arrays.fill(dp[row], Integer.MIN_VALUE);
		}
		boolean[][] visited = new boolean[rows + 1][columns + 1];
		int answer = dfs(map, dp, visited, rows, columns, 1, 1);
		System.out.println(answer);
	}

	private static int dfs(int[][] map, int[][] dp, boolean[][] visited, int rows, int columns, int row, int column) {
		if (dp[row][column] != Integer.MIN_VALUE) {
			return dp[row][column];
		}
		visited[row][column] = true;
		int current = map[row][column];
		int sum = current;
		if (isValidPosition(rows, columns, row, column - 1) && !visited[row][column - 1]) {
			visited[row][column - 1] = true;
			sum = Math.max(sum, current + dfs(map, dp, visited, rows, columns, row, column - 1));
			visited[row][column - 1] = false;
		}
		if (isValidPosition(rows, columns, row, column + 1) && !visited[row][column + 1]) {
			visited[row][column + 1] = true;
			sum = Math.max(sum, current + dfs(map, dp, visited, rows, columns, row, column + 1));
			visited[row][column + 1] = false;

		}
		if (isValidPosition(rows, columns, row + 1, column) &&!visited[row+1][column]) {
			visited[row + 1][column] = true;
			sum = Math.max(sum, current + dfs(map, dp, visited, rows, columns, row + 1, column));
			visited[row + 1][column] = false;
		}
		return dp[row][column] = sum;
	}

	private static boolean isValidPosition(int rows, int columns, int nextRow, int nextColumn) {
		return nextRow >= 1 && nextRow <= rows &&
				nextColumn >= 1 && nextColumn <= columns;
	}
}
