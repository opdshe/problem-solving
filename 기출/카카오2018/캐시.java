package 기출.카카오2018;

import java.util.ArrayDeque;
import java.util.Queue;

public class 캐시 {
	public static void main(String[] args) {
		solution(0, new String[]{"daegu", "daegu"});
	}

	public static int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return cities.length * 5;
		}
		Queue<String> cache = new ArrayDeque<>();
		int answer = 0;
		for (String city : cities) {
			if (cache.isEmpty()) {
				cache.add(city.toLowerCase());
				answer += 5;
				continue;
			}
			if (cache.contains(city.toLowerCase())) {
				answer += 1;
				cache.remove(city.toLowerCase());
			} else {
				answer += 5;
				if (cache.size() >= cacheSize) {
					cache.poll();
				}
			}
			cache.add(city.toLowerCase());
		}
		return answer;
	}
}
