package 완전탐색.DFS;

import java.util.Scanner;

public class 텀프로젝트 {
	private static final Scanner scanner = new Scanner(System.in);
	private static int count = 0;

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int studentCount = scanner.nextInt();
			int[] students = new int[studentCount + 1];
			for (int idx = 1; idx <= studentCount; idx++) {
				students[idx] = scanner.nextInt();
			}
			int answer = getSingle(students, studentCount);
			System.out.println(answer);
		}
	}

	private static int getSingle(int[] students, int studentCount) {
		boolean[] visited = new boolean[studentCount + 1];
		boolean[] matched = new boolean[studentCount + 1];
		count = 0;
		for (int idx = 1; idx <= studentCount; idx++) {
			dfs(students, visited, matched, idx);
		}
		return studentCount - count;
	}

	private static void dfs(int[] students, boolean[] visited, boolean[] matched, int current) {
		if (visited[current]) {
			matched[current] = true;
			count++;
		} else {
			visited[current] = true;
		}
		int want = students[current];
		if (!matched[want]) {
			dfs(students, visited, matched, want);
		}
		visited[current] = false;
		matched[current] = true;
	}
}
