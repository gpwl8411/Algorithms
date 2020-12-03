package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_15990 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//dp 1,2,3 더하기 5
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long mod = 1_000_000_009;
		long[][] dp = new long[100001][4];
		
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i=4;i<dp.length;i++) {
			//1을 뒤에 붙일 경우 뒤에 2나 3으로끝나야 붙일 수 있음
			dp[i][1] = (dp[i-1][2]+dp[i-1][3])%mod;
			dp[i][2] = (dp[i-2][1]+dp[i-2][3])%mod;
			dp[i][3] = (dp[i-3][1]+dp[i-3][2])%mod;
		}
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println((dp[n][1]+dp[n][2]+dp[n][3])%mod);
		}
		
		
	}

}
