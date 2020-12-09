package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_11055 {

	public static void main(String[] args) throws Exception{
		//dp 가장 큰 증가 부분 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int[] arr = new int[a];
		int[] dp = new int[a];
		StringTokenizer st;
		int index=0;
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			arr[index++] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for(int i=0;i<a;i++) {
			dp[i]=arr[i];
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i])
				dp[i] = Math.max(dp[i],dp[j]+arr[i]);
			}
			max = Math.max(dp[i], max);
		}
			
		System.out.println(max);
	}
	
}
