package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Greedy_ConnectIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//그리디 섬 연결하기
		int n=5;
		int[][] costs= {{0, 1, 1}, {2, 3, 1}, {3, 4, 2}, {1, 2, 2}, {0, 4, 100}};
		
		Arrays.sort(costs, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	return o1[2] - o2[2];
		    }
		});
		
		int answer=0;
		int[] linked = new int[n+1];
		int key=1;
		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int i=0;i<costs.length;i++) {
			if(linked[costs[i][0]]==0 && linked[costs[i][1]]==0) {
				map.put(key, new ArrayList<>());
				map.get(key).add(costs[i][0]);
				map.get(key).add(costs[i][1]);
				linked[costs[i][0]]=key;
				linked[costs[i][1]]=key;
				answer += costs[i][2];
				key++;
			}
			else if(linked[costs[i][0]]==0 || linked[costs[i][1]]==0) {
				if(linked[costs[i][0]]==0) {
					map.get(linked[costs[i][1]]).add(costs[i][0]);
					linked[costs[i][0]]=linked[costs[i][1]];
				}else {
					map.get(linked[costs[i][0]]).add(costs[i][1]);
					linked[costs[i][1]]=linked[costs[i][0]];
				}
				answer+=costs[i][2];
			}
			else if(linked[costs[i][0]] != linked[costs[i][1]]) {
				int min = Math.min(linked[costs[i][0]], linked[costs[i][1]]);
				int max = Math.max(linked[costs[i][0]], linked[costs[i][1]]);
				for(int j : map.get(max)) {
					map.get(min).add(j);
					linked[j]=min;
				}
				map.get(max).clear();
				answer += costs[i][2];
				if(map.get(min).size()==n)
					break;
			}
		}
		System.out.println(answer);
	}

}
