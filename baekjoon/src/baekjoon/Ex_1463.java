package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_1463 {

	public static void main(String[] args) throws Exception{
		//1만들기 DP
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			if(i==1) {
				dp[i]=0;
				continue;
			}
			if(i==2 || i==3) {
				dp[i]=1;
				continue;
			}
			if(i%6==0) {
				dp[i]=Math.min(dp[i/2]+1, dp[i/3]+1);
			}
			else if(i%2==0) {
				dp[i]=Math.min(dp[i-1]+1, dp[i/2]+1);
			}
			else if(i%3==0) {
				dp[i]=Math.min(dp[i-1]+1, dp[i/3]+1);
			}
			else {
				dp[i]=dp[i-1]+1;
			}
		}

			
		System.out.println(dp[n]);
	}

}
