package 알고리즘;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 최소공통조상 {
	private static Map<Integer, List<Integer>> tree = new HashMap<>();

	static {
		tree.put(1, Arrays.asList(2, 3));
		tree.put(2, Arrays.asList(4, 5));
		tree.put(3, Arrays.asList(6, 7));
	}

	public static void main(String[] args) {
		int[] depth = new int[]{0, 0, 1, 1, 2, 2, 2, 2};
		int[] parent = new int[]{0, 0, 1, 1, 2 ,2 ,3 ,3};

		System.out.println(findLCA(depth, parent, 1, 3));
	}

	private static int findLCA(int[] depth, int[] parent, int a, int b) {
		while (true) {
			if (depth[a] == depth[b]) {
				if (parent[a] == parent[b]) {
					if(a == b){
						return a;
					}
					return parent[a];
				} else {
					a = parent[a];
					b = parent[b];
				}
			} else {
				if (depth[a] > depth[b]) {
					a = parent[a];
				} else {
					b = parent[b];
				}
			}
		}
	}
}
