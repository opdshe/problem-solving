package 라이브러리;

public class 진수변환 {
    static char[] characters = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};

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
