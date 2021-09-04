package 알고리즘;

import java.util.Arrays;

public class QuickSort {
	/**
	 * 평균적인 시간 복잡도 : O(NlogN)
	 * 최악 시간 복잡도 : O(N^2) 이미 정렬이 되어있는 경우
	 * 공간 복잡도 : O(N)
	 * Unstable sorting
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{1, 5, 3, 4, 2, 6};
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	private static void quickSort(int[] array, int left, int right) {
		if (left >= right) {
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
			while (array[end] > pivot) {
				end--;
			}
			while (start < end && array[start] <= pivot) {
				start++;
			}
			swap(array, start, end);
		}
		swap(array,left,start);
		return start;
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
