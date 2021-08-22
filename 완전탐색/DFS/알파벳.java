package 완전탐색.DFS;

import java.util.*;

public class 알파벳 {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Set<Character> alphabets = new HashSet<>();
	private static final List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	private static int rows;
	private static int columns;
	private static int answer = 0;

	public static void main(String[] args) {
		String[] input = scanner.nextLine().split(" ");
		rows = Integer.parseInt(input[0]);
		columns = Integer.parseInt(input[1]);
		char[][] board = new char[rows][columns];
		for (int row = 0; row < Integer.parseInt(input[0]); row++) {
			board[row] = scanner.nextLine().toCharArray();
		}
		boolean[][] visited = new boolean[rows][columns];
		dfs(board, visited, 0, 0);
		System.out.println(answer);
	}

	private static void dfs(char[][] board, boolean[][] visited, int row, int column) {
		visited[row][column] = true;
		alphabets.add(board[row][column]);
		answer = Math.max(answer, alphabets.size());

		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isValid(nextRow, nextColumn) && !visited[nextRow][nextColumn] &&
					!alphabets.contains(board[nextRow][nextColumn])) {
				dfs(board, visited, nextRow, nextColumn);
			}
		}
		visited[row][column] = false;
		alphabets.remove(board[row][column]);
	}

	private static boolean isValid(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < rows &&
				nextColumn >= 0 && nextColumn < columns;
	}
}
