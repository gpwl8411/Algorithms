package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ex_2565 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(in.readLine());
		int[][] arr = new int[n][2];
		int[] dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0],o2[0]);
			}
			
		});
		int max = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j][1] < arr[i][1] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			if (max < dp[i]) {
				max = dp[i];
			}
			
		}
		System.out.println(n-max);
	}

}
