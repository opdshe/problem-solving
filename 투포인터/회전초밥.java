package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 회전초밥 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dishes = Integer.parseInt(st.nextToken());
		int menuCount = Integer.parseInt(st.nextToken());
		int continuousDish = Integer.parseInt(st.nextToken());
		int coupon = Integer.parseInt(st.nextToken());
		int[] menu = new int[dishes];
		for (int i = 0; i < dishes; i++) {
			menu[i] = Integer.parseInt(br.readLine());
		}
		search(menu, dishes, continuousDish, coupon);
		System.out.println(search(menu, dishes, continuousDish, coupon));
	}

	private static int search(int[] menu, int dishes, int continuousDish, int coupon) {
		int answer = -1;
		for (int left = 0; left < dishes; left++) {
			Set<Integer> set = new HashSet<>();
			for (int idx = left; idx < left + continuousDish; idx++) {
				set.add(menu[idx % dishes]);
			}
			int count = set.contains(coupon) ? set.size() : set.size() + 1;
			answer = Math.max(answer, count);
		}
		return answer;
	}
}
