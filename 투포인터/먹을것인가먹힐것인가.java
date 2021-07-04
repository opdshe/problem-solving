package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 먹을것인가먹힐것인가 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testCase = scanner.nextInt();
		for (int test = 0; test < testCase; test++) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			for (int i = 0; i < N; i++) {
				A[i] = scanner.nextInt();
			}
			for (int i = 0; i < M; i++) {
				B[i] = scanner.nextInt();
			}
			Arrays.sort(A);
			Arrays.sort(B);
			solution(N, M, A, B);
		}
	}

	private static void solution(int N, int M, int[] A, int[] B) {
		int pointOfA = 0;
		int pointOfB = 0;
		int count = 0;
		while (true) {
			if (A[pointOfA] > B[pointOfB]) {
				count += N - pointOfA;
				pointOfB++;
				if (pointOfB == M) {
					break;
				}
			} else {
				pointOfA++;
				if (pointOfA == N) {
					break;
				}
			}
		}
		System.out.println(count);
	}
}
