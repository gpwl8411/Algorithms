package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_13910 {

	static final int MAX=10001;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// dp - 개업
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] s = new int[101];
		int[] dp = new int[10001];
		boolean[] chk = new boolean[20002];
		for (int i = 1; i <= n; i++)
			dp[i] = MAX;
		chk[0] = true;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			s[i] = num;
		}
		for (int i = 0; i < m; i++) {
			chk[s[i]] = true;
			for (int j = i + 1; j < m; j++)
				chk[s[i] + s[j]] = true;
		}
		for (int i = 1; i <= n; i++) {
			if (!chk[i])
				continue;
			for (int j = i; j <= n; j++)
				dp[j] = Math.min(dp[j], dp[j - i] + 1);
		}
		System.out.println(dp[n] >= MAX ? -1 : dp[n]);

	}

}
