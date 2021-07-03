package 이분탐색;

import java.util.Arrays;

public class 입국심사 {
	public static void main(String[] args) {
		solution(6, new int[]{7, 10});
	}

	public static long solution(int n, int[] times) {
		Arrays.sort(times);
		long answer = getMinTime(n, times);
		System.out.println(answer);
		return answer;
	}

	private static long getMinTime(int n, int[] times) {
		long left = 1;
		long right = (long)times[times.length - 1] * n;
		long minTime = right;
		while (left <= right) {
			long mid = (left + right) / 2;
			long count = 0;
			for (int time : times) {
				count += mid / time;
			}
			if (count >= n) {
				minTime = Math.min(minTime, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return minTime;
	}
}
