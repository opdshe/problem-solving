package 기출.카카오2021인턴;

import java.util.Arrays;
import java.util.List;

public class 거리두기확인하기 {
	private static boolean isOkay = true;
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);
	private static int[] answer = new int[]{1,1,1,1,1};

	public static void main(String[] args) {
		solution(new String[][]{
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
	}

	public static int[] solution(String[][] places) {
		boolean[][][] visited = new boolean[5][5][5];
		for (int room = 0; room < 5; room++) {
			for (int row = 0; row < 5; row++) {
				for (int column = 0; column < 5; column++) {
					if (!visited[room][row][column] && places[room][row].charAt(column) == 'P') {
						dfs(places, visited, room, row, column, 0);
					}
				}
			}
		}
		return answer;
	}


	private static void dfs(String[][] places, boolean[][][] visited, int room, int row, int column, int count) {
		if (count > 2) {
			return;
		}
		if ((count == 1 || count == 2) && places[room][row].charAt(column) == 'P') {
			answer[room] = 0;
			return;
		}
		visited[room][row][column] = true;
		for (int[] direction : directions) {
			int nextRow = row + direction[0];
			int nextColumn = column + direction[1];
			if (isValidPosition(nextRow, nextColumn) && !visited[room][nextRow][nextColumn] &&
					places[room][nextRow].charAt(nextColumn) != 'X') {
				visited[room][nextRow][nextColumn] = true;
				dfs(places, visited, room, nextRow, nextColumn, count + 1);
				visited[room][nextRow][nextColumn] = false;
			}
		}
	}

	private static boolean isValidPosition(int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < 5 &&
				nextColumn >= 0 && nextColumn < 5;
	}
}
