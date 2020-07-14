package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n+5];
		int[] p = new int[n+5];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			t[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+5];
//		int day=0;
		int max=0;
		for(int i=0;i<=n;i++) {
			dp[i] = Math.max(max, dp[i]);
			dp[t[i]+i] = Math.max(dp[i]+p[i], dp[t[i]+i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
