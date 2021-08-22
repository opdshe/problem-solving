package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 파일합치기 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int test = 0; test < testcase; test++) {
			int countOfFile = Integer.parseInt(br.readLine());
			int[] files = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.sorted()
					.toArray();
			System.out.println(getMinCost(files, countOfFile));
		}
	}

	private static int getMinCost(int[] files, int countOfFile) {
		int count = 0;
		int answer = 0;
		while (count <= countOfFile / 2) {
			int headIdx = 0;
			while (true) {
				if (headIdx >= countOfFile || files[headIdx] == 0) {
					break;
				}
				if (headIdx + 1 >= countOfFile || files[headIdx + 1] == 0) {
					files[headIdx / 2] = files[headIdx];
					files[headIdx] = 0;
				} else {
					int sum = files[headIdx] + files[headIdx + 1];
					answer += sum;
					files[headIdx] = 0;
					files[headIdx + 1] = 0;
					files[headIdx / 2] = sum;

				}
				headIdx += 2;
			}
			count++;
		}
		return answer;
	}
}
