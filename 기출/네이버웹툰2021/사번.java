package 기출.네이버웹툰2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//"abcxyqueryxyabc"
public class 사번 {
	private static List<SubString> candidates = new ArrayList<>();

	public static void main(String[] args) {
		solution("abcdabc");
	}

	public static String[] solution(String s) {
		twoPointer(s);
		String[] answer = candidates.stream()
				.map(candidate -> candidate.sub)
				.toArray(String[]::new);
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	private static void twoPointer(String origin) {
		int leftStart = 0;
		int rightEnd = origin.length() - 1;

		while (leftStart <= rightEnd) {
			for (int length = 1; length <= origin.length(); length++) {
				int leftEnd = leftStart + length - 1;
				int rightStart = rightEnd - length + 1;
				if (leftStart >= 0 && leftEnd < origin.length() &&
						rightStart >= 0 && rightEnd < origin.length()) {
					String left = origin.substring(leftStart, leftStart + length);
					String right = origin.substring(rightEnd - length + 1, rightEnd + 1);
					if (left.equals(right)) {
						if (leftStart == rightStart) {
							candidates.add(new SubString(left, true));
						} else {
							candidates.add(new SubString(left, false));
						}
						leftStart = leftStart + length;
						rightEnd = rightEnd - length;
						break;
					}
				}
			}
		}
		for (int idx = candidates.size() - 1; idx >= 0; idx--) {
			SubString subString = candidates.get(idx);
			if (!subString.duplicated) {
				candidates.add(subString);
			}
		}
	}

	private static class SubString {
		private String sub;
		private boolean duplicated;

		public SubString(String sub, boolean duplicated) {
			this.sub = sub;
			this.duplicated = duplicated;
		}
	}
}
