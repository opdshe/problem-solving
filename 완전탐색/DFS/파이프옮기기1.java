package 완전탐색.DFS;

import java.util.Scanner;

public class 파이프옮기기1 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int[][] board = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				board[row][column] = scanner.nextInt();
			}
		}
		int answer = dfs(board, size, 0, 1, 1);
		System.out.println(answer);
	}

	private static int dfs(int[][] board, int size, int row, int column, int direction) {
		//direction 1= 가로, 2=세로, 3=대각
		if (row == size - 1 && column == size - 1) {
			return 1;
		}
		int count = 0;
		boolean isOkayToGoRight = column + 1 < size && board[row][column + 1] == 0;
		boolean isOkayToGoDown = row + 1 < size && board[row + 1][column] == 0;
		if (isOkayToGoRight && direction != 2) {
			count += dfs(board, size, row, column + 1, 1);
		}
		if (isOkayToGoDown && direction != 1) {
			count += dfs(board, size,  row + 1, column, 2);
		}
		if (isOkayToGoDown && isOkayToGoRight && row + 1 < size && column + 1 < size && board[row + 1][column + 1] == 0) {
			count += dfs(board, size, row + 1, column + 1, 3);
		}
		return count;
	}
}
