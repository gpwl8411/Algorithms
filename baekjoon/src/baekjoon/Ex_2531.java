package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_2531 {

	public static void main(String[] args) throws Exception{

		//슬라이딩윈도우 회전초밥
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//접시수
		int d = Integer.parseInt(st.nextToken());//가짓수
		int k = Integer.parseInt(st.nextToken());//연속접수
		int c = Integer.parseInt(st.nextToken());//쿠폰
		
		int[] arr = new int[n];
		int[] visit = new int[d+1];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int total = 0;
		int max=0;
		for(int i=0;i<k;i++) {
			if(visit[arr[i]] == 0) total++;
				visit[arr[i]]++;
		}
		max = total;
		
		for(int i=1;i< n;i++) {
			if(max <= total) {
				if(visit[c]==0)
					max = total+1;
				else
					max = total;
			}
			visit[arr[i-1]]--;
			if(visit[arr[i-1]]==0) total--;
			
			if(visit[arr[(i+k-1)%n]]==0) total++;
			visit[arr[(i+k-1)%n]]++;
		}
		System.out.println(max);
	}

}
