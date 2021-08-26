package 재귀;

import java.util.Scanner;

public class 색종이만들기 {
	private static Scanner scanner = new Scanner(System.in);
	private static int N;
	private static int[] answer = new int[2];

	public static void main(String[] args) {
		N = scanner.nextInt();
		int[][] map = new int[N][N];
		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		solution(map, N, 0, 0);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
	}

	private static void solution(int[][] map, int size, int rowStart, int columnStart) {
		if (isSquare(map, size, rowStart, columnStart)) {
			answer[map[rowStart][columnStart]]++;
			return;
		}
		solution(map, size / 2, rowStart, columnStart);
		solution(map, size / 2, rowStart, columnStart + size / 2);
		solution(map, size / 2, rowStart + size / 2, columnStart);
		solution(map, size / 2, rowStart + size / 2, columnStart + size / 2);
	}

	private static boolean isSquare(int[][] map, int size, int rowStart, int columnStart) {
		int color = map[rowStart][columnStart];
		for (int row = rowStart; row < rowStart + size; row++) {
			for (int column = columnStart; column < columnStart + size; column++) {
				if (map[row][column] != color) {
					return false;
				}
			}
		}
		return true;
	}
}
