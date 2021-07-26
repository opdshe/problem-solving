package 기출.카카오2020;

import java.util.Stack;

public class 괄호변환 {
	public static void main(String[] args) {
		String answer = solution("()))((()"	);
		System.out.println(answer);
	}

	public static String solution(String p) {
		return getAnswer(p);
	}

	private static String getAnswer(String origin) {
		if(isRightString(origin)){
			return origin;
		}
		if (origin.equals("")) {
			return "";
		}
		int divideIdx = getBalancedIndex(origin);
		String u = origin.substring(0, divideIdx);
		String v = origin.substring(divideIdx);
		if (isRightString(u)) {
			return u + getAnswer(v);
		} else {
			String str = "(";
			str += getAnswer(v);
			str += ")";
			str += getReversedString(u);
			return str;
		}
	}

	private static String getReversedString(String origin) {
		StringBuilder stringBuilder = new StringBuilder();
		String sub = origin.substring(1, origin.length() - 1);
		for (int idx = 0; idx < sub.length(); idx++) {
			if (sub.charAt(idx) == '(') {
				stringBuilder.append(')');
			} else {
				stringBuilder.append('(');
			}
		}
		return stringBuilder.toString();
	}

	private static int getBalancedIndex(String origin) {
		int end = origin.length();
		int open = 0;
		int close = 0;
		for (int idx = 0; idx < origin.length(); idx++) {
			if (idx != 0 && open == close) {
				end = idx;
				break;
			}
			char current = origin.charAt(idx);
			if (current == '(') {
				open++;
			} else {
				close++;
			}
		}
		return end;
	}

	private static boolean isRightString(String origin) {
		Stack<Character> stack = new Stack<>();
		for (int idx = 0; idx < origin.length(); idx++) {
			char current = origin.charAt(idx);
			if (stack.isEmpty()) {
				if (current == '(') {
					stack.push(current);
					continue;
				} else {
					return false;
				}
			}
			if (current == '(') {
				stack.push(current);
			} else {
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
