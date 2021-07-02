package 완전탐색.DFS;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 적록색약 {
	private static final Scanner sc = new Scanner(System.in);
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		int size = sc.nextInt();
		char[][] board = new char[size][size];
		sc.nextLine();
		for (int row = 0; row < size; row++) {
			board[row] = sc.nextLine().toCharArray();
		}
		System.out.println(getNormalResult(board, size) + " " + getUnNormalResult(board, size));
	}

	private static int getNormalResult(char[][] board, int size) {
		boolean[][] visited = new boolean[size][size];
		int region = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (!visited[row][column]) {
					visited[row][column] = true;
					normalDfs(board, visited, size, new int[]{row, column});
					region++;
				}
			}
		}
		return region;
	}

	private static void normalDfs(char[][] board, boolean[][] visited, int size, int[] position) {
		char currentChar = board[position[0]][position[1]];
		for (int[] direction : directions) {
			int nextRow = position[0] + direction[0];
			int nextColumn = position[1] + direction[1];
			if (isValidPosition(size, nextRow, nextColumn) && !visited[nextRow][nextColumn] &&
					board[nextRow][nextColumn] == currentChar) {
				visited[nextRow][nextColumn] = true;
				normalDfs(board, visited, size, new int[]{nextRow, nextColumn});
			}
		}
	}

	private static int getUnNormalResult(char[][] board, int size) {
		boolean[][] visited = new boolean[size][size];
		int region = 0;
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (!visited[row][column]) {
					visited[row][column] = true;
					unNormalDfs(board, visited, size, new int[]{row, column});
					region++;
				}
			}
		}
		return region;
	}

	private static void unNormalDfs(char[][] board, boolean[][] visited, int size, int[] position) {
		char currentChar = board[position[0]][position[1]];
		for (int[] direction : directions) {
			int nextRow = position[0] + direction[0];
			int nextColumn = position[1] + direction[1];
			if (isValidPosition(size, nextRow, nextColumn) && !visited[nextRow][nextColumn]) {
				if (currentChar == 'R' || currentChar == 'G') {
					if (board[nextRow][nextColumn] == 'R' || board[nextRow][nextColumn] == 'G') {
						visited[nextRow][nextColumn] = true;
						unNormalDfs(board, visited, size, new int[]{nextRow, nextColumn});
					}
				} else {
					if(board[nextRow][nextColumn] == currentChar){
						visited[nextRow][nextColumn] = true;
						unNormalDfs(board, visited, size, new int[]{nextRow, nextColumn});
					}
				}
			}
		}
	}

	private static boolean isValidPosition(int size, int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
