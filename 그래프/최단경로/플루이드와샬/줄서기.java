package 그래프.최단경로.플루이드와샬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 줄서기 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] info = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		int[][] board = new int[info[0] + 1][info[0] + 1];
		for (int i = 0; i < info[1]; i++) {
			int[] order = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
			board[order[0]][order[1]] = 1;
		}
		floyd(board, info[0]);
		for (int person = 1; person <= info[0]; person++) {
			int smaller = 0;
			int taller = 0;
			for (int compare = 1; compare <= info[0]; compare++) {
				if (board[person][compare] == 0) {
					smaller++;
				} else if(board[compare][person] == 0){
					taller++;
				}
			}
			System.out.println(taller + " " + smaller);
		}
	}

	private static void floyd(int[][] board, int people) {
		for (int mid = 1; mid <= people; mid++) {
			for (int row = 1; row <= people; row++) {
				for (int column = 1; column <= people; column++) {
					if (mid == row) {
						continue;
					}
					int cost = board[row][column];
					if (cost == 0 && board[row][mid] == 1 && board[mid][cost] == 1) {
						board[row][column] = 1;
					}
				}
			}
		}
	}
}
