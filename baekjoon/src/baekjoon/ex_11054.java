package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_11054 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		int[][] dp = new int[n][2];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i][0] < dp[j][0] + 1) {
					dp[i][0] = dp[j][0] + 1;
				}
			}
			
		}
		for (int i = n-1; i >= 0; i--) {
			dp[i][1] = 1;
			for (int j = n-1; j > i; j--) {
				if (arr[j] < arr[i] && dp[i][1] < dp[j][1] + 1) {
					dp[i][1] = dp[j][1] + 1;
				}
			}
			if (max < dp[i][0]+dp[i][1]) {
				max = dp[i][0]+dp[i][1];
			}
		}
		
		System.out.println(max-1);

	}

}
