package programers;

import java.util.ArrayList;
import java.util.HashMap;

public class Camouflage {

//	static int answer = 0;
//	static HashMap<String, ArrayList<String>> map;
	public static void main(String[] args) {
		String[][] clothes = { { "crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face" } };
		int answer=1;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			ArrayList<String> list;
			if (map.containsKey(clothes[i][1])) {
				list = map.get(clothes[i][1]);

			} else {
				list = new ArrayList<>();
			}
			list.add(clothes[i][0]);
			map.put(clothes[i][1], list);
		}
        for(String key : map.keySet()){
            answer *= (map.get(key).size()+1);
        }
        System.out.println(answer-1);
		/**
		 * 아래에는 시간초과 난 코드
		 */
//		map = new HashMap<>();
//		for (int i = 0; i < clothes.length; i++) {
//			ArrayList<String> list;
//			if (map.containsKey(clothes[i][1])) {
//				list = map.get(clothes[i][1]);
//
//			} else {
//				list = new ArrayList<>();
//			}
//			list.add(clothes[i][0]);
//			map.put(clothes[i][1], list);
//		}
//	        boolean[] visited = new boolean[map.keySet().size()];
//	        String[] keys = new String[map.keySet().size()];
//	        int index=0;
//	        for(String key : map.keySet()) {
//	        	keys[index++] = key;
//	        }
//	        for (int i = 1; i <= map.keySet().size(); i++) {
//	            combination(keys, visited, 0, map.keySet().size(), i);
//	        }
//
//		System.out.println(answer);
//
//	}
//	static void combination(String[] keys, boolean[] visited, int start, int n, int r) {
//	    if(r == 0) {
//	    	answer++;
//	        return;
//	    } 
//	    for(int i=start; i<n; i++) {
//	        visited[i] = true;
//	        String key = keys[i];
//	        for(int j=0;j<map.get(key).size();j++) {
//	        	combination(keys, visited, i + 1, n, r - 1);	        	
//	        }
//	        	
//	        visited[i] = false;
//	    }
		
		
	}
	


}
