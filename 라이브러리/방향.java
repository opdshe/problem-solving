package 라이브러리;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 방향 {
	static List<int[]> directions = Arrays.asList(
			new int[]{-1, 0},
			new int[]{1, 0},
			new int[]{0, -1},
			new int[]{0, 1}
	);

	static Map<Integer, int[]> directionMap = new HashMap<>();

	static {
		directionMap.put(1, new int[]{-1, 0});
		directionMap.put(2, new int[]{1, 0});
		directionMap.put(3, new int[]{0, -1});
		directionMap.put(4, new int[]{0, 1});
	}

	private static boolean isValidPosition(int size, int nextRow, int nextColumn) {
		return nextRow >= 0 && nextRow < size &&
				nextColumn >= 0 && nextColumn < size;
	}
}
