package programers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class kakao18_cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cacheSize = 6;
		String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju","LA" };
		int answer = 0;

		ArrayList<String> a = new ArrayList<String>();
		String[] cache = new String[cacheSize];
		
		if(cacheSize==0){
			answer=cities.length*5;
		}

		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toLowerCase();
			if (a.contains(city)) {
				answer++;
				//int temp = a.indexOf(cities[i]);
				a.remove(city);
				a.add(city);
				continue;
			}
			if (a.size()<cacheSize) {
				a.add(city);
				answer += 5;
				continue;
			}
			a.remove(0);
			a.add(city);
			answer += 5;
		}
		System.out.println(answer);

	}

}
