package 그리디;

import java.util.*;

public class 수묶기 {
	private static Scanner scanner = new Scanner(System.in);
	private static Queue<Integer> one = new ArrayDeque<>();
	private static Queue<Integer> negative = new PriorityQueue<>();
	private static Queue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
	private static Queue<Integer> zero = new ArrayDeque<>();
	private static int sum;

	public static void main(String[] args) {
		int numbers = scanner.nextInt();
		for (int i = 0; i < numbers; i++) {
			int num = scanner.nextInt();
			if (num < 0) {
				negative.add(num);
			} else if (num == 0) {
				zero.add(num);
			} else if (num == 1) {
				one.add(num);
			} else {
				positive.add(num);
			}
		}
		init();
		System.out.println(sum);

	}

	private static void init() {
		while (negative.size() > 1) {
			int a = negative.poll();
			int b = negative.poll();
			sum += a * b;
		}

		while (positive.size() > 1) {
			int bigger = positive.poll();
			int smaller = positive.poll();
			sum += bigger * smaller;
		}
		if (!positive.isEmpty()) {
			sum += positive.poll();
		}
		while (!one.isEmpty()) {
			sum += one.poll();
		}
		if (!negative.isEmpty()) {
			if (zero.isEmpty()) {
				sum += negative.poll();
			}
		}
	}
}
