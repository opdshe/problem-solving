package 기출.카카오2018;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 셔틀버스 {
	private static PriorityQueue<Crew> crews = new PriorityQueue<>(Comparator.comparing(crew -> crew.arriveAt));
	private static Queue<Bus> buses = new ArrayDeque<>();

	public static void main(String[] args) {
		String answer = solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"});
		System.out.println(answer);
	}

	public static String solution(int n, int t, int m, String[] timetable) {
		init(n, t, m, timetable);
		LocalTime answer = null;
		while (!buses.isEmpty()) {
			Bus bus = buses.poll();
			LocalTime last = null;
			int pass = 0;
			for (int i = 0; i < m; i++) {
				if (!crews.isEmpty()) {
					if (crews.peek().arriveAt.equals(bus.arriveAt) || crews.peek().arriveAt.isBefore(bus.arriveAt)) {
						pass++;
						last = crews.poll().arriveAt;
					}
				}
			}
			if (pass >= m) {
				answer = last.minusMinutes(1);
			} else {
				answer = bus.arriveAt;
			}
		}
		return answer.toString();
	}

	private static void init(int n, int t, int m, String[] timetable) {
		LocalTime start = LocalTime.of(9, 0);
		for (String arriveTime : timetable) {
			crews.add(new Crew(LocalTime.parse(arriveTime, DateTimeFormatter.ofPattern("HH:mm"))));
		}
		for (int offset = 0; offset < n; offset++) {
			LocalTime busArriveAt = start.plusMinutes((long) offset * t);
			buses.add(new Bus(busArriveAt));
		}
	}

	private static class Bus {
		private LocalTime arriveAt;

		public Bus(LocalTime arriveAt) {
			this.arriveAt = arriveAt;
		}
	}

	private static class Crew {
		private LocalTime arriveAt;

		public Crew(LocalTime arriveAt) {
			this.arriveAt = arriveAt;
		}
	}
}
