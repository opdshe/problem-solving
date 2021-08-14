package 기출.토스2021하반기;

public class 삼번 {
	public static void main(String[] args) {
		solution("25,000");
	}
	public static boolean solution(String amountText) {
		if (!isRightCharacters(amountText)) {
			return false;
		}
		if (!isNotFirstCharacterZero(amountText)) {
			return false;
		}

		return isRightComma(amountText);
	}

	private static boolean isRightCharacters(String amountText) {
		return amountText.matches("^[0-9,]*$");
	}

	private static boolean isNotFirstCharacterZero(String amountText) {
		if (amountText.length() == 1 && amountText.charAt(0) == '0') {
			return true;
		}
		return amountText.charAt(0) != '0';
	}

	private static boolean isRightComma(String amountText) {
		if (!amountText.contains(",")) {
			return true;
		}
		if(amountText.charAt(0) == ',' || amountText.charAt(amountText.length()-1) ==','){
			return false;
		}
		int count = 0;
		for (int idx = amountText.length() - 1; idx >= 0; idx--) {
			char current = amountText.charAt(idx);
			if (current != ',') {
				if (count < 3) {
					count++;
				} else if (count == 3) {
					return false;
				}
			} else {
				//comma 인 경우
				if (count == 3) {
					count = 0;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
