package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_21317 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 징검다리 건너기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] one = new int[n];
		int[] two = new int[n];
		int[][] dp = new int[2][n+4]; //매우 큰점프 사용 1 , 사용안함 0
		StringTokenizer st;
		for(int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			one[i] = Integer.parseInt(st.nextToken());
			two[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		
		Arrays.fill(dp[0], Integer.MAX_VALUE);
		Arrays.fill(dp[1], Integer.MAX_VALUE);
		dp[0][1] = 0;
		dp[1][1] = 0;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<2;j++) {
				dp[j][i+1] = Math.min(dp[j][i+1],dp[j][i]+one[i]);
				dp[j][i+2] = Math.min(dp[j][i+2],dp[j][i]+two[i]);
			}
			dp[1][i+3] = Math.min(dp[1][i+3],dp[0][i]+k);
		}
		
		System.out.println(Math.min(dp[0][n], dp[1][n]));
		
	}

}
