package 기출.카카오2021;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class 광고삽입 {
	private static Queue<Player> playerQueue = new PriorityQueue<>(Comparator.comparing(player -> player.end));
	private static LocalTime adv;

	public static void main(String[] args) {
		solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		adv = LocalTime.parse(adv_time, DateTimeFormatter.ofPattern("HH:mm:ss"));
		for (String log : logs) {
			String[] split = log.split("-");
			playerQueue.add(new Player(split[0], split[1]));
		}
		int sec = adv.toSecondOfDay();
		long maxPlayTime = 0;
		while (!playerQueue.isEmpty()) {
			Player head = playerQueue.peek();
			LocalTime advStart = head.end.minusSeconds(sec);
			long playTime = 0;
			while (!playerQueue.isEmpty() && playerQueue.peek().end.equals(head.end)) {
				Player current = playerQueue.poll();
				playTime += getPlayTime(advStart, current);
				maxPlayTime = Math.max(maxPlayTime, playTime);
			}
		}
		return answer;
	}

	private static long getPlayTime(LocalTime advStart, Player player) {
		if (player.start.isBefore(advStart) || player.start.equals(advStart)) {
			return adv.toSecondOfDay();
		} else {
			return player.end.minusSeconds(player.start.toSecondOfDay()).toSecondOfDay();
		}
	}

	private static class Player {
		private LocalTime start;
		private LocalTime end;

		public Player(String start, String end) {
			this.start = LocalTime.parse(start, DateTimeFormatter.ofPattern("HH:mm:ss"));
			this.end = LocalTime.parse(end, DateTimeFormatter.ofPattern("HH:mm:ss"));
		}
	}
}
