package 그래프.최단경로.다익스트라;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 효율적인해킹 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static List<Integer>[] adjacent;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		int[] input = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::valueOf)
				.toArray();
		adjacent = new ArrayList[input[0] + 1];
		dp = new int[input[0] + 1];
		Arrays.fill(dp, -1);
		for (int idx = 1; idx <= input[0]; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int i = 0; i < input[1]; i++) {
			int[] hackingInfo = Arrays.stream(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			adjacent[hackingInfo[1]].add(hackingInfo[0]);
		}
		int max = 0;
		List<Integer> candidates = new ArrayList<>();
		for (int idx = 1; idx <= input[0]; idx++) {
			boolean[] visited = new boolean[input[0] + 1];
			int maxDistance = getMaxDistance(visited, idx);
			if (maxDistance > max) {
				max = maxDistance;
				candidates = new ArrayList<>();
				candidates.add(idx);
			} else if (maxDistance == max) {
				candidates.add(idx);
			}
		}
		candidates.forEach((idx) -> {
			try {
				bw.write(idx+ " ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		bw.flush();
		bw.close();
	}

	private static int getMaxDistance(boolean[] visited, int current) {
		if (dp[current] != -1) {
			return dp[current];
		}
		int sum = 1;
		visited[current] = true;
		for (Integer adj : adjacent[current]) {
			if (!visited[adj]) {
				visited[adj] = true;
				sum = Math.max(sum, getMaxDistance(visited, adj) + 1);
			}
		}
		return dp[current] = sum;
	}
}
