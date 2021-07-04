package 이분탐색;

import java.util.Arrays;

public class 징검다리건너기 {
	public int solution(int[] stones, int k) {
		int answer = 0;
		return search(stones, k);
	}

	private static int search(int[] stones, int k) {
		int answer = -1;
		int left = 1;
		int right = Arrays.stream(stones)
				.max()
				.getAsInt();
		while (left <= right) {
			boolean isOkay = true;
			int pass = (left + right) / 2;
			int jump = 0;
			for (int stone : stones) {
				int value = stone - pass;
				if (value <= 0) {
					jump++;
				} else {
					jump = 0;
				}
				if (jump == k) {
					isOkay = false;
					break;
				}
			}
			if (!isOkay) {
				right = pass - 1;
			} else {
				answer = Math.max(answer, pass + 1);
				left = pass + 1;
			}
		}
		return answer;
	}
}
