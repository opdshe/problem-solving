package 기출.토스2021하반기;

public class 사번 {
	private static final String ERROR = "ERROR";
	private static int M;
	private static int N;
	private static StringBuilder answer = new StringBuilder();
	private static int day;
	private static int count;
	private static boolean negative;

	public static void main(String[] args) {
		solution("1 3\nSHOW\nNEXT\nEXIT");
	}

	public static String solution(String input) {
		String[] orders = input.split("\n");
		for (String order : orders) {
			if(!operate(order)){
				break;
			}
		}
		System.out.println(answer.toString());
		return answer.toString();
	}

	private static boolean operate(String order) {
		if (Character.isDigit(order.charAt(0))) {
			String[] info = order.split(" ");
			M = Integer.parseInt(info[0]);
			N = Integer.parseInt(info[1]);
			answer.append(order).append("\n");
			return true;
		}
		/*if (day >= M) {
			answer.append(ERROR);
			return true;
		}*/
		if (order.equals("SHOW")) {
			if (negative) {
				if (day <= M){
					answer.append("0\n");
				} else {
					answer.append("1\n");
				}
			} else {
				if (count < N) {
					count++;
					answer.append("1\n");
				} else {
					if(day <= M){
						answer.append("0\n");
					} else {
						answer.append("1\n");
					}
				}
			}
		} else if (order.equals("NEGATIVE")) {
			answer.append("0\n");
			negative = true;
		} else if (order.equals("NEXT")) {
			day++;
			answer.append("-\n");
		} else if (order.equals("EXIT")) {
			answer.append("BYE");
			return false;
		} else {
			answer.append(ERROR + "\n");
			//에러 출력
		}
		return true;
	}
}
