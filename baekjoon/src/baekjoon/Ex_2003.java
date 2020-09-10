package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_2003 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		int s=0;
		int e=0;
		int cnt=0;
		int sum=0;
		while(true) {
			if(sum >= m) sum-=arr[s++];
			else if(e>=n) break;
			else sum += arr[e++];
			if(sum==m) cnt++;
		}
		System.out.println(cnt);
	}

}
