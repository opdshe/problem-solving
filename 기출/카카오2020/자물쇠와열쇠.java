package 기출.카카오2020;

public class 자물쇠와열쇠 {
	private static int[][] board;
	private static boolean isFull = false;

	public static void main(String[] args) {
		solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
	}

	public static boolean solution(int[][] key, int[][] lock) {
		board = new int[key.length * 2 + lock.length][key.length * 2 + lock.length];
		for (int r = 0; r < lock.length; r++) {
			for (int c = 0; c < lock.length; c++) {
				board[key.length + r][key.length + c] = lock[r][c];
			}
		}
		search(key, lock);
		return isFull;
	}

	private static void search(int[][] key, int[][] lock) {
		int count = 0;
		do {
			//탐색 로직
			if (isFull) {
				break;
			}
			for (int r = 1; r <= key.length + lock.length - 1; r++) {
				for (int c = 1; c <= key.length + lock.length - 1; c++) {
					check(r, c, key, lock);
				}
			}
			key = rotate(key);
			count++;
		} while (count < 4);
		System.out.println(isFull);
	}

	private static void check(int rowStart, int columnStart, int[][] key, int[][] lock) {
		int[][] copyBoard = deepCopy(board);
		for (int r = 0; r < key.length; r++) {
			for (int c = 0; c < key.length; c++) {
				if (key[r][c] == 1) {
					if (copyBoard[r + rowStart][c + columnStart] == 1) {
						return;
					} else {
						copyBoard[r + rowStart][c + columnStart] = 1;
					}
				}
			}
		}
		if (isFull(copyBoard, key.length, key.length, lock.length)) {
			isFull = true;
		}
	}

	private static boolean isFull(int[][] copyBoard, int rowStart, int columnStart, int size) {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (copyBoard[r + rowStart][c + columnStart] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static int[][] rotate(int[][] origin) {
		int n = origin.length;
		int m = origin[0].length;
		int[][] rotate = new int[m][n];

		for (int i = 0; i < rotate.length; i++) {
			for (int j = 0; j < rotate[i].length; j++) {
				rotate[i][j] = origin[n - 1 - j][i];
			}
		}
		return rotate;
	}

	private static int[][] deepCopy(int[][] origin) {
		if (origin == null) return null;
		int[][] result = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
		}
		return result;
	}
}
