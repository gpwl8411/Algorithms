package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ex_16472 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//고양이 투포인터
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("");
		
		int s=0;
		int e=0;
		int max=0;
		if(n>=str.length) {
			System.out.println(str.length);
			return;
		}
		Map<String,Integer> map = new HashMap<>();
		int preS = s;
		while(s<=e && e < str.length) {
			if((s!=e || e==0) && preS==s)
				map.put(str[e], map.getOrDefault(str[e], 0) + 1);
			
			if(map.size() <= n) {
				max = Math.max(max, e-s+1);
				e++;
				preS = s;
			}
			else {
				int num = map.get(str[s])-1;
				if(num== 0)
					map.remove(str[s]);
				else
					map.put(str[s], num);
				s++;
			}
		}
		System.out.println(max);
	}

}
