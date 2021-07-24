package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 욕심쟁이판다 {
	private static final Scanner scanner = new Scanner(System.in);
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	private static int size;

	public static void main(String[] args) {
		size = scanner.nextInt();
		int[][] map = new int[size][size];
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				map[r][c] = scanner.nextInt();
			}
		}
		solution(map);
	}

	private static void solution(int[][] map) {
		int[][] dp = new int[size][size];
		int answer = -1;
		for (int r = 0; r < size; r++) {
			Arrays.fill(dp[r], -1);
		}
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				dfs(map, dp, r, c);
			}
		}
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				answer = Math.max(answer, dp[r][c]);
			}
		}
		System.out.println(answer);
	}

	private static int dfs(int[][] map, int[][] dp, int row, int column) {
		if (dp[row][column] != -1) {
			return dp[row][column];
		}
		int count = 1;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isValidPosition(nextRow, nextColumn) && map[nextRow][nextColumn] > map[row][column]) {
				count = Math.max(count, dfs(map, dp, nextRow, nextColumn)+1);
			}
		}
		return dp[row][column] = count;
	}

	private static boolean isValidPosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
