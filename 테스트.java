import java.util.*;

public class 테스트 {
	private static Object lock = new Object();

	public static void main(String[] args) {

	}

	@FunctionalInterface
	private static interface Functional {
		int add(int a, int b);
	}

	private static class Apple {
		private String color;
		private int weight;
	}

	private static class Parent {

	}

	private static class Child extends Parent {

	}

	private static <T> String genericMethod(T t) {
		return t.getClass().toString();
	}

	private static class GenericList<T extends Parent> {
		private List<T> list = new ArrayList<>();

		public List<T> getList() {
			return list;
		}

		public void add(T t) {
			list.add(t);
		}
	}
}
