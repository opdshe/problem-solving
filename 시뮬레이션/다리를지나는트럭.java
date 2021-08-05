package 시뮬레이션;

import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를지나는트럭 {
	public static void main(String[] args) {
		solution(100,100,new int[]{10});
	}
	public static int solution(int bridge_length, int maxWeight, int[] truck_weights) {
		Queue<Truck> waitingQueue = new ArrayDeque<>();
		Queue<Truck> onRoad = new ArrayDeque<>();

		int pass = 0;
		int currentWeight = 0;
		int time = 0;

		for(int weight : truck_weights){
			waitingQueue.add(new Truck(weight));
		}

		while(pass < truck_weights.length){
			for(Truck truck : onRoad){
				truck.remainTime--;
			}
			while(!onRoad.isEmpty() && onRoad.peek().remainTime == 0){
				Truck remove = onRoad.poll();
				currentWeight -= remove.weight;
				pass++;
			}
			if(!waitingQueue.isEmpty() && currentWeight + waitingQueue.peek().weight <= maxWeight){
				Truck truck = waitingQueue.poll();
				truck.setRemainTime(bridge_length);
				onRoad.add(truck);
				currentWeight += truck.weight;
			}
			time++;
		}
		System.out.println(time);
		return time;
	}

	private static class Truck{
		private int remainTime;
		private int weight;

		public Truck(int weight) {
			this.weight = weight;
		}

		public void setRemainTime(int remainTime){
			this.remainTime = remainTime;
		}
	}
}
