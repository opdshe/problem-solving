package 기출.카카오2020인턴;

import java.util.HashMap;
import java.util.Map;

public class 키패드누르기 {
	private static int[] left = new int[]{3, 0};
	private static int[] right = new int[]{3, 2};

	private static final Map<Integer, int[]> pad = new HashMap<>();

	static {
		pad.put(1, new int[]{0, 0});
		pad.put(2, new int[]{0, 1});
		pad.put(3, new int[]{0, 2});

		pad.put(4, new int[]{1, 0});
		pad.put(5, new int[]{1, 1});
		pad.put(6, new int[]{1, 2});

		pad.put(7, new int[]{2, 0});
		pad.put(8, new int[]{2, 1});
		pad.put(9, new int[]{2, 2});
		pad.put(0, new int[]{3, 1});
	}

	public static void main(String[] args) {
		solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int number : numbers) {
			stringBuilder.append(getHand(number, hand));
		}
		return stringBuilder.toString();
	}

	private static String getHand(int current, String hand) {
		int[] position = pad.get(current);
		if (current == 1 || current == 4 || current == 7) {
			left = position;
			return "L";
		} else if (current == 3 || current == 6 || current == 9) {
			right = position;
			return "R";
		} else {
			int leftDistance = getDistance(left, position);
			int rightDistance = getDistance(right, position);
			if (leftDistance > rightDistance) {
				right = position;
				return "R";
			} else if (leftDistance < rightDistance) {
				left = position;
				return "L";
			} else {
				if (hand.equals("left")) {
					left = position;
					return "L";
				} else {
					right = position;
					return "R";
				}
			}
		}
	}

	private static int getDistance(int[] source, int[] dest) {
		return Math.abs(source[0] - dest[0]) + Math.abs(source[1] - dest[1]);
	}
}
