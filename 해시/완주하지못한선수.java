package 해시;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
	private static Map<String, Integer> entry = new HashMap<>();

	public static void main(String[] args) {
		solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
	}

	public static String solution(String[] participants, String[] completions) {
		Arrays.stream(participants)
				.forEach(participant -> entry.put(participant, entry.getOrDefault(participant, 0) + 1));
		Arrays.stream(completions)
				.forEach(completion -> entry.put(completion, entry.get(completion) - 1));
		return entry.entrySet().stream()
				.filter(e -> e.getValue()==1)
				.map(Map.Entry::getKey)
				.findFirst()
				.get();
	}
}
