package 라이브러리;

public class 순열만들기 {
	static boolean[] visited;
	static int[] orders;
	static int count = 0;


	// n 개 고르기, n = 5
	public static void main(String[] args) {
		int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
		permutation(numbers, 2);
	}

	//3개
	private static void permutation(int[] numbers, int n) {
		visited = new boolean[numbers.length];
		orders = new int[n];
		dfs(numbers, n, 0);
		System.out.println(count);
	}

	private static void dfs(int[] numbers, int n, int level) {
		if (level == n) {
			count++;
			for (int value : orders) {
				System.out.print(numbers[value] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				orders[level] = i;
				dfs(numbers, n, level + 1);
				visited[i] = false;
			}
		}
	}
}
