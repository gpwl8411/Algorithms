package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_13398 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 연속합 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+2];
		st = new StringTokenizer(br.readLine());
		
		for(int i=2;i<=n+1;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[n+2][2];
		int max = Integer.MIN_VALUE;
		for(int i=2;i<=n+1;i++) {
			//제거하지 않을때
			dp[i][0] = Math.max(dp[i-1][0]+arr[i], arr[i]);
			//제거할 때
			dp[i][1] = Math.max(dp[i-2][0]+arr[i], dp[i-1][1]+arr[i]);
			
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		System.out.println(max);
		
		
	}

}
