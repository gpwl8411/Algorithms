package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_10844 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 쉬운 계단 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int mod = 1_000_000_000;
		long[][] dp = new long[101][10];
		
		for(int i=1;i<=9;i++) {
			dp[1][i] = 1;
		}
		for(int i=2;i<101;i++) {
			for(int j=0;j<=9;j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][j+1]%mod;					
				}
				else if(j==9) {
					dp[i][j] = dp[i-1][j-1]%mod;
				}
				else {
					dp[i][j] += dp[i-1][j-1]%mod;
					dp[i][j] += dp[i-1][j+1]%mod;					
				}
			}
		}
		long answer = 0;
		for(int i=0;i<=9;i++) {
			answer=(answer+dp[n][i])%mod;
		}
		System.out.println(answer%mod);
	}

}
