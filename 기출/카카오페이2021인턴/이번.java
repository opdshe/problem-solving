package 기출.카카오페이2021인턴;

import java.util.HashMap;
import java.util.Map;

public class 이번 {
	private static Map<Integer, int[]> directions = new HashMap<>();

	static {
		directions.put(1, new int[]{1, 0});
		directions.put(2, new int[]{-1, 0});
		directions.put(3, new int[]{0, 1});
		directions.put(4, new int[]{0, -1});
	}

	public static void main(String[] args) {
		solution(4, 3, new int[][]{
				{1, 1, 2, 4, 3},
				{3, 2, 1, 2, 3,},
				{4, 1, 1, 4, 3},
				{2, 2, 1, 3, 3}});
	}

	public static int[] solution(int rows, int columns, int[][] swipes) {
		int[][] board = init(rows, columns);
		for (int[] swipe : swipes) {
			doSwipe(swipe, board, rows, columns);
		}
		return null;
	}

	private static void doSwipe(int[] swipe, int[][] board, int rows, int columns) {
		int[][] copy = deepCopy(board);
		int[] direction = directions.get(swipe[0]);
		for (int row = swipe[1]; row <= swipe[3]; row++) {
			for (int column = swipe[2]; column <= swipe[4]; column++) {
				int nextRow = row + direction[0];
				int nextColumn = column + direction[1];
				if (isValidPosition(rows, columns, nextRow, nextColumn)) {
					board[nextRow][nextColumn] = copy[row][column];
				}
			}
		}
		if (swipe[0] == 1) {
			for (int column = 0; column <= columns; column++) {
				board[swipe[1]][column] = copy[swipe[3]][column];
			}
		} else if (swipe[0] == 2) {
			for (int column = 0; column <= columns; column++) {
				board[swipe[3]][column] = copy[swipe[1]][column];
			}
		} else if (swipe[0] == 3) {
			for (int row = 0; row < rows; row++) {
				board[row][swipe[2]] = copy[row][swipe[4]];
			}
		} else if (swipe[0] == 4) {
			for (int row = 0; row < rows; row++) {
				board[row][swipe[4]] = copy[row][swipe[2]];
			}
		}
		System.out.println("ok");
	}

	private static boolean isValidPosition(int rows, int columns, int nextRow, int nextColumn) {
		return nextRow >= 1 && nextRow <= rows &&
				nextColumn >= 1 && nextColumn <= columns;
	}

	private static int[][] deepCopy(int[][] origin) {
		if (origin == null) return null;
		int[][] result = new int[origin.length][origin[0].length];
		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
		}
		return result;
	}

	private static int[][] init(int rows, int columns) {
		int[][] board = new int[rows + 1][columns + 1];
		for (int row = 1; row <= rows; row++) {
			for (int column = 1; column <= columns; column++) {
				board[row][column] = ((row - 1) * columns + column);
			}
		}
		return board;
	}
}
