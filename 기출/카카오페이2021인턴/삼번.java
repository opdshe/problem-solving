package 기출.카카오페이2021인턴;

public class 삼번 {
	public static void main(String[] args) {
		solution("abacabc", "acb");
	}
	public static int solution(String line1, String line2) {
		int offset = 0;
		String editedLine = getEdited(line2, offset);
		int count = 0;
		while (editedLine.length() <= line1.length()) {
			for (int start = 0; start + editedLine.length() <= line1.length(); start++) {
				boolean result = isOkay(line1.substring(start, start + editedLine.length()), editedLine);
				if(result){
					count++;
				}
			}
			offset++;
			editedLine = getEdited(line2, offset);
		}
		return count;
	}

	private static boolean isOkay(String origin, String editedLine) {
		for (int idx = 0; idx < origin.length(); idx++) {
			if(origin.charAt(idx) != editedLine.charAt(idx) && editedLine.charAt(idx) != '.'){
				return false;
			}
		}
		return true;
	}

	private static String getEdited(String origin, int offset) {
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < origin.length(); idx++) {
			sb.append(origin.charAt(idx));
			if (idx != origin.length() - 1) {
				sb.append(".".repeat(offset));
			}
		}
		return sb.toString();
	}
}
