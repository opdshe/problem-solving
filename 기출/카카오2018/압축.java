package 기출.카카오2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
	private static final Map<String, Integer> dictionary = new HashMap<>();

	public static void main(String[] args) {
		solution("KAKAO");
	}

	private static void init() {
		for (int i = 65; i <= 90; i++) {
			dictionary.put(String.valueOf((char) i), i -64);
		}
	}

	public static int[] solution(String msg) {
		init();
		List<Integer> answer = new ArrayList<>();
		int idx = 0;
		int dictionaryNumber = 27;
		while (idx < msg.length()) {
			String longestSub = msg.substring(idx, idx + 1);
			String next = longestSub;
			for (int length = 1; idx + length <= msg.length(); length++) {
				String sub = msg.substring(idx, idx + length);
				if (dictionary.containsKey(sub)) {
					longestSub = sub;
				} else {
					next = msg.substring(idx, idx + length);
					break;
				}
			}
			answer.add(dictionary.get(longestSub));
			idx += longestSub.length();
			dictionary.put(next, dictionaryNumber++);
		}
		return answer.stream()
				.mapToInt(Integer::valueOf)
				.toArray();
	}
}
