package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex_12933 {
 
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//구현 오리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
	
		String quack = "quack";
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			int index = quack.indexOf(c)+1;
		
			if(index ==1 ) {		
				map.put(5, map.getOrDefault(5, 0)-1);
				if(map.get(5)<0)
					map.put(5, 0);
			}else {
				if(!map.containsKey(1) || !map.containsKey(index-1)|| map.get(index-1)==0) {
					System.out.println(-1);
					return;
				}
				map.put(index-1, map.get(index-1)-1);
			}
			map.put(index, map.getOrDefault(index, 0)+1);
		}
		for(Integer key : map.keySet()) {
			if(key!=5 && map.get(key) > 0) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(map.get(5));
		
	}

}
