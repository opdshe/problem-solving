package 재귀;

import java.util.Scanner;

public class 피보나치수 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int target = scanner.nextInt();
		int answer = fibonacci(target);
		System.out.println(answer);
	}

	private static int fibonacci(int target) {
		if(target == 0 || target == 1){
			return target;
		}
		return fibonacci(target - 1) + fibonacci(target - 2);
	}
}
