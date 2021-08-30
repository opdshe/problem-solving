package 알고리즘;

public class 최대공약수최소공배수 {
	public static void main(String[] args) {
		System.out.println(getGCM(24, 16));
	}

	private static int getGCM(int bigger, int smaller) {
		return (bigger * smaller) /  getLCM(bigger, smaller);
	}

	private static int getLCM(int bigger, int smaller) {
		if (smaller == 0) {
			return bigger;
		}
		return getLCM(smaller, bigger % smaller);
	}
}
