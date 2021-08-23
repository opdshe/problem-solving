package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 이분그래프 {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static boolean answer;

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for (int test = 0; test < testcase; test++) {
			String[] input = br.readLine().split(" ");
			List<Integer>[] adjacent = getAdjacentList(Integer.parseInt(input[0] + 1));
			for (int edge = 0; edge < Integer.parseInt(input[1]); edge++) {
				String[] edgeInfo = br.readLine().split(" ");
				adjacent[Integer.parseInt(edgeInfo[0])].add(Integer.parseInt(edgeInfo[1]));
				adjacent[Integer.parseInt(edgeInfo[1])].add(Integer.parseInt(edgeInfo[0]));
			}
			int[] flags = new int[Integer.parseInt(input[0]) + 1];
			answer = true;
			for(int idx = 1 ; idx <= Integer.parseInt(input[0]); idx++){
				if(flags[idx] == 0){
					dfs(adjacent, idx, flags, 1);
				}
			}
			System.out.println(answer ? "YES" : "NO");
		}
	}

	private static void dfs(List<Integer>[] adjacent, int current, int[] flags, int prev) {
		if (!answer) {
			return;
		}
		int currentFlag = -prev;
		flags[current] = currentFlag;
		for (Integer adj : adjacent[current]) {
			if (flags[adj] == 0) {
				dfs(adjacent, adj, flags, currentFlag);
			} else {
				if (flags[adj] == currentFlag) {
					answer = false;
					return;
				}
			}
		}
	}

	private static List<Integer>[] getAdjacentList(int vertex) {
		List<Integer>[] adjacent = new ArrayList[vertex + 1];
		for (int idx = 1; idx <= vertex; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		return adjacent;
	}
}
