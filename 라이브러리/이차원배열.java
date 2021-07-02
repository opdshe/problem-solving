package 라이브러리;

public class 이차원배열 {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {0, 1, 1, 3},
                {1, 3, 2, 5},
                {4, 1, 2, 3},
                {1, 1, 1, 2},
        };
    }

    static int[][] rotate(int[][] origin) {
        int n = origin.length;
        int m = origin[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = origin[n - 1 - j][i];
            }
        }
        return rotate;
    }

    private static int[][] deepCopy(int[][] origin) {
        if (origin == null) return null;
        int[][] result = new int[origin.length][origin[0].length];

        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
        }
        return result;
    }
}

