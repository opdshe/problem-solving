import java.util.*;

public class 테스트 {
	private static final Object lock = new Object();

	public static void main(String[] args) throws CloneNotSupportedException {
		double pi = 3.14152;
		System.out.println(Math.round(pi * 100) / 100.0);
		System.out.println(Math.ceil(pi * 100) / 100.0);
		System.out.println(Math.floor(pi *100) / 100.0);
	}

	private static class Test {
		private int value;
	}

	private static class Edge {
	}

	private static <T> String genericMethod(T t) {
		return t.getClass().toString();
	}

	private static class GenericList<T> {
		private List<T> list = new ArrayList<>();

		public List<T> getList() {
			return list;
		}

		public void add(T t) {
			list.add(t);
		}
	}
}
