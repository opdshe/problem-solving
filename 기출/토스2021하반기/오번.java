package 기출.토스2021하반기;

import java.util.*;

public class 오번 {
	private static Set<Integer> answer = new HashSet<>();

	public static void main(String[] args) {
		solution(new int[]{30, 40, 10, 20, 30}, 3);
	}

	public static int[] solution(int[] fruitWeights, int k) {
		int left = 0;
		int right = 0;
		int max = 0;
		while (true) {
			if (right - left > k) {
				left++;
			} else if (right == fruitWeights.length+1) {
				break;
			} else {
				if (right - left == k) {
					for (int idx = left; idx < left + k; idx++) {
						max = Math.max(max, fruitWeights[idx]);
					}
					answer.add(max);
				}
				right++;
			}
		}
		List<Integer> collect = new ArrayList<>(answer);
		collect.sort(Comparator.reverseOrder());
		return collect.stream()
				.mapToInt(Integer::valueOf)
				.toArray();
	}
}
