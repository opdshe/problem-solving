package 시뮬레이션;

import java.util.*;

public class 치즈 {
	private static final Scanner scanner = new Scanner(System.in);
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	private static int rows;
	private static int columns;
	private static int remain;

	public static void main(String[] args) {
		rows = scanner.nextInt();
		columns = scanner.nextInt();
		int[][] board = new int[rows][columns];
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				board[row][column] = scanner.nextInt();
				if (board[row][column] == 1) {
					remain++;
				}
			}
		}
		melt(board);
	}

	private static void melt(int[][] board) {
		int time = 0;
		int temp = 0;
		while (remain > 0) {
			temp = remain;
			List<int[]> removeCandidates = getRemoveCandidates(board);
			remain -= removeCandidates.size();
			for (int[] coordinate : removeCandidates) {
				board[coordinate[0]][coordinate[1]] = 0;
			}
			time++;
		}
		System.out.println(time);
		System.out.println(temp);
	}

	private static List<int[]> getRemoveCandidates(int[][] board) {
		List<int[]> candidates = new ArrayList<>();
		boolean[][] visited = new boolean[rows][columns];
		addIfMetWithAir(board, candidates, visited, 0, 0);
		return candidates;
	}

	private static void addIfMetWithAir(int[][] board, List<int[]> candidates, boolean[][] visited, int row, int column) {
		visited[row][column] = true;
		addEdgeCheese(board, candidates, visited, row, column);
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isValidPosition(nextRow, nextColumn) && !visited[nextRow][nextColumn]
					&& board[nextRow][nextColumn] == 0) {
				addIfMetWithAir(board, candidates, visited, nextRow, nextColumn);
			}
		}
	}

	private static void addEdgeCheese(int[][] board, List<int[]> candidates, boolean[][] visited, int row, int column) {
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isValidPosition(nextRow, nextColumn) && board[nextRow][nextColumn] == 1 && !visited[nextRow][nextColumn]) {
				visited[nextRow][nextColumn] = true;
				candidates.add(new int[]{nextRow, nextColumn});
			}
		}
	}


	private static boolean isValidPosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < rows &&
				nextColumn >= 0 && nextColumn < columns;
	}
}
