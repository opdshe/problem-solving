package 그래프.최단경로.플루이드와샬;

import java.util.Scanner;

public class 키순서 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int students = scanner.nextInt();
		int compares = scanner.nextInt();
		int[][] board = new int[students + 1][students + 1];
		for (int i = 0; i < compares; i++) {
			int smaller = scanner.nextInt();
			int taller = scanner.nextInt();
			board[smaller][taller] = 1;
		}
		floyd(board, students);
		int answer = 0;
		for (int student = 1; student <= students; student++) {
			int smaller = 0;
			int taller = 0;

			for (int compare = 1; compare <= students; compare++) {
				if (board[student][compare] == 1) {
					smaller++;
				} else if (board[compare][student] == 1) {
					taller++;
				}
			}
			if (smaller + taller == students-1){
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static void floyd(int[][] board, int students) {
		for (int mid = 1; mid <= students; mid++) {
			for (int row = 1; row <= students; row++) {
				for (int column = 1; column <= students; column++) {
					if (mid == row) {
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
