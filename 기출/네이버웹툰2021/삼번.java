package 기출.네이버웹툰2021;

import java.util.Stack;

public class 삼번 {
	public static void main(String[] args) {
		String s = "ababab";
		String t = "ab";
		int answer = solution(s, t);
		System.out.println(answer);
	}

	public static int solution(String s, String t) {
		Stack<Character> stack = new Stack<>();
		char last = t.charAt(t.length() - 1);
		int count = 0;
		for (int idx = 0; idx < s.length(); idx++) {
			char current = s.charAt(idx);
			if (current == last) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < t.length() - 1; i++) {
					sb.insert(0, stack.pop());
				}
				sb.append(current);
				if (sb.toString().equals(t)) {
					//t와 같을 경우
					count++;
				} else {
					for (int i = 0; i < sb.length(); i++) {
						stack.push(sb.charAt(i));
					}
				}
			} else {
				stack.push(current);
			}
		}
		return count;
	}
}
