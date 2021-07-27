package 시뮬레이션;

import java.util.*;

public class 구슬탈출 {
	private static Scanner scanner = new Scanner(System.in);
	private static int rows;
	private static int columns;
	private static Map<Integer, int[]> directions = new HashMap<>();
	private static boolean isOkay = false;

	static {
		directions.put(1, new int[]{-1, 0});
		directions.put(2, new int[]{1, 0});
		directions.put(3, new int[]{0, -1});
		directions.put(4, new int[]{0, 1});
	}

	public static void main(String[] args) {
		rows = scanner.nextInt();
		columns = scanner.nextInt();
		char[][] map = new char[rows][columns];
		scanner.nextLine();
		for (int row = 0; row < rows; row++) {
			map[row] = scanner.nextLine().toCharArray();
		}
		dfs(map, 0);
		System.out.println(isOkay ? 1 : 0);
	}

	private static void dfs(char[][] map, int count) {
		if(isOkay){
			return;
		}
		if (count == 10) {
			return;
		}
		int[] red = findPosition(map, true);
		int[] blue = findPosition(map, false);
		if (red == null || blue == null) {
			if (red == null && blue != null) {
				isOkay = true;
			}
			return;
		}
		//상
		char[][] copy = deepCopy(map);
		move(copy, 1);
		dfs(copy, count + 1);
		//하
		copy = deepCopy(map);
		move(copy, 2);
		dfs(copy, count + 1);
		//좌
		copy = deepCopy(map);
		move(copy, 3);
		dfs(copy, count + 1);
		//우
		copy = deepCopy(map);
		move(copy, 4);
		dfs(copy, count + 1);
	}

	private static void move(char[][] map, int direction) {
		int[] red = findPosition(map, true);
		int[] blue = findPosition(map, false);
		int[] offset = directions.get(direction);
		//상
		if (direction == 1 && red[1] == blue[1]) {
			if (red[0] < blue[0]) {
				moveByDirection(map, red, offset);
				moveByDirection(map, blue, offset);
			} else {
				moveByDirection(map, blue, offset);
				moveByDirection(map, red, offset);
			}
		} else if (direction == 2 && red[1] == blue[1]) {
			if (red[0] < blue[0]) {
				moveByDirection(map, blue, offset);
				moveByDirection(map, red, offset);
			} else {
				moveByDirection(map, red, offset);
				moveByDirection(map, blue, offset);
			}
		} else if (direction == 3 && red[0] == blue[0]) {
			if (red[1] < blue[1]) {
				moveByDirection(map, red, offset);
				moveByDirection(map, blue, offset);
			} else {
				moveByDirection(map, blue, offset);
				moveByDirection(map, red, offset);
			}
		} else if (direction == 4 && red[0] == blue[0]) {
			if (red[1] < blue[1]) {
				moveByDirection(map, blue, offset);
				moveByDirection(map, red, offset);
			} else {
				moveByDirection(map, red, offset);
				moveByDirection(map, blue, offset);
			}
		} else {
			moveByDirection(map, red, offset);
			moveByDirection(map, blue, offset);
		}
	}

	private static void moveByDirection(char[][] map, int[] targetPosition, int[] offset) {
		int[] current = targetPosition;
		char ball = map[targetPosition[0]][targetPosition[1]];
		while (map[current[0] + offset[0]][current[1] + offset[1]] == '.' || map[current[0] + offset[0]][current[1] + offset[1]] == 'O') {
			if (map[current[0] + offset[0]][current[1] + offset[1]] == 'O') {
				map[current[0]][current[1]] = '.';
				break;
			}
			map[current[0] + offset[0]][current[1] + offset[1]] = ball;
			map[current[0]][current[1]] = '.';
			current = new int[]{current[0] + offset[0], current[1] + offset[1]};
		}
	}

	private static int[] findPosition(char[][] map, boolean isRed) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if (map[r][c] == 'R' && isRed) {
					return new int[]{r, c};
				} else if (map[r][c] == 'B' && !isRed) {
					return new int[]{r, c};
				}
			}
		}
		return null;
	}

	private static char[][] deepCopy(char[][] origin) {
		if (origin == null) return null;
		char[][] result = new char[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
		}
		return result;
	}
}
