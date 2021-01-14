package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Ex_1339 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//그리디알고리즘 단어 수학
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Alpha> q = new PriorityQueue<>();
		Map<String,Alpha> map = new HashMap<>();
		int sum=0;
		while(n-- >0) {
			String[] str = br.readLine().split("");
			for(int i=0;i<str.length;i++) {
				int pri = (int) Math.pow(10, str.length-i-1);
				if(map.containsKey(str[i])) {
					Alpha a = map.get(str[i]);		
					a.pri += pri;
					
				}else {
					map.put(str[i], new Alpha(str[i],pri));
				}
				
			}
		}
		for(String key : map.keySet()) {
			q.add(map.get(key));
		}
		int num = 9;
		while(!q.isEmpty()) {
			Alpha a = q.poll();
			System.out.println(a.alpha+" "+a.pri);
			sum+=num*a.pri;
			num--;
		}
		System.out.println(sum);
	}

}
class Alpha implements Comparable<Alpha>{
	String alpha;
	int pri;
	Alpha(String alpha,int pri){
		this.alpha = alpha;
		this.pri = pri;
	}
	public int compareTo(Alpha a) {
		if(pri < a.pri)
			return 1;
		else if(pri == a.pri) {

			return 0;
		}
		return -1;
	}
}
