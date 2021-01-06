package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex_15989 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// dp 조합론 1,2,3더하기 4
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[10001][4];
			
			dp[1][1]=1;
	        dp[1][2]=0;
	        dp[1][3]=0;
	        
	        dp[2][1]=1;
	        dp[2][2]=1;
	        dp[2][3]=0;
	        
	        dp[3][1]=1;
	        dp[3][2]=1;
	        dp[3][3]=1;
	        
	        for(int i=4; i<=n; i++) {
	            dp[i][1] = dp[i-1][1];
	            dp[i][2] = dp[i-2][1]+dp[i-2][2];
	            dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
	        }
	        int sum = dp[n][1]+dp[n][2]+dp[n][3];
	        sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
}