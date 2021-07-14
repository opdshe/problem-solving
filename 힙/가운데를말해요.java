package 힙;

import java.io.*;
import java.util.*;

public class 가운데를말해요 {
	private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int countOfNumber = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < countOfNumber; i++) {
			int number = Integer.parseInt(bf.readLine());
			if (maxHeap.size() == minHeap.size()) {
				maxHeap.add(number);
			} else {
				minHeap.add(number);
			}
			if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				Integer max = maxHeap.poll();
				Integer min = minHeap.poll();
				maxHeap.add(min);
				minHeap.add(max);
			}
			answer.add(maxHeap.peek());
		}
		answer.forEach(a-> {
			try {
				bw.write(String.valueOf(a));
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		bw.flush();
	}

	/** 밑에는 이분탐색 O(logN) **/
	/*
	public static void main(String[] args) throws IOException {
		int countOfNumbers = Integer.parseInt(bf.readLine());
		List<Integer> numbers = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();
		for (int idx = 0; idx < countOfNumbers; idx++) {
			int number = Integer.parseInt(bf.readLine());
			int position = Collections.binarySearch(numbers, number);
			if (position < 0) {
				position = (-position) - 1;
			}
			numbers.add(position, number);
			answer.add(numbers.get((numbers.size() - 1) / 2));
		}
		answer.forEach(a-> {
			try {
				bw.write(String.valueOf(a));
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		bw.flush();
	}*/
}
