package 라이브러리;

import java.util.Arrays;
import java.util.List;

public class 이분탐색 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1, 1, 1, 3, 3, 3, 5, 7, 9);
		System.out.println(getLowerBound(list, -1));
		System.out.println(getUpperBound(list, 2));

		//upper - lower = 개수 (없으면 0나옴)
	}

	//target이 들어갈 idx 찾기 (가장 앞의 인덱스)
	private static int getLowerBound(List<Integer> list, int target) {
		int left = 0;
		int right = list.size() - 1; // index
		// l가 r랑 같아질때 까지
		while (left <= right) {
			int mid = (left + right) / 2;
			if (list.get(mid) < target) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		return left;
	}

	//target이 들어갈 idx 찾기 (가장 마지막 인덱스의 다음 인덱)
	private static int getUpperBound(List<Integer> list, int target) {
		int left = 0;
		int right = list.size() - 1; // index
		// l가 r랑 같아질때 까지
		while (left <= right) {
			int mid = (left + right) / 2;
			if (list.get(mid) <= target) {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		return left;
	}
}
