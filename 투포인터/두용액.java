package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 두용액 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		scanner.nextLine();
		int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		Arrays.sort(numbers);
		solution(numbers);
	}

	private static void solution(int[] numbers) {
		int left = 0;
		int right = numbers.length - 1;
		int answerLeft = -1;
		int answerRight = -1;
		long diff = Integer.MAX_VALUE;
		while (left < right) {
			long currentDiff = Math.abs(numbers[left] + numbers[right]);
			long sum = numbers[left] + numbers[right];
			if (diff > currentDiff) {
				answerLeft = left;
				answerRight = right;
				diff = currentDiff;
			}
			if (sum >= 0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(numbers[answerLeft] + " " + numbers[answerRight]);
	}
}
