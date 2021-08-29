package 알고리즘;

import java.util.NoSuchElementException;

public class 큐구현하기 {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.add(1);
		queue.add(3);
		queue.add(5);

		System.out.println(queue.size());
		while (!queue.isEmpty()) {
			Integer current = queue.pop();
			System.out.println(current);
		}
	}

	private static class Queue<T> {
		private Node<T> head;

		public void add(T data) {
			Node<T> node = new Node<>(data);
			if (head == null) {
				head = node;
				return;
			}
			head.add(node);
		}

		public T pop() {
			if (head == null) {
				throw new NoSuchElementException();
			}
			Node<T> result = head;
			head = head.next;
			return result.data;
		}

		public int size() {
			return head.size();
		}

		public boolean isEmpty() {
			return head == null;
		}
	}

	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}

		public int size() {
			int base = 1;
			if(next == null){
				return base;
			}
			return base + next.size();
		}

		public void add(Node<T> node) {
			if (next == null) {
				next = node;
				return;
			}
			next.add(node);
		}
	}
}
