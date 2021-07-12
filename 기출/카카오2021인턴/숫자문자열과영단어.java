package 기출.카카오2021인턴;

import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과영단어 {
	private static Map<String, Integer> words = new HashMap<>();

	public int solution(String s) {
		init();
		for (Map.Entry<String, Integer> entry : words.entrySet()) {
			s = s.replaceAll(entry.getKey(), String.valueOf(entry.getValue()));
		}
		return Integer.parseInt(s);
	}

	private static void init() {
		words.put("zero", 0);
		words.put("one", 1);
		words.put("two", 2);
		words.put("three", 3);
		words.put("four", 4);
		words.put("five", 5);
		words.put("six", 6);
		words.put("seven", 7);
		words.put("eight", 8);
		words.put("nine", 9);
	}
}
