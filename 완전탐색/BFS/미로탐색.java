package 완전탐색.BFS;

import java.util.*;

public class 미로탐색 {
	private static final Scanner scanner = new Scanner(System.in);
	private static final List<int[]> directions = Arrays.asList(
			new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1});
	private static int countOfRow;
	private static int countOfColumn;
	private static int[][] board;
	private static int[][] visited;


	public static void main(String[] args) {
		init();
		bfs();
	}

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{0, 0});
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int[] direction : directions) {
				int nextRow = current[0] + direction[0];
				int nextColumn = current[1] + direction[1];
				if (isValidPosition(nextRow, nextColumn) && visited[nextRow][nextColumn] == 0 &&
						board[nextRow][nextColumn] == 1) {
					queue.add(new int[]{nextRow, nextColumn});
					visited[nextRow][nextColumn] = visited[current[0]][current[1]] + 1;
				}
			}
		}
		System.out.println(visited[countOfRow - 1][countOfColumn - 1]);
	}

	private static boolean isValidPosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < countOfRow &&
				nextColumn >= 0 && nextColumn < countOfColumn;
	}

	private static void init() {
		countOfRow = scanner.nextInt();
		countOfColumn = scanner.nextInt();
		board = new int[countOfRow][countOfRow];
		visited = new int[countOfRow][countOfColumn];
		visited[0][0] = 1;
		scanner.nextLine();
		for (int row = 0; row < countOfRow; row++) {
			board[row] = Arrays.stream(scanner.nextLine().split(""))
					.mapToInt(Integer::valueOf)
					.toArray();
		}
	}
}
