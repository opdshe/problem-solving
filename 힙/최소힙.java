package 힙;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소힙 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
		int countOfInput = scanner.nextInt();
		for (int i = 0; i < countOfInput; i++) {
			int input = scanner.nextInt();
			if (input == 0) {
				if (priorityQueue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(priorityQueue.poll());
				}

			} else {
				priorityQueue.add(input);
			}
		}
	}
}
