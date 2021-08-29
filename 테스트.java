import java.util.*;

public class 테스트 {
	public static void main(String[] args) {
		Child child = (Child) new Parent();
		Parent parent = new Child();
	}

	private static class Child extends Parent {

	}

	private static class Parent {

	}
}
