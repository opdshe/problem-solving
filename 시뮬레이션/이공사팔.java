package 시뮬레이션;

import java.util.*;

public class 이공사팔 {
	private static final Scanner scanner = new Scanner(System.in);
	private static int answer = 0;

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int[][] board = new int[size][size];
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				board[r][c] = scanner.nextInt();
			}
		}
		dfs(board, size, 0);
		System.out.println(answer);
	}

	private static void dfs(int[][] board, int size, int count) {
		if (count == 5) {
			answer = Math.max(answer, getMaxNumber(board, size));
			return;
		}
		for (int direction = 1; direction <= 4; direction++) {
			int[][] newBoard = deepCopy(board);
			move(newBoard, size, direction);
			dfs(newBoard, size, count + 1);
		}
	}

	private static int getMaxNumber(int[][] board, int size) {
		int max = 0;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				max = Math.max(max, board[r][c]);
			}
		}
		return max;
	}

	private static void move(int[][] board, int size, int direction) {
		//1: 위 , 2: 오, 3: 아래, 4: 왼
		Deque<Block> queue = new ArrayDeque<>();
		if (direction == 1) {
			for (int column = 0; column < size; column++) {
				for (int row = 0; row < size; row++) {
					int current = board[row][column];
					board[row][column] = 0;
					addQueue(queue, current);
				}
				int r = 0;
				while (!queue.isEmpty()) {
					int num = queue.pollFirst().num;
					board[r][column] = num;
					r++;
				}
			}
		} else if (direction == 3) {
			for (int column = 0; column < size; column++) {
				for (int row = size - 1; row >= 0; row--) {
					int current = board[row][column];
					board[row][column] = 0;
					addQueue(queue, current);
				}
				int r = size - 1;
				while (!queue.isEmpty()) {
					int num = queue.pollFirst().num;
					board[r][column] = num;
					r--;
				}
			}
		} else if (direction == 2) {
			for (int row = 0; row < size; row++) {
				for (int column = size - 1; column >= 0; column--) {
					int current = board[row][column];
					board[row][column] = 0;
					addQueue(queue, current);
				}
				int c = size - 1;
				while (!queue.isEmpty()) {
					int num = queue.pollFirst().num;
					board[row][c] = num;
					c--;
				}
			}
		} else {
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					int current = board[row][column];
					board[row][column] = 0;
					addQueue(queue, current);
				}
				int c = 0;
				while (!queue.isEmpty()) {
					int num = queue.pollFirst().num;
					board[row][c] = num;
					c++;
				}
			}
		}
	}

	private static void addQueue(Deque<Block> queue, int current) {
		if (current == 0) {
			return;
		}
		if (queue.isEmpty()) {
			queue.add(new Block(current, true));
		} else {
			if (queue.getLast().num == current) {
				if (queue.getLast().isOkay) {
					queue.pollLast();
					queue.addLast(new Block(current * 2, false));
				} else {
					queue.addLast(new Block(current, true));
				}
			} else {
				queue.addLast(new Block(current, true));
			}
		}
	}

	private static int[][] deepCopy(int[][] origin) {
		if (origin == null) return null;
		int[][] result = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
		}
		return result;
	}

	private static class Block {
		private int num;
		private boolean isOkay;

		public Block(int num, boolean isOkay) {
			this.num = num;
			this.isOkay = isOkay;
		}
	}
}
