package 알고리즘;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] array = new int[]{6, 3, 5, 2, 4, 9, 1};
		selectionSort(array);
		System.out.println(Arrays.toString(array));

		/**
		 * unstable
		 * 반례 : 4,2,3,4,1
		 */
	}

	private static void selectionSort(int[] array) {
		for (int targetIdx = 0; targetIdx < array.length - 1; targetIdx++) {
			int minIdx = targetIdx;
			for (int compareIdx = targetIdx + 1; compareIdx < array.length; compareIdx++) {
				if (array[minIdx] > array[compareIdx]) {
					minIdx = compareIdx;
				}
			}
			swap(array, targetIdx, minIdx);
		}
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}
}
