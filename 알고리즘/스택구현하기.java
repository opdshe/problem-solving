package 알고리즘;

import java.util.NoSuchElementException;
import java.util.Objects;

public class 스택구현하기 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		while (!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

	private static class Stack<T> {
		private Node<T> top;

		public void push(T data) {
			Node<T> node = new Node<>(data);
			if (Objects.isNull(top)) {
				top = node;
				return;
			}
			top.add(node);
			top = node;
		}

		public T pop() {
			if (Objects.isNull(top)) {
				throw new NoSuchElementException();
			}
			Node<T> node = top;
			top = top.next;
			return node.data;
		}

		public boolean isEmpty() {
			return Objects.isNull(top);
		}
	}

	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}

		public void add(Node<T> node) {
			node.next = this;
		}
	}
}
