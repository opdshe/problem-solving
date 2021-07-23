package 그래프.최단경로.플루이드와샬;

import java.util.Scanner;

public class 여행가자 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int routeSize = scanner.nextInt();
		int[] route = new int[routeSize];
		int[][] map = new int[size + 1][size + 1];
		for (int row = 1; row <= size; row++) {
			for (int column = 1; column <= size; column++) {
				map[row][column] = scanner.nextInt();
			}
		}
		for (int i = 0; i < routeSize; i++) {
			route[i] = scanner.nextInt();
		}
		floyd(map, size);
		boolean isOkay = true;
		for (int source = 0; source < routeSize - 1; source++) {
			if(route[source] == route[source+1]){
				continue;
			}
			if (map[route[source]][route[source + 1]] == 0) {
				isOkay = false;
				break;
			}
		}
		System.out.println(isOkay ? "YES" : "NO");
	}

	private static void floyd(int[][] map, int size) {
		for (int mid = 1; mid <= size; mid++) {
			for (int row = 1; row <= size; row++) {
				for (int column = 1; column <= size; column++) {
					if (mid == row) {
						continue;
					}
					if (map[row][mid] == 1 && map[mid][column] == 1) {
						map[row][column] = 1;
					}
				}
			}
		}
	}
}
