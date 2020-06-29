package programers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

	public static void main(String[] args) {

		int[][] jobs = { { 0, 9 }, { 0, 4 }, { 0, 5 },{0,7} ,{0,3}};

		int time = 0;
		int answer = 0;
		int finishT = 0;
		int cnt = 0;
		PriorityQueue<Task> minHeap = new PriorityQueue<>();

		while (cnt < jobs.length) {
			for(int i=0;i<jobs.length;i++){
				if (time == jobs[i][0]) {
					minHeap.add(new Task(jobs[i][0], jobs[i][1]));
				}
			}
			if ((time >= finishT) && !minHeap.isEmpty()) {
				Task task = minHeap.poll();
				answer += time - task.start + task.executeT;
				finishT = time + task.executeT;
				cnt++;
			}
			time++;
		}
		System.out.println(answer / jobs.length);
	}

}

class Task implements Comparable<Task> {
	int start;
	int executeT;

	Task(int start, int executeT) {
		this.start = start;
		this.executeT = executeT;
	}

	@Override
	public int compareTo(Task t) {
		if (this.executeT < t.executeT)
			return -1; // 오름차순
		else if (this.executeT == t.executeT) {
			if (this.start < t.start)
				return -1;
		}
		return 1;
	}
}
