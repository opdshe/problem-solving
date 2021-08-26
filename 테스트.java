import java.util.*;

public class 테스트 {
	public static void main(String[] args) {
		Apple a = new Apple("red", 5);
		Apple b = new Apple("red", 5);

		System.out.println("------before edit -------");
		System.out.println(a.equals(b));
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());

		b.weight = 10;
		System.out.println("------after edit -------");
		System.out.println(a.equals(b));
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
	}

	private static class Apple{
		private String color;
		private int weight;

		public Apple(String color, int weight) {
			this.color = color;
			this.weight = weight;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Apple apple = (Apple) o;
			return weight == apple.weight && Objects.equals(color, apple.color);
		}

		@Override
		public int hashCode() {
			return Objects.hash(color, weight);
		}
	}
}
