package 라이브러리;

public class 조합만들기 {
	static boolean[] visited;
	static int[] orders;


	// n 개 고르기
	public static void main(String[] args) {
		int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
		combine(numbers, 3);
	}

	//3개
	private static void combine(int[] numbers, int n) {
		visited = new boolean[numbers.length];
		orders = new int[n];
		dfs(numbers, 0, 0);
	}

	private static void dfs(int[] numbers, int start, int level) {
		if (level == orders.length) {
			for (int value : orders) {
				System.out.print(numbers[value] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				orders[level] = i;
				dfs(numbers, i + 1, level + 1);
				visited[i] = false;
			}
		}
	}
}
