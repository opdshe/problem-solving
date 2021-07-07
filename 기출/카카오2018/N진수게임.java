package 기출.카카오2018;

public class N진수게임 {
	static char[] characters = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'A', 'B', 'C', 'D', 'E', 'F'};

	public static void main(String[] args) {
		solution(16,16,2,1);
	}

	public static String solution(int n, int t, int m, int p) {
		int lastIdx = p - 1 + ((t - 1) * m);
		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		int number = 0;
		while (stringBuilder.length() <= lastIdx) {
			stringBuilder.append(getNNumber(n, number++));
		}
		for (int idx = p - 1; idx <= lastIdx; idx += m) {
			answer.append(stringBuilder.charAt(idx));
		}
		return answer.toString();
	}

	private static String getNNumber(int n, int target) {
		StringBuilder answer = new StringBuilder();
		while (target / n != 0) {
			int remainder = target % n;
			answer.insert(0, characters[remainder]);
			target = target / n;
		}
		answer.insert(0, characters[target % n]);
		return answer.toString();
	}
}
