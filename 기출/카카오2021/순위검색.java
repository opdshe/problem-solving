package 기출.카카오2021;

import java.util.*;

public class 순위검색 {
	public static void main(String[] args) {
		solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
				new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
	}

	public static int[] solution(String[] infos, String[] queries) {
		List<Integer> answer = new ArrayList<>();
		Trie trie = new Trie();
		for (String info : infos) {
			String[] split = info.split(" ");
			trie.add(split);
		}
		for (String query : queries) {
			query = query.replaceAll(" and", "");
			String[] split = query.split(" ");
			int result = trie.root.getResult(split, 0);
			answer.add(result);

		}
		int[] answerArray = answer.stream()
				.mapToInt(Integer::valueOf)
				.toArray();
		System.out.println(Arrays.toString(answerArray));
		return answerArray;
	}

	private static class Trie {
		private Node root = new Node();

		private void add(String[] info) {
			Node current = root;
			for (int idx = 0; idx < 4; idx++) {
				if (!current.children.containsKey(info[idx])) {
					current.children.put(info[idx], new Node());
				}
				current = current.children.get(info[idx]);
			}
			int position = getLowerBound(current.scores, Integer.parseInt(info[4]));
			current.scores.add(position, Integer.valueOf(info[4]));
		}
	}

	private static class Node {
		private Map<String, Node> children = new HashMap<>();
		private List<Integer> scores = new ArrayList<>();

		private int getResult(String[] query, int queryIdx) {
			if (queryIdx == 4) {
				int number = getLowerBound(scores, Integer.parseInt(query[4]));
				return scores.size() - number;
			}
			String current = query[queryIdx];
			int result = 0;
			if (current.equals("-")) {
				for (Node node : children.values()) {
					result += node.getResult(query, queryIdx + 1);
				}
			}
			if (children.containsKey(current)) {
				Node node = children.get(current);
				result += node.getResult(query, queryIdx + 1);
			}
			return result;
		}
	}

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
}
