package 브루트포스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 차트 {
	private static final Scanner scanner = new Scanner(System.in);
	private static boolean[] visited;
	private static int[] orders;
	private static int answer;

	public static void main(String[] args) {
		int size = scanner.nextInt();
		int[] percents = new int[size];
		for (int idx = 0; idx < size; idx++) {
			percents[idx] = scanner.nextInt();
		}
		visited = new boolean[size];
		orders = new int[size];
		permutation(percents, size, 0);
		System.out.println(answer);
	}

	private static void permutation(int[] percents, int size, int level) {
		if (size == level) {
			int[] newArray = new int[size];
			for (int idx = 0; idx < size; idx++) {
				newArray[idx] = percents[orders[idx]];
			}
			answer = Math.max(answer, getHalfLine(newArray, size));
			return;
		}
		for (int idx = 0; idx < size; idx++) {
			if (!visited[idx]) {
				orders[level] = idx;
				visited[idx] = true;
				permutation(percents, size, level + 1);
				visited[idx] = false;
			}
		}
	}

	private static int getHalfLine(int[] array, int size) {
		int left = 0;
		int right = 0;
		int sum = 0;
		int count = 0;
		List<int[]> halfLinePoints = new ArrayList<>();
		while (true) {
			if (sum >= 50) {
				if (sum == 50) {
					boolean isOkay = true;
					for (int[] halfLinePoint : halfLinePoints) {
						if (Arrays.equals(halfLinePoint, new int[]{left % size, right % size}) ||
								Arrays.equals(halfLinePoint, new int[]{right % size, left % size})) {
							isOkay = false;
							break;
						}
					}
					if (isOkay) {
						halfLinePoints.add(new int[]{left % size, right % size});
						count++;
					}
				}
				sum -= array[left];
				left++;
			} else if (right == size) {
				break;
			} else {
				sum += array[right];
				right++;
			}
		}
		return count;
	}
}
