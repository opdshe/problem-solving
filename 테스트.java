import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class 테스트 {
	public static void main(String[] args) {
		GenericList<Integer> stringGenericList = new GenericList<Integer>();
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
