package 기출.카카오2021;

import java.util.*;

public class 메뉴리뉴얼 {
	private static boolean[] visited;
	private static int[] orders;
	private static Map<String, Integer> counts = new HashMap<>();
	private static Map<Integer, Integer> maxCounts = new HashMap<>();
	private static List<String> answers = new ArrayList<>();

	public static void main(String[] args) {
		solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
	}

	public static String[] solution(String[] orders, int[] course) {
		for (int count : course) {
			for (String order : orders) {
				char[] menus = order.toCharArray();
				Arrays.sort(menus);
				combine(menus, count);
			}
		}
		for (int count : course) {
			counts.entrySet().stream()
					.filter(entry -> entry.getKey().length() == count)
					.filter(entry -> entry.getValue() >= 2).min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
					.ifPresent(entry->maxCounts.put(count, entry.getValue()));
		}
		for (int count : course) {
			counts.entrySet().stream()
					.filter(entry -> entry.getKey().length() == count)
					.filter(entry -> entry.getValue().equals(maxCounts.get(count)))
					.map(Map.Entry::getKey)
					.forEach(menu -> answers.add(menu));
		}
		answers.sort(Comparator.naturalOrder());
		return answers.toArray(new String[0]);
	}

	private static void combine(char[] menus, int count) {
		visited = new boolean[menus.length];
		orders = new int[count];
		dfs(menus, 0, 0, count);
	}

	private static void dfs(char[] menus, int level, int start, int count) {
		if (level == count) {
			StringBuilder menu = new StringBuilder();
			for (int idx : orders) {
				menu.append(menus[idx]);
			}
			Integer currentCount = counts.getOrDefault(menu.toString(), 0);
			counts.put(menu.toString(), currentCount + 1);
			return;
		}
		for (int idx = start; idx < menus.length; idx++) {
			if (!visited[idx]) {
				visited[idx] = true;
				orders[level] = idx;
				dfs(menus, level + 1, idx + 1, count);
				visited[idx] = false;
			}
		}
	}
}
