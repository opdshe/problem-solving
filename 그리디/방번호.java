package 그리디;

import java.util.*;

public class 방번호 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		int[] prices = new int[countOfNumber];
		for (int i = 0; i < countOfNumber; i++) {
			prices[i] = scanner.nextInt();
		}
		int money = scanner.nextInt();
		String[] dp = new String[money + 1];
		Arrays.fill(dp, "");
		for (int idx = countOfNumber - 1; idx >= 0; idx--) {
			int price = prices[idx];
			for (int m = price; m <= money; m++) {
				String current = dp[m];
				String newStr = dp[m - price] + idx;
				if (newStr.length() >= 2 && newStr.charAt(0) == '0') {
					newStr = "0";
				}
				if (current.length() < newStr.length()) {
					dp[m] = newStr;
				} else if (current.length() == newStr.length()) {
					List<String> list = new ArrayList<>();
					list.add(current);
					list.add(newStr);
					list.sort(Comparator.reverseOrder());
					dp[m] = list.get(0);
				}
			}
		}
		System.out.println(dp[money]);
	}
}
