package 알고리즘;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = new int[]{35, 25, 3, 2, 15, 1};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void bubbleSort(int[] array) {
		for (int compareCount = 1; compareCount <= array.length - 1; compareCount++) {
			for (int prevIdx = 0; prevIdx < array.length - compareCount; prevIdx++) {
				if (array[prevIdx] > array[prevIdx + 1]) {
					swap(array, prevIdx, prevIdx + 1);
				}
			}
		}
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
	}
}
