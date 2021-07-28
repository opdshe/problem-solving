package 이분탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 반도체설계 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		int numbers = scanner.nextInt();
		for (int i = 0; i < numbers; i++) {
			int num = scanner.nextInt();
			if (list.isEmpty()) {
				list.add(num);
				continue;
			}
			if(list.get(list.size()-1) < num){
				list.add(num);
			} else {
				int position = Collections.binarySearch(list, num);
				if (position < 0) {
					position = -position - 1;
				}
				list.set(position, num);
			}
		}
		System.out.println(list.size());
	}
}
