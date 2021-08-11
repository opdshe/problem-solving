import java.util.*;

public class 테스트 {
	public static void main(String[] args) {
		Stack<Integer> head = new Stack<>();
		Stack<Integer> tail = new Stack<>();
		int[] numbers = new int[]{2, 5, 3, 4, 6, 4, 6};

		for (int number : numbers) {
			head.push(number);
		}
		while (!head.isEmpty()) {
			tail.push(head.pop());
		}
		while (!tail.isEmpty()) {
			System.out.println(tail.pop());
		}
	}

	private static <T> String genericMethod(T t) {
		return t.getClass().toString();
	}

	private static class GenericList<T extends Number> {
		private List<T> list = new ArrayList<>();

		public List<T> getList() {
			return list;
		}

		public void add(T t) {
			list.add(t);
		}
	}
}
