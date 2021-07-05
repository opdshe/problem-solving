package 기출.네이버웹툰2021;

import java.util.Arrays;
import java.util.Comparator;

public class 일번 {
	public static void main(String[] args) {
		solution(new int[]{32000, 18000, 42500}, new int[]{50, 20, 65});
	}

	public static int solution(int[] prices, int[] discounts) {
		return getPrice(prices, discounts);
	}

	private static int getPrice(int[] prices, int[] discounts) {
		int price = 0;
		int[] sortedPrices = Arrays.stream(prices)
				.boxed()
				.sorted(Comparator.reverseOrder())
				.mapToInt(Integer::valueOf)
				.toArray();
		int[] sortedDiscounts = Arrays.stream(discounts)
				.boxed()
				.sorted(Comparator.reverseOrder())
				.mapToInt(Integer::valueOf)
				.toArray();
		for (int idx = 0; idx < prices.length; idx++) {
			if (idx < discounts.length) {
				//할인적용
				price += getDiscountedPrice(sortedPrices[idx], sortedDiscounts[idx]);
			} else {
				//그냥 계산
				price += sortedPrices[idx];
			}
		}
		return price;
	}

	private static int getDiscountedPrice(int origin, int discount) {
		return (int) (origin * (100 - discount) * 0.01);
	}
}
