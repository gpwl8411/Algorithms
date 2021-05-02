package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_5569 {

	static final int MOD = 100000;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// dp 출근경로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][][][] dp = new int[h][w][2][2];// row,col,방향 동1 북0,회전 가능1 불가0

		for (int i = 0; i < h; i++)
			dp[i][0][0][1] = 1;
		for (int j = 0; j < w; j++)
			dp[0][j][1][1] = 1;

		for (int i = 1; i < h; i++) {
			for (int j = 1; j < w; j++) {
				//북
				dp[i][j][0][0] = dp[i - 1][j][1][1];
				dp[i][j][0][1] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1])%MOD;
				//동
				dp[i][j][1][0] = dp[i][j - 1][0][1];
				dp[i][j][1][1] = (dp[i][j - 1][1][0] + dp[i][j - 1][1][1])%MOD;
			}
		}
		int sum = 0 ;
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++)
				sum = (sum+dp[h-1][w-1][i][j])%MOD;
		}
		System.out.println(sum);
		
	}

}
