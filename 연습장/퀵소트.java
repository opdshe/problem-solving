package 연습장;

import java.util.Arrays;

public class 퀵소트 {
	public static void main(String[] args) {
		int[] array = new int[]{1, 5, 3, 2, 6, 15, 8, 9, 13};
		quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	private static void quickSort(int[] array, int left, int right) {
		if(left >= right){
			return;
		}
		int partition = partition(array, left, right);
		quickSort(array, left, partition - 1);
		quickSort(array, partition + 1, right);
	}

	private static int partition(int[] array, int left, int right) {
		int pivot = array[left];
		int start = left;
		int end = right;

		while (start < end) {
			while (pivot < array[end]) {
				end--;
			}
			while (start < end && pivot >= array[start]) {
				start++;
			}
			swap(array, start, end);
		}
		array[left] = array[start];
		array[start] = pivot;
		return start;
	}

	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
