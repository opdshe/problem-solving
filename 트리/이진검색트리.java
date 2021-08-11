package 트리;

import java.util.Objects;
import java.util.Scanner;

public class 이진검색트리 {
	private static final Scanner scanner = new Scanner(System.in);
	private static Tree tree = new Tree();

	public static void main(String[] args) {
		while (scanner.hasNext()) {
			try {
				int target = scanner.nextInt();
				tree.add(target);
			} catch (Exception e){
				break;
			}
		}
		tree.printPostOrder();
	}

	private static class Tree {
		private Node root;

		public void add(int target) {
			if (Objects.isNull(root)) {
				root = new Node(target);
			} else {
				root.add(target);
			}
		}

		public void printPostOrder() {
			this.root.printPostOrder();
		}
	}

	private static class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int target) {
			this.value = target;
		}

		public void printPostOrder() {
			if(Objects.nonNull(left)){
				left.printPostOrder();
			}
			if(Objects.nonNull(right)){
				right.printPostOrder();
			}
			System.out.println(value);
		}

		public void add(int target) {
			if (this.value > target) {
				if (Objects.isNull(this.left)) {
					left = new Node(target);
				} else {
					this.left.add(target);
				}
			} else {
				if (Objects.isNull(this.right)) {
					right = new Node(target);
				} else {
					this.right.add(target);
				}
			}
		}
	}
}
