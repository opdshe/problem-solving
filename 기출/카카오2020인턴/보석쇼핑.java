package 기출.카카오2020인턴;

import java.util.*;

public class 보석쇼핑 {
	private static Set<String> gemSet = new HashSet<>();
	private static Map<String, Integer> gemMap = new HashMap<>();

	public static void main(String[] args) {
		solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
	}

	public static int[] solution(String[] gems) {
		int[] answer = {};
		gemSet.addAll(Arrays.asList(gems));
		answer = search(gems);
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	private static int[] search(String[] gems) {
		int left = 0;
		int right = 0;
		int[] answer = new int[]{0, gems.length};

		while (true) {
			//다 모았을떄
			if (gemSet.size() == gemMap.size()) {
				if (right - left < answer[1] - answer[0]) {
					answer = new int[]{left, right};
				}
				if (gemMap.get(gems[left]).equals(1)) {
					gemMap.remove(gems[left]);
				} else {
					gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
				}
				left++;
			} else if (right == gems.length) {
				break;
			} else {
				gemMap.put(gems[right], gemMap.getOrDefault(gems[right], 0) + 1);
				right++;
			}
		}
		answer = new int[]{answer[0] + 1, answer[1]};
		return answer;
	}
}
