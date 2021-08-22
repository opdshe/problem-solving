package 정렬;

import java.util.Arrays;

public class 퀵소트 {
	public static void main(String[] args) {
		int[] array = new int[]{1, 5, 2, 4, 3, 7};
		quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	private static void quickSort(int[] array, int left, int right) {
		if(left >= right){
			return;
		}

		int pivot = partition(array, left, right);
		quickSort(array, left, pivot-1);
		quickSort(array, pivot+1, right);
	}

	private static int partition(int[] array, int start, int end) {
		int pivot = array[start];
		int left = start;
		int right = end;

		while (left < right) {
			while (pivot < array[right]) {
				right--;
			}
			while (pivot >= array[left] && left < right) {
				left++;
			}
			swap(array, left, right);
		}
		array[start] = array[left];
		array[left] = pivot;
		return left;
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
