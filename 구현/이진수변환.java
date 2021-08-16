package 구현;

import java.util.Scanner;

public class 이진수변환 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		long target = Long.parseLong(scanner.nextLine());
		System.out.println(getBinaryNumber(target));
	}

	private static String getBinaryNumber(long origin) {
		StringBuilder binary = new StringBuilder();
		while (origin > 0) {
			binary.insert(0, origin % 2);
			origin /= 2;
		}
		return binary.toString();
	}
}
