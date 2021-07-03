package 그래프.최단경로.플루이드와샬;

import java.util.Scanner;

public class 경로찾기 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int[][] board = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				board[row][column] = scanner.nextInt();
			}
		}
		floyd(board, size);
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				System.out.print(board[row][column] + " ");
			}
			System.out.println();
		}
	}

	private static void floyd(int[][] board, int size) {
		for (int mid = 0; mid < size; mid++) {
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					if(row == mid){
						continue;
					}
					if (board[row][mid] == 1 && board[mid][column] == 1) {
						board[row][column] = 1;
					}
				}
			}
		}
	}
}
