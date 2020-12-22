package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_9465 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 스티커
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n];
			for(int i=0;i<2;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//위를 선택, 아래를 선택
			int[][] dp = new int[2][n];
			int max=0;
			for(int i=0;i<n;i++) {
				if(i==0) {
					dp[0][i] = arr[0][i];
					dp[1][i] = arr[1][i];
				}
				else if(i==1) {
					dp[0][i] = dp[1][i-1]+arr[0][i];
					dp[1][i] = dp[0][i-1]+arr[1][i];
				}
				else {					
					//위를 선택
					dp[0][i] = Math.max(dp[1][i-1], Math.max(dp[0][i-2], dp[1][i-2]))+arr[0][i];
					//아래를 선택
					dp[1][i] = Math.max(dp[0][i-1], Math.max(dp[0][i-2], dp[1][i-2]))+arr[1][i];
				}
				
				max = Math.max(dp[0][i], dp[1][i]);
				
			}
			System.out.println(max);
		}
	}

}
