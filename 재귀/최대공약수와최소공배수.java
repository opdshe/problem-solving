package 재귀;

import java.util.Scanner;

public class 최대공약수와최소공배수 {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		long a = scanner.nextLong();
		long b = scanner.nextLong();
		long GCD = getGCD(Math.max(a, b), Math.min(a, b));
		long LCM = getLCM(Math.max(a, b), Math.min(a, b));
		System.out.println(GCD);
		System.out.println(LCM);

	}

	private static long getLCM(long big, long small) {
		return (big * small) / getGCD(big, small);
	}

	private static long getGCD(long big, long small) {
		if (small == 0) {
			return big;
		}
		return getGCD(small, big % small);
	}
}
