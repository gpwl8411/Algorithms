package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_2225 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 합분해
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		//n숫자를 k개로 만들수 있는 경우의 수
		long[][] dp = new long[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			dp[i][1]=1;
		}
		for(int i=1;i<=K;i++) {
			dp[0][i]=1;
		}
		for(int i = 1; i <=N; i++) { 
			for(int j = 2; j <=K; j++)
				dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000000; 
		}
		
		System.out.println(dp[N][K]%1000000000);
	}

}
