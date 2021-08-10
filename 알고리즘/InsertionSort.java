package 알고리즘;

import java.util.Arrays;

public class InsertionSort {
	/** 시간 복잡도 : O(n^2)
	 *  공간 복잡도 : O(n)
	 *  but, 정렬된 상태에서는 굉장히 빠름
	 *  stable sorting
	 */
	public static void main(String[] args) {
		int[] array = new int[]{5, 7, 3, 4, 1, 9};
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void insertionSort(int[] array) {
		for (int target = 1; target < array.length; target++) {
			int targetValue = array[target];
			int prevIdx = target - 1;
			while (prevIdx >= 0 && array[prevIdx] > targetValue) {
				array[prevIdx + 1] = array[prevIdx];
				prevIdx--;
			}
			array[prevIdx + 1] = targetValue;
		}
	}
}
