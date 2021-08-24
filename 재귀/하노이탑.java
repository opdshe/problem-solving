package 재귀;

import java.io.IOException;
import java.util.Scanner;

public class 하노이탑 {
	private static Scanner scanner = new Scanner(System.in);
	private static int count = 0;
	private static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int height = scanner.nextInt();
		hanoi(3, 1, 2, 3);
		answer.insert(0, count + "\n");
		System.out.println(answer.toString());
	}

	private static void hanoi(int height, int current, int sub, int target) throws IOException {
		count++;
		if (height == 1) {
			answer.append(current).append(" ").append(target).append("\n");
			return;
		}
		hanoi(height - 1, current, target, sub);
		answer.append(current).append(" ").append(target).append("\n");
		hanoi(height - 1, sub, current, target);
	}
}
