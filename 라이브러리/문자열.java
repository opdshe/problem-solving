package 라이브러리;

public class 문자열 {
	public static void main(String[] args) {
		System.out.println(isNumeric("123"));
		System.out.println(isNumeric("12삼"));
		System.out.println("=====================");
		System.out.println(isAlphabetic("asdf"));
		System.out.println(isAlphabetic("asdf123"));
		System.out.println("=====================");
		System.out.println(isSpecific("a"));
		System.out.println(isSpecific("ac"));
		System.out.println(isSpecific("ac*"));

	}

	//숫자만
	private static boolean isNumeric(String target) {
		return target.matches("^[0-9]*$");
	}

	//알파벳만
	private static boolean isAlphabetic(String target) {
		return target.matches("^[a-zA-Z]*$");
	}

	//특정문자로만 이루어져있는지
	private static boolean isSpecific(String target) {
		return target.matches("^[abcd]*$");
	}

	//특정 문자 제외한 문자 검열 (abcd를 제외한 모든 문자 제거)
	private static String getNewString(String origin){
		return origin.replaceAll("[^abcd]", "");
	}

}
