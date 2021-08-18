package 투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문자열구분 {
	private static List<Piece> candidates = new ArrayList<>();

	public static void main(String[] args) {
		solution("a");
	}

	public static String[] solution(String s) {
		twoPointer(s);
		String[] answer = candidates.stream()
				.map(piece -> piece.content)
				.toArray(String[] ::new);
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	private static void twoPointer(String s){
		int leftStart = 0;
		int rightEnd = s.length(); //exclusive

		while (leftStart <= rightEnd) {
			for (int length = 1; length <= s.length(); length++) {
				String left = s.substring(leftStart, leftStart + length);
				String right = s.substring(rightEnd - length, rightEnd);
				if (left.equals(right)) {
					if (leftStart == rightEnd - length) {
						candidates.add(new Piece(left, true));
					} else {
						candidates.add(new Piece(left, false));
					}
					leftStart += length;
					rightEnd -= length;
					break;
				}
			}
		}

		for(int idx = candidates.size()-1; idx >= 0 ; idx--){
			Piece piece = candidates.get(idx);
			if(!piece.isDuplicated){
				candidates.add(piece);
			}
		}
	}

	private static class Piece {
		private String content;
		private boolean isDuplicated;

		public Piece(String content, boolean isDuplicated) {
			this.content = content;
			this.isDuplicated = isDuplicated;
		}
	}
}
