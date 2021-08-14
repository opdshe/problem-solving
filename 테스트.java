import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class 테스트 {

	public static void main(String[] args) {
		GenericList<Child> childList= new GenericList<>();
		GenericList<Parent> parentList= new GenericList<>();
		parentList.add(new Child());
	}

	@FunctionalInterface
	private static interface Functional {
		int add(int a, int b);
	}

	private static class Apple {
		private String color;
		private int weight;
	}

	private static class Parent{

	}

	private static class Child extends Parent{

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
