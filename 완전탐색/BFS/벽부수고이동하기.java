package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 벽부수고이동하기 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		int[][] map = new int[input[0]][input[1]];
		for (int row = 0; row < input[0]; row++) {
			map[row] = Arrays.stream(br.readLine().split(""))
					.mapToInt(Integer::valueOf)
					.toArray();
		}
		int answer = getMinDistance(map, input[0], input[1]);
		System.out.println(answer);
	}

	private static int getMinDistance(int[][] map, int rows, int columns) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, 1, 0));
		boolean[][][] visited = new boolean[rows][columns][2];
		visited[0][0][0] = true;


		int answer = -1;
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			if (current.row == rows - 1 && current.column == columns - 1) {
				answer = current.cost;
				break;
			}
			for (int[] direction : directions) {
				int nextRow = current.row + direction[0];
				int nextColumn = current.column + direction[1];
				if (isValidPosition(rows, columns, nextRow, nextColumn)) {
					if (map[nextRow][nextColumn] == 0) {
						if (!visited[nextRow][nextColumn][current.hasBreak]) {
							visited[nextRow][nextColumn][current.hasBreak] = true;
							queue.add(new Node(nextRow, nextColumn, current.cost + 1, current.hasBreak));
						}
					} else if (map[nextRow][nextColumn] == 1) {
						if (current.hasBreak == 0 && !visited[nextRow][nextColumn][1]) {
							visited[nextRow][nextColumn][1] = true;
							queue.add(new Node(nextRow, nextColumn, current.cost + 1, 1));
						}
					}
				}
			}
		}
		return answer;
	}

	private static boolean isValidPosition(int rows, int columns, int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < rows &&
				nextColumn >= 0 && nextColumn < columns;
	}

	private static class Node {
		private int row;
		private int column;
		private int cost;
		private int hasBreak;

		public Node(int row, int column, int cost, int hasBreak) {
			this.row = row;
			this.column = column;
			this.cost = cost;
			this.hasBreak = hasBreak;
		}
	}
}
