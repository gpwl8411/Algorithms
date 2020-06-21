package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class EX_17140 {
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1;
		int c = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		map = new int[101][101];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int rCnt = 3;
		int cCnt = 3;
		int time = 0;
		while (true) {
			if (map[r][c] == k || time==101)
				break;
			if (rCnt >= cCnt)
				cCnt = rSort(rCnt,cCnt);
			else
				rCnt = cSort(rCnt,cCnt);
			
			time++;
		}
		if(time==101) time = -1;
		System.out.println(time);

	}

	public static int rSort(int row, int col) {
		int cCnt=0;
		HashMap<Integer, Integer> h;
		for (int i = 0; i < row; i++) {
			h = new HashMap<>();
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 0)
					continue;
				h.put(map[i][j], h.getOrDefault(map[i][j], 0) + 1);
				map[i][j]=0;
			}
			List<Entry<Integer, Integer>> listEntries = new ArrayList<Entry<Integer, Integer>>(h.entrySet());
			Collections.sort(listEntries,new MapSorting());
			int size =listEntries.size()*2;
			if(size>100) size=100;
			for(int k=0;k<size;k+=2){
				map[i][k] = listEntries.get(k/2).getKey();
				map[i][k+1] = listEntries.get(k/2).getValue();
			}
			cCnt= Math.max(cCnt, size);
		}
		return cCnt;
		
	}

	public static int cSort(int row, int col) {
		HashMap<Integer, Integer> h;
		int rCnt=0;
		for (int i = 0; i < col; i++) {
			h = new HashMap<>();
			for (int j = 0; j < row; j++) {
				if (map[j][i] == 0)
					continue;
				h.put(map[j][i], h.getOrDefault(map[j][i], 0) + 1);
				map[j][i]=0;

			}
			List<Entry<Integer, Integer>> listEntries = new ArrayList<Entry<Integer, Integer>>(h.entrySet());
			Collections.sort(listEntries,new MapSorting());
			int size =listEntries.size()*2;
			if(size>100) size=100;
			for(int k=0;k<size;k+=2){
				map[k][i] = listEntries.get(k/2).getKey();
				map[k+1][i] = listEntries.get(k/2).getValue();
			}
			rCnt = Math.max(rCnt, size);
		}
		return rCnt;
	}
	

}
class MapSorting implements Comparator<Entry<Integer, Integer>>{
	public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
		// 오름 차순 정렬
		if(obj1.getValue()==obj2.getValue()){
			return obj1.getKey().compareTo(obj2.getKey());
		}
		return obj1.getValue().compareTo(obj2.getValue());
	}
}
