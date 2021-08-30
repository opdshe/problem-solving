package 알고리즘;

public class 이분탐색원소검색 {
	/**
	 * 정렬된 상태라고 가정
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = new int[]{1, 3, 23, 45, 55, 67, 77, 78, 99};
		System.out.println(getTargetIndex(numbers, 23));
	}

	private static int getTargetIndex(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int midValue = array[mid];
			if (target > midValue) {
				left = mid + 1;
			} else if (target == midValue) {
				return mid;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
