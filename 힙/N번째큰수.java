package 힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N번째큰수 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

	public static void main(String[] args) throws IOException {
		int size = Integer.parseInt(br.readLine());
		int[][] board = new int[size][size];
		for (int row = 0; row < size; row++) {
			board[row] = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::valueOf)
					.toArray();
		}
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				queue.add(board[row][column]);
			}
		}
		int answer = -1;
		int count = 0;
		while (count < size) {
			answer = queue.poll();
			count++;
		}
		System.out.println(answer);
	}
}
