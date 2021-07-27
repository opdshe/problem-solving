package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 미세먼지안녕 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int rows;
	private static int columns;
	private static int time;
	private static int[][] board;
	private static int[] upper;
	private static int[] lower;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	static Map<Integer, int[]> directionMap = new HashMap<>();

	static {
		directionMap.put(1, new int[]{-1, 0});
		directionMap.put(2, new int[]{1, 0});
		directionMap.put(3, new int[]{0, -1});
		directionMap.put(4, new int[]{0, 1});
	}


	public static void main(String[] args) throws IOException {
		init();
		int t = 0;
		while (t < time) {
			spread();
			blowUpper();
			blowLower();
			t++;
		}
		int answer = count();
		System.out.println(answer);
	}

	private static int count() {
		int count = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (board[r][c] > 0) {
					count += board[r][c];
				}
			}
		}
		return count;
	}

	private static void init() throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		rows = input[0];
		columns = input[1];
		time = input[2];
		board = new int[rows][columns];
		for (int r = 0; r < rows; r++) {
			board[r] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
		}
		upper = findUpper();
		lower = new int[]{upper[0] + 1, 0};
	}

	private static void blowUpper() {
		int nextRow = upper[0];
		int nextColumn = upper[1] + 1;
		int dir = 4;
		int[] offset = directionMap.get(dir);
		int prev = 0;
		while (!(nextRow == upper[0] && nextColumn == upper[1])) {
			int temp = board[nextRow][nextColumn];
			board[nextRow][nextColumn] = prev;
			prev = temp;

			if (!isValidPosition(nextRow + offset[0], nextColumn + offset[1])) {
				if (dir == 4) {
					dir = 1;
				} else if (dir == 1) {
					dir = 3;
				} else if (dir == 3) {
					dir = 2;
				}
				offset = directionMap.get(dir);
			}
			nextRow = nextRow + offset[0];
			nextColumn = nextColumn + offset[1];
		}
	}

	private static void blowLower() {
		int nextRow = lower[0];
		int nextColumn = lower[1] + 1;
		int dir = 4;
		int[] offset = directionMap.get(dir);
		int prev = 0;
		while (!(nextRow == lower[0] && nextColumn == lower[1])) {
			int temp = board[nextRow][nextColumn];
			board[nextRow][nextColumn] = prev;
			prev = temp;

			if (!isValidPosition(nextRow + offset[0], nextColumn + offset[1])) {
				if (dir == 4) {
					dir = 2;
				} else if (dir == 2) {
					dir = 3;
				} else if (dir == 3) {
					dir = 1;
				}
				offset = directionMap.get(dir);
			}
			nextRow = nextRow + offset[0];
			nextColumn = nextColumn + offset[1];
		}
	}

	private static void spread() {
		int[][] offset = new int[rows][columns];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				for (int[] direction : directions) {
					int nextRow = r + direction[0];
					int nextColumn = c + direction[1];
					if (isValidPosition(nextRow, nextColumn) && board[nextRow][nextColumn] != -1) {
						offset[nextRow][nextColumn] += board[r][c] / 5;
						offset[r][c] -= board[r][c] / 5;
					}
				}
			}
		}

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				board[r][c] += offset[r][c];
			}
		}
	}

	private static boolean isValidPosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < rows &&
				nextColumn >= 0 && nextColumn < columns;
	}

	private static int[] findUpper() {
		for (int r = 0; r < rows; r++) {
			if (board[r][0] == -1) {
				return new int[]{r, 0};
			}
		}
		return null;
	}
}
