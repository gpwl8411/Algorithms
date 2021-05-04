package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex_20442 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//그리디/투포인터 ㅋㅋ루ㅋㅋ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] numK = new int[s.length()];
		int ans = 0;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(i==0) {
				if(c=='K')
					numK[i]=1;
				else
					q.add(i);
				continue;
			}
			if(c=='K') {
				numK[i] = numK[i-1]+1;
			}else {
				numK[i] = numK[i-1];
				q.add(i);
			}
		}
		
		ans = q.size(); 
		while(!q.isEmpty()) {
			int idx = q.poll();
			int size = Math.min(numK[idx], numK[s.length()-1]-numK[idx]);
			ans = Math.max(ans, size*2+1);
		}
		System.out.println(ans);
	}

}
