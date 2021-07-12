package 기출.카카오2021;

import java.util.Arrays;

public class 합승택시요금 {
	public static void main(String[] args) {
		solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		int[][] map = initMap(fares, n);
		floyd(map, n);
		for (int mid = 1; mid <= n; mid++) {
			if(map[s][mid] == Integer.MAX_VALUE || map[mid][a] == Integer.MAX_VALUE || map[mid][b] == Integer.MAX_VALUE){
				continue;
			}
			int sum = map[s][mid] + map[mid][a] + map[mid][b];
			answer = Math.min(answer, sum);
		}
		System.out.println(answer);
		return answer;
	}

	private static void floyd(int[][] map, int n) {
		for (int mid = 1; mid <= n; mid++) {
			for (int row = 1; row <= n; row++) {
				for (int column = 1; column <= n; column++) {
					if (map[row][mid] != Integer.MAX_VALUE && map[mid][column] != Integer.MAX_VALUE) {
						int cost = map[row][mid] + map[mid][column];
						if (map[row][column] > cost) {
							map[row][column] = cost;
						}
					}
				}
			}
		}
	}

	private static int[][] initMap(int[][] fares, int n) {
		int[][] map = new int[n + 1][n + 1];
		for (int row = 1; row <= n; row++) {
			for (int column = 1; column <= n; column++) {
				if (row == column) {
					map[row][column] = 0;
				} else {
					map[row][column] = Integer.MAX_VALUE;
				}
			}
		}
		for (int[] fare : fares) {
			int start = fare[0];
			int end = fare[1];
			int cost = fare[2];
			map[start][end] = cost;
			map[end][start] = cost;
		}
		return map;
	}
}
