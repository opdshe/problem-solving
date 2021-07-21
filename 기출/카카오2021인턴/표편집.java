package 기출.카카오2021인턴;

import java.util.Stack;

public class 표편집 {
	public static void main(String[] args) {
		solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
	}

	public static String solution(int n, int k, String[] cmd) {
		Stack<Integer> remove = new Stack<>();
		int tableSize = n;
		for (String command : cmd) {
			String[] split = command.split(" ");
			if (split[0].equals("U")) {
				int offset = Integer.parseInt(split[1]);
				k -= offset;
			} else if (split[0].equals("D")) {
				int offset = Integer.parseInt(split[1]);
				k += offset;
			} else if (split[0].equals("C")) {
				remove.push(k);
				tableSize--;
				if (k == tableSize) {
					k--;
				}
			} else if (split[0].equals("Z")) {
				int r = remove.pop();
				if (k >= r) k += 1;
				tableSize++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("O".repeat(Math.max(0, tableSize)));
		while(!remove.isEmpty()) {
			sb.insert(remove.pop().intValue(), 'X');
		}
		return sb.toString();
	}
}
