package 스택;

import java.util.Scanner;
import java.util.Stack;

public class 괄호 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfInput = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < countOfInput; i++) {
			String parentheses = scanner.nextLine();
			boolean isValid = isValidParentheses(parentheses);
			System.out.println(isValid ? "YES" : "NO");
		}
	}

	private static boolean isValidParentheses(String parentheses) {
		Stack<Character> stack = new Stack<>();
		boolean isValid = true;
		for (int idx = 0; idx < parentheses.length(); idx++) {
			char character = parentheses.charAt(idx);
			if (character == '(') {
				stack.push(character);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					isValid = false;
					break;
				}
			}
		}
		if (!stack.isEmpty()) {
			isValid = false;
		}
		return isValid;
	}
}
