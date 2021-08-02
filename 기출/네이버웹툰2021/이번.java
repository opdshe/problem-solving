package 기출.네이버웹툰2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 이번 {
	private static List<SubString> candidates = new ArrayList<>();

	public static void main(String[] args) {
		solution("abcxyqueryxyabc");
	}

	public static String[] solution(String s) {
		dfs(new ArrayList<>(), s, 0, s.length() - 1);
		String[] answer = candidates.stream()
				.map(candidate -> candidate.sub)
				.toArray(String[]::new);
		return answer;
	}

	private static void dfs(List<SubString> list, String origin, int leftStart, int rightLast) {
		if (leftStart > rightLast) {
			for (int idx = list.size() - 1; idx >= 0; idx--) {
				SubString subString = list.get(idx);
				if(!subString.duplicated){
					list.add(subString);
				}
			}
			if (candidates.size() < list.size()) {
				candidates = list;
			}
			return;
		}
		for (int length = 1; length <= origin.length(); length++) {
			int leftEnd = leftStart + length - 1;
			int rightStart = rightLast - length+1;
			if (leftStart >= 0 && leftEnd < origin.length() &&
					rightStart >= 0 && rightLast < origin.length()) {
				String left = origin.substring(leftStart, leftStart + length);
				String right = origin.substring(rightLast - length + 1, rightLast + 1);
				if (left.equals(right)) {
					List<SubString> newList = new ArrayList<>(list);
					if (leftStart == rightStart) {
						newList.add(new SubString(left, true));
					} else {
						newList.add(new SubString(left, false));
					}
					dfs(newList, origin, leftStart + length, rightLast - length);
					break;
				}
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
