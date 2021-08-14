package 기출.토스2021하반기;

import java.util.*;
import java.util.stream.Collectors;

public class 이번 {
	private static Map<Integer, Integer> cache = new HashMap<>();
	private static List<List<Integer>> serverList;
	private static int serverIdx;

	public static int[][] solution(int servers, boolean sticky, int[] requests) {
		serverList = new ArrayList<>();
		for (int idx = 0; idx < servers; idx++) {
			serverList.add(new ArrayList<>());
		}
		for (int request : requests) {
			operateRequest(servers, request, sticky);
		}
		int[][] answer = new int[servers][];
		for (int idx = 0; idx < servers; idx++) {
			answer[idx] = serverList.get(idx).stream()
					.mapToInt(Integer::valueOf)
					.toArray();
		}
		return answer;
	}

	private static void operateRequest(int servers, int request, boolean sticky) {
		if (sticky) {
			if (cache.containsKey(request)) {
				Integer serverIdx = cache.get(request);
				serverList.get(serverIdx).add(request);
			} else {
				serverList.get(serverIdx).add(request);
				cache.put(request, serverIdx);
				serverIdx = (serverIdx + 1) % servers;
			}
		} else {
			serverList.get(serverIdx).add(request);
			serverIdx = (serverIdx + 1) % servers;
		}
	}
}

