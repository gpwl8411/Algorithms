package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_20181 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 투 포인터 꿈틀꿈틀 호석 애벌레

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int[] dp = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int sum = 0;

		while (end < n) {

			sum += arr[end];

			if (sum >= k) {
				if(start!=0) {					

					dp[end] = Math.max(dp[end],Math.max(dp[start], dp[start-1]+sum-k));

				}
				else
					dp[end] = sum-k;

				sum -= arr[start];
				sum -= arr[end];
				start += 1;
			} else {

				end += 1;

			}

		}

		System.out.println(dp[n - 1]);

	}

}
