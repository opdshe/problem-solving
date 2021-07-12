package 기출.카카오2021;

import java.util.Stack;

public class 신규아이디추천 {
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"	));
	}

	public static String solution(String new_id) {
		return getNewId(new_id);
	}

	private static String getNewId(String origin) {
		//step 1
		origin = origin.toLowerCase();
		//step 2
		origin = origin.replaceAll("[^a-z0-9-_.]", "");
		//step 3
		origin = deleteContinuousPoint(origin);
		//step 4
		origin = deleteEndPoint(origin);
		//step 5
		origin = replaceAIfNull(origin);
		//step 6
		origin = cutStringIfTooLong(origin);
		//step 7
		origin = addStringIfTooShort(origin);
		return origin;
	}

	private static String addStringIfTooShort(String origin) {
		char lastChar = origin.charAt(origin.length() - 1);
		StringBuilder sb = new StringBuilder(origin);
		while (sb.length() < 3) {
			sb.append(lastChar);
		}
		return sb.toString();
	}

	private static String cutStringIfTooLong(String origin) {
		if (origin.length() >= 16) {
			origin = origin.substring(0, 15);
		}
		origin = deleteEndPoint(origin);
		return origin;
	}

	private static String replaceAIfNull(String origin) {
		if (origin.equals("")) {
			return "a";
		}
		return origin;
	}

	private static String deleteEndPoint(String origin) {
		if (origin.length() >=1 && origin.charAt(0) == '.') {
			origin = origin.substring(1);
		}
		if (origin.length() >= 1 && origin.charAt(origin.length() - 1) == '.') {
			origin = origin.substring(0, origin.length() - 1);
		}
		return origin;
	}

	private static String deleteContinuousPoint(String origin) {
		StringBuilder newString = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int idx = 0; idx < origin.length(); idx++) {
			char current = origin.charAt(idx);
			if(stack.isEmpty()){
				stack.push(current);
				continue;
			}
			if (current == '.') {
				if (stack.peek() != '.') {
					stack.push(current);
				}
			} else {
				stack.push(current);
			}
		}
		while (!stack.isEmpty()) {
			newString.insert(0, stack.pop());
		}
		return newString.toString();
	}
}
