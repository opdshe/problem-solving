package 그래프.최단경로.다익스트라;

import java.util.*;

public class 미로만들기 {
	private static Scanner scanner = new Scanner(System.in);
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		scanner.nextLine();
		int[][] board = new int[size][size];
		for (int row = 0; row < size; row++) {
			board[row] = Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::valueOf)
					.toArray();
		}
		System.out.println(getMinDistance(board, size));
	}

	private static int getMinDistance(int[][] board, int size) {
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.change));
		int[][] distance = new int[size][size];
		for (int row = 0; row < size; row++) {
			Arrays.fill(distance[row], Integer.MAX_VALUE);
		}
		queue.add(new Node(0, 0, board[0][0] == 1 ? 0 : 1));
		distance[0][0] = board[0][0] == 1 ? 0 : 1;
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.change > distance[current.row][current.column]) {
				break;
			}
			for (int[] direction : directions) {
				int nextRow = current.row + direction[0];
				int nextColumn = current.column + direction[1];
				if (isValidPosition(nextRow, nextColumn, size)) {
					int next = board[nextRow][nextColumn];
					if (next == 1) {
						int change = current.change;
						if (distance[nextRow][nextColumn] > change) {
							distance[nextRow][nextColumn] = change;
							queue.add(new Node(nextRow, nextColumn, change));
						}
					} else if (next == 0) {
						int change = current.change + 1;
						if (distance[nextRow][nextColumn] > change) {
							distance[nextRow][nextColumn] = change;
							queue.add(new Node(nextRow, nextColumn, change));
						}
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
		private int change;

		public Node(int row, int column, int change) {
			this.row = row;
			this.column = column;
			this.change = change;
		}
	}
}
