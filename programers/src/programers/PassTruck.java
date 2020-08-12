package programers;

import java.util.LinkedList;
import java.util.Queue;

public class PassTruck {

	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int time = 0;
		int bridgeW = 0;
		int[] truck_weights = { 7, 4, 5, 6 };
		Queue<Truck> watingQ = new LinkedList<>();
		Queue<Truck> bridgeQ = new LinkedList<>();

		for (int i = 0; i < truck_weights.length; i++) {
			watingQ.add(new Truck(truck_weights[i], 0));
		}
		while (!bridgeQ.isEmpty() || !watingQ.isEmpty()) {
			time++;
			if (!bridgeQ.isEmpty() && time - bridgeQ.peek().startT == bridge_length) {
				Truck t = bridgeQ.poll();
				bridgeW -= t.w;
			}
			if (!watingQ.isEmpty() && bridgeQ.size() < bridge_length) {
				if (watingQ.peek().w + bridgeW <= weight) {
					Truck t = watingQ.poll();
					t.startT = time;
					bridgeQ.add(t);
					bridgeW += t.w;
				}
			}

		}
		System.out.println(time);
	}

}

class Truck {
	int w;
	int startT;

	Truck(int w, int startT) {
		this.w = w;
		this.startT = startT;
	}

}
