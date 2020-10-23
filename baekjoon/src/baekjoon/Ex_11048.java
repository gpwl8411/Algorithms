package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_11048 {

	public static void main(String[] args) throws Exception{

		//DP 이동하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] maze = new int[n+1][m+1];
		int[][] dp = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				maze[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j], dp[i][j-1]))+maze[i][j];
			}
		}
		System.out.println(dp[n][m]);
		
	}

}
