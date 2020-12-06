package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_11057 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 오르막 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 10007;
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][10];
		
		for(int i=0;i<=9;i++) {
			dp[1][i]=1;
		}
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {				
				for(int k=j;k>=0;k--) {
					dp[i][j] += dp[i-1][k]%mod;
				}
			}
		}
		long answer = 0;
		for(int i=0;i<=9;i++) {
			answer = (answer+dp[n][i])%mod;
		}
		System.out.println(answer);
	}
}
