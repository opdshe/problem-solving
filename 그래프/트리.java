package 그래프;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 트리 {
	private static final Scanner scanner = new Scanner(System.in);
	private static Tree tree;
	private static int[] parents;
	private static int nodes;

	public static void main(String[] args) {
		nodes = scanner.nextInt();
		parents = new int[nodes];
		for (int idx = 0; idx < nodes; idx++) {
			parents[idx] = scanner.nextInt();
		}
		for (int idx = 0; idx < nodes; idx++) {
			if (parents[idx] == -1) {
				tree = new Tree(new Node(idx));
			}
		}
		int remove = scanner.nextInt();
		tree.connect();
		tree.remove(remove);
		int answer = tree.countLeaf();
		System.out.println(answer);
	}

	private static class Tree {
		private Node root;

		public Tree(Node root) {
			this.root = root;
		}

		public int countLeaf() {
			if (root == null) {
				return 0;
			}
			return this.root.countLeaf();
		}

		public void remove(int target) {
			if (root.idx == target) {
				root = null;
			} else {
				root.remove(target);
			}
		}

		public void connect() {
			root.connect();
		}
	}

	private static class Node {
		private int idx;
		private Map<Integer, Node> children = new HashMap<>();

		public Node(int idx) {
			this.idx = idx;
		}

		public int countLeaf() {
			if (children.size() == 0) {
				return 1;
			}
			int count = 0;
			for (Node child : children.values()) {
				count += child.countLeaf();
			}
			return count;
		}

		public void remove(int target) {
			if (children.containsKey(target)) {
				children.remove(target);
				return;
			}
			for (Node child : children.values()) {
				child.remove(target);
			}
		}

		public void connect() {
			for (int idx = 0; idx < nodes; idx++) {
				if (parents[idx] == this.idx) {
					this.children.put(idx, new Node(idx));
					Node next = this.children.get(idx);
					next.connect();
				}
			}
		}
	}
}
