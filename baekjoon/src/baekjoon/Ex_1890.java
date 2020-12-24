package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_1890 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 점프
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		long[][] dp = new long[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				//왼쪽
				for(int k=0;k<=9;k++) {
					if(j-k < 0 )
						break;
					if(map[i][j-k] == k) {
						dp[i][j] += dp[i][j-k];
					}
				}
				//위쪽
				for(int k=1;k<=9;k++) {
					if(i-k < 0 )
						break;
					if(map[i-k][j] == k) {
						dp[i][j] += dp[i-k][j];
					}
				}
			}
		}
		System.out.println(dp[n-1][n-1]);
		
		
	}

}
