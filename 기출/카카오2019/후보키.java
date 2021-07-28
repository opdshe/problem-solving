package 기출.카카오2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 후보키 {
	private static List<Integer> answerDecimal = new ArrayList<>();

	public static void main(String[] args) {
		solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
	}

	public static int solution(String[][] relation) {
		int binaryLen = relation[0].length;
		for (int decimal = 1; decimal < Math.pow(2, relation[0].length); decimal++) {
			if(isAlreadyCandidates(decimal)){
				continue;
			}
			String binary = Integer.toBinaryString(decimal);
			binary = "0".repeat(binaryLen - binary.length()) + binary;

			List<Integer> checkIdxes = getCheckIdxes(binary);
			Set<String> set = new HashSet<>();
			for (String[] tuple : relation) {
				String collect = checkIdxes.stream()
						.map(idx -> tuple[idx])
						.collect(Collectors.joining());
				set.add(collect);
			}
			//슈퍼키 가능
			if (set.size() == relation.length) {
				answerDecimal.add(decimal);
			}
		}
		return answerDecimal.size();
	}

	private static boolean isAlreadyCandidates(int target) {
		for (Integer decimal : answerDecimal) {
			if ((decimal & target) == decimal) {
				return true;
			}
		}
		return false;
	}

	private static List<Integer> getCheckIdxes(String binary) {
		List<Integer> list = new ArrayList<>();
		for (int idx = 0; idx < binary.length(); idx++) {
			if (binary.charAt(idx) == '1') {
				list.add(idx);
			}
		}
		return list;
	}
}
