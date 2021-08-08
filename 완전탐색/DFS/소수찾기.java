package 완전탐색.DFS;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
	private static Set<Integer> answerSet = new HashSet<>();

	public static void main(String[] args) {
		solution("011");
	}

	public static int solution(String numbers) {
		for (int length = 1; length <= numbers.length(); length++) {
			boolean[] visited = new boolean[numbers.length()];
			int[] order = new int[length];
			permutation(visited, order, numbers, 0, length);
		}
		return answerSet.size();
	}

	private static void permutation(boolean[] visited, int[] order, String numbers, int level, int length) {
		if (level == length) {
			//소수인지 확인
			StringBuilder sb = new StringBuilder();
			for (int idx : order) {
				sb.append(numbers.charAt(idx));
			}
			int number = Integer.parseInt(sb.toString());
			if (isPrimeNumber(number)) {
				answerSet.add(number);
			}
			return;
		}
		for (int idx = 0; idx < visited.length; idx++) {
			if (!visited[idx]) {
				visited[idx] = true;
				order[level] = idx;
				permutation(visited, order, numbers, level + 1, length);
				visited[idx] = false;
			}
		}
	}

	private static boolean isPrimeNumber(int number) {
		if (number == 1 || number ==0) {
			return false;
		}
		for (int num = 2; num < number; num++) {
			if (number % num == 0) {
				return false;
			}
		}
		return true;
	}
}
