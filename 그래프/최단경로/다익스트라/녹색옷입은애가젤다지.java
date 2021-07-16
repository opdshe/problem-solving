package 그래프.최단경로.다익스트라;

import java.util.*;

public class 녹색옷입은애가젤다지 {
	private static final Scanner scanner = new Scanner(System.in);
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		int testCase = 1;
		while (true) {
			int size = scanner.nextInt();
			if (size == 0) {
				break;
			}
			int[][] board = new int[size][size];
			for (int row = 0; row < size; row++) {
				for (int column = 0; column < size; column++) {
					board[row][column] = scanner.nextInt();
				}
			}
			System.out.println("Problem " + testCase + ": " + getMinDistance(board,size));
			testCase++;
		}
	}


	private static int getMinDistance(int[][] board, int size) {
		int[][] distance = new int[size][size];
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
		for (int row = 0; row < size; row++) {
			Arrays.fill(distance[row], Integer.MAX_VALUE);
		}
		queue.add(new Node(0, 0, board[0][0]));
		distance[0][0] = board[0][0];
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.cost > distance[current.row][current.column]) {
				break;
			}
			for (int[] direction : directions) {
				int nextRow = current.row + direction[0];
				int nextColumn = current.column + direction[1];
				if (isValidPosition(nextRow, nextColumn, size)) {
					int cost = current.cost + board[nextRow][nextColumn];
					if (distance[nextRow][nextColumn] > cost) {
						queue.add(new Node(nextRow, nextColumn, cost));
						distance[nextRow][nextColumn] = cost;
					}
				}
			}
		}
		return distance[size - 1][size - 1];
	}

	private static boolean isValidPosition(int nextRow, int nextColumn, int size) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}


	private static class Node {
		private int row;
		private int column;
		private int cost;

		public Node(int row, int column, int cost) {
			this.row = row;
			this.column = column;
			this.cost = cost;
		}
	}

}
