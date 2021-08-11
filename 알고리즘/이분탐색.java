package 알고리즘;

import java.util.Arrays;

public class 이분탐색 {
	public static void main(String[] args) {
		int[] array = new int[]{1,4,4,4,6,6,9,10,25,27,49};
		System.out.println(getIndex(array, 6));
	}

	private static int getIndex(int[] array, int target) {
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (array[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
}
