package programers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Kakao18_Bus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// kakao 18 블라인드 셔틀버스
		int n = 2;
		int t = 10;
		int m = 2;
		String[] timetable = { "09:10", "09:09", "08:00" };
		int answer = 0;
//		Map<Integer,List<Integer>> map = new HashMap<>();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int departT = 9*60;
		List<Integer>[] list = new List[n];
		for (int i = 0; i < timetable.length; i++) {
			int hh = Integer.parseInt(timetable[i].split(":")[0]);
			int mm = Integer.parseInt(timetable[i].split(":")[1]);
			int time = hh*60 + mm;
			
			q.add(time);
			
		}
		
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
			while(!q.isEmpty()) {
				int arrivedT = q.poll();
				if(arrivedT <= departT && list[i].size() < m) {
					list[i].add(arrivedT);
				}
				else {
					q.add(arrivedT);
					break;
				}
				answer = arrivedT-1;
			}
			departT += t;
			

		}
		if(list[n-1].size() < m) {
			answer = departT - t;
		}
		String hh = String.format("%02d",answer/60);
		String mm = String.format("%02d",answer%60);
		System.out.println(hh+":"+mm);
		
	}

}
