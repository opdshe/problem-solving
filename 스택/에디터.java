package 스택;

import java.io.*;
import java.util.Stack;

public class 에디터 {
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		String str = bf.readLine();
		int orders = Integer.parseInt(bf.readLine());
		for (int idx = 0; idx < str.length(); idx++) {
			left.push(str.charAt(idx));
		}
		for (int i = 0; i < orders; i++) {
			String[] order = bf.readLine().split(" ");
			doOrder(order, left, right);
		}
		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		while (!right.isEmpty()) {
			bw.write(right.pop());
		}
		bw.flush();
		bf.close();
		bf.close();
	}

	private static void doOrder(String[] order, Stack<Character> left, Stack<Character> right) {
		switch (order[0]) {
			case "L":
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
				break;
			case "D":
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
				break;
			case "B":
				if (!left.isEmpty()) {
					left.pop();
				}
				break;
			case "P":
				left.push(order[1].charAt(0));
				break;
		}
	}
}
