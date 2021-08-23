package 다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 내리막길 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	private static int rows;
	private static int columns;

	public static void main(String[] args) throws IOException {
		String[] info = br.readLine().split(" ");
		rows = Integer.parseInt(info[0]);
		columns = Integer.parseInt(info[1]);
		int[][] board = new int[rows][columns];
		int[][] dp = new int[rows][columns];
		for (int row = 0; row < rows; row++) {
			board[row] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		for (int row = 0; row < rows; row++) {
			Arrays.fill(dp[row], -1);
		}

		int answer = getCountOfRoute(board, dp, 0, 0);
		System.out.println(answer);
	}

	private static int getCountOfRoute(int[][] board, int[][] dp, int row, int column) {
		if (dp[row][column] != -1) {
			return dp[row][column];
		}
		if (row == rows - 1 && column == columns - 1) {
			return 1;
		}

		int route = 0;
		int currentHeight = board[row][column];
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isValidPosition(nextRow, nextColumn) && currentHeight > board[nextRow][nextColumn]) {
				route += getCountOfRoute(board, dp, nextRow, nextColumn);
			}
		}
		return dp[row][column] = route;
	}

	private static boolean isValidPosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < rows &&
				nextColumn >= 0 && nextColumn < columns;
	}
}
