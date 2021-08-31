package 알고리즘;

import java.util.Arrays;

public class 버블소트 {
	public static void main(String[] args) {
		int[] array = new int[]{1, 3, 2, -1, 5, 4, 9, 6};
		bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void bubbleSort(int[] array) {
		for (int count = 1; count <= array.length; count++) {
			for (int idx = 0; idx < array.length - count; idx++) {
				if (array[idx] > array[idx + 1]) {
					swap(array, idx, idx + 1);
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
