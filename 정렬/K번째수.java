package 정렬;

import java.util.Arrays;

public class K번째수 {
	/**
	 * 반환할 때 List<Integer> 로 저장하고 stream으로 array 변환 후 반환하면 훨씬 느림.
	 **/
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int idx = 0; idx < commands.length; idx++) {
			int[] command = commands[idx];
			int[] sub = Arrays.copyOfRange(array, command[0] - 1, command[1]);
			Arrays.sort(sub);
			answer[idx] = (sub[command[2] - 1]);
		}
		return answer;
	}
}
