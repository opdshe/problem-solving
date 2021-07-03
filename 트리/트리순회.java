package 트리;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 트리순회 {
	private static final Scanner scanner = new Scanner(System.in);
	private static Map<String, Node> tree = new HashMap<>();

	public static void main(String[] args) {
		int nodes = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < nodes; i++) {
			String[] nodeInfo = scanner.nextLine().split(" ");
			tree.put(nodeInfo[0], new Node(nodeInfo[1], nodeInfo[2]));
		}
		preOrder("A");
		System.out.println();
		inOrder("A");
		System.out.println();
		postOrder("A");
	}

	private static void postOrder(String current) {
		Node node = tree.get(current);
		if (node.left != null) {
			postOrder(node.left);
		}
		if (node.right != null) {
			postOrder(node.right);
		}
		System.out.print(current);
	}

	private static void inOrder(String current) {
		Node node = tree.get(current);
		if (node.left != null) {
			inOrder(node.left);
		}
		System.out.print(current);
		if (node.right != null) {
			inOrder(node.right);
		}
	}

	private static void preOrder(String current) {
		System.out.print(current);
		Node node = tree.get(current);
		if (node.left != null) {
			preOrder(node.left);
		}
		if (node.right != null) {
			preOrder(node.right);
		}
	}

	private static class Node {
		private String left;
		private String right;

		public Node(String left, String right) {
			if (!left.equals(".")) {
				this.left = left;
			}
			if (!right.equals(".")) {
				this.right = right;
			}
		}
	}
}
