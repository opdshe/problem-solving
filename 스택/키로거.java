package 스택;

import java.io.*;
import java.util.Stack;

public class 키로거 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int test = 0; test < testcase; test++) {
			String str = br.readLine();
			solution(str);
		}
		bw.close();
		br.close();
	}

	private static void solution(String origin) throws IOException {
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for (int idx = 0; idx < origin.length(); idx++) {
			char current = origin.charAt(idx);
			if (current == '<') {
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
			} else if (current == '>') {
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
			} else if (current == '-') {
				if (!left.isEmpty()) {
					left.pop();
				}
			} else {
				left.push(current);
			}
		}
		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		while (!right.isEmpty()) {
			bw.write(right.pop());
		}
		bw.newLine();
		bw.flush();
	}

}
