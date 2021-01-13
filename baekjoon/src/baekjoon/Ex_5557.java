package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_5557 {
	static long[] dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// dp 1학년
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		dp = new long[21];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i == 0)
				dp[arr[i]] = 1;
			if(i!=0 && i!=n-1)
				solve(arr[i]);

		}
		System.out.println(dp[arr[n - 1]]);
	}

	static void solve(int num) {
		long[] tmp = new long[21];
				
		for (int i = 0; i < 21; i++) {
			if (dp[i] == 0)
				continue;
			else {
				if (i + num >= 0 && i + num <= 20)
					tmp[i + num] += dp[i];
				if (i - num >= 0 && i - num <= 20)
					tmp[i - num] += dp[i];
			}
		}
		dp = tmp;
		
	}

}
