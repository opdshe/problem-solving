package 완전탐색.DFS;

import java.util.Scanner;

public class 친구 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		char[][] board = new char[size][size];
		scanner.nextLine();
		for (int r = 0; r < size; r++) {
			char[] chars = scanner.nextLine().toCharArray();
			board[r] = chars;
		}
		int answer = 0;
		for (int target = 0; target < size; target++) {
			int count = 0;
			for (int compare = 0; compare < size; compare++) {
				if (target == compare) {
					continue;
				}
				if (board[target][compare] == 'Y') {
					count++;
				} else {
					if(hasCommonFriend(board, target, compare, size)){
						count++;
					}
				}
				answer = Math.max(answer, count);
			}
		}
		System.out.println(answer);
	}

	private static boolean hasCommonFriend(char[][] board, int pivot, int compare, int size) {
		for (int target = 0; target < size; target++) {
			if (board[pivot][target] == 'Y' && board[compare][target] == 'Y') {
				return true;
			}
		}
		return false;
	}
}
