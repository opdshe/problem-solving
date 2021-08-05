package 그리디;

import java.util.*;

public class 큰수만들기 {
	public static void main(String[] args) {
		solution("1924", 2);
	}
	public static String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		int targetLength = number.length() - k;
		Deque<Integer> deque = new ArrayDeque<>();
		for (int idx = 0; idx < number.length(); idx++) {
			int current = Character.getNumericValue(number.charAt(idx));
			//나보다 작은애들 지워도 충분히 원하는 길이 만들 수 있으면 삭제
			while (!deque.isEmpty() && deque.peekLast() < current &&
					deque.size() + (number.length() - 1 - idx) >= targetLength) {
				deque.pollLast();
			}
			deque.addLast(current);
		}
		for(int i = 0 ; i < targetLength; i++){
			answer.append(deque.pollFirst());
		}
		return answer.toString();
	}
}