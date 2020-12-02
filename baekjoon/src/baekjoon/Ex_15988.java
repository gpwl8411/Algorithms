package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_15988 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 1,2,3 더하기 3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		
		long mod = 1000000009;
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<dp.length;i++) {
			dp[i] = (dp[i-1]%mod+dp[i-2]%mod+dp[i-3]%mod)%mod;
		}
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
	
			System.out.println(dp[n]);
			
		}
	}

}
