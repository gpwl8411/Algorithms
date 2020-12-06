package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_2193 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 이친수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[n+1][2];
		dp[1][1] = 1;
		if(n!=1)
			dp[2][0] = 1;
		
		for(int i=3;i<=n;i++) {
			dp[i][1] = dp[i-1][0];
			dp[i][0] = dp[i-1][1]+dp[i-1][0];
		}
		System.out.println(dp[n][0]+dp[n][1]);
	}

}
