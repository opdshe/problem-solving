package 알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 최장증가수열 {
	public static void main(String[] args) {
		int[] array = new int[]{7, 2, 3, 8, 4, 5};
		System.out.println(Arrays.toString(getLIS(array)));
	}

	private static int[] getLIS(int[] array) {
		List<Integer> LIS = new ArrayList<>();
		for (int num : array) {
			if (LIS.isEmpty()) {
				LIS.add(num);
				continue;
			}
			if (LIS.get(LIS.size() - 1) < num) {
				LIS.add(num);
			} else {
				int position = Collections.binarySearch(LIS, num);
				if (position < 0) {
					position = -position - 1;
					LIS.set(position, num);
				}
			}
		}
		return LIS.stream()
				.mapToInt(Integer::valueOf)
				.toArray();
	}
}
