package 그래프.서로소집합;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 텀프로젝트 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int studentCount = scanner.nextInt();
			int[] students = new int[studentCount + 1];
			for (int idx = 1; idx <= studentCount; idx++) {
				students[idx] = scanner.nextInt();
			}
			int single = getSingle(students, studentCount);
			System.out.println(single);
		}
	}

	private static int getSingle(int[] students, int studentCount) {
		boolean[] matched = new boolean[studentCount + 1];
		int count = 0;
		for (int idx = 1; idx <= studentCount; idx++) {
			if (!matched[idx]) {
				dfs(students, matched, idx, new ArrayList<>());
			}
		}
		for (int idx = 1; idx <= studentCount; idx++) {
			if (!matched[idx]) {
				count++;
			}
		}
		return count;
	}

	private static void dfs(int[] students, boolean[] matched, int current, List<Integer> group) {

	}
}
