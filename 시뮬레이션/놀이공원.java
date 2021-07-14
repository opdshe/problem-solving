package 시뮬레이션;

import java.io.*;
import java.lang.*;
import java.util.*;


public class 놀이공원 {
	public static final Scanner scanner = new Scanner(System.in);

	public static void testCase(int caseIndex) {
		int N = scanner.nextInt();  // 지도의 크기
		int K = scanner.nextInt();  // 놀이공원의 크기

		int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부
		for (int r = 0; r < N; r += 1) {
			for (int c = 0; c < N; c += 1) {
				wastes[r][c] = scanner.nextInt();
			}
		}
		int answer = Integer.MAX_VALUE;

		for(int row = 0; row + K <= N; row++){
			for(int column = 0; column+K <= N; column++){
				answer = Math.min(answer, getCountOfWaste(wastes, N, K, row, column));
			}
		}

		System.out.println(answer);
	}

	private static int getCountOfWaste(int[][] wastes, int N, int K, int row , int column){
		int count = 0;
		for(int r = row; r < row + K; r++){
			for(int c= column; c < column + K; c++){
				if(wastes[r][c] == 1){
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		int caseSize = scanner.nextInt();

		for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
			testCase(caseIndex);
		}
	}
}
