package 기출.카카오2019인턴;

import java.util.*;

public class 불량사용자 {
	private static int[] idxes;
	private static boolean[] visited;
	private static Set<List<Integer>> answer = new HashSet<>();

	public static void main(String[] args) {
		solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
				new String[]{"fr*d*", "abc1**"});
	}

	public static int solution(String[] user_id, String[] banned_id) {
		idxes = new int[banned_id.length];
		visited = new boolean[user_id.length];

		dfs(user_id, banned_id, 0);
		System.out.println(answer.size());
		return answer.size();
	}

	private static void dfs(String[] user_id, String[] banned_id, int level) {
		if (level == idxes.length) {
			List<Integer> list = new ArrayList<>();
			for (int idx : idxes) {
				list.add(idx);
			}
			list.sort(Comparator.naturalOrder());
			answer.add(list);
			return;
		}
		for (int idx = 0; idx < user_id.length; idx++) {
			if (isBanId(user_id[idx], banned_id[level])) {
				if (!visited[idx]) {
					visited[idx] = true;
					idxes[level] = idx;
					dfs(user_id, banned_id, level + 1);
					visited[idx] = false;
				}
			}

		}
	}

	private static boolean isBanId(String origin, String ban) {
		if (origin.length() != ban.length()) {
			return false;
		}
		for (int idx = 0; idx < origin.length(); idx++) {
			if (origin.charAt(idx) != ban.charAt(idx)) {
				if (ban.charAt(idx) != '*') {
					return false;
				}
			}
		}
		return true;
	}
}
