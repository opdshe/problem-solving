package 다이나믹프로그래밍;

public class 등굣길 {
	public static void main(String[] args) {
		solution(4, 3, new int[][]{{2, 2}});
	}

	public static int solution(int m, int n, int[][] puddles) {
		int mod = 1000000007;
		long[][] board = new long[m + 1][n + 1];
		board[1][1] = 1;
		for (int[] puddle : puddles) {
			board[puddle[0]][puddle[1]] = -1;
		}
		for (int row = 1; row <= m; row++) {
			for (int column = 1; column <= n; column++) {
				if (board[row][column] == -1) {
					continue;
				}
				if (board[row - 1][column] != -1) {
					board[row][column] = (board[row][column] + board[row - 1][column]) % mod;
				}
				if (board[row][column - 1] != -1) {
					board[row][column] = (board[row][column] + board[row][column - 1]) % mod;
				}
			}
		}
		return (int)((board[m][n]) % mod);
	}
}
