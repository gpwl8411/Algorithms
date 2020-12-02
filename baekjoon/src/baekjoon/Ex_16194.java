package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_16194 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 카드구매하기 2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] p = new int[n+1];
		int[] dp = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			p[i] = Integer.parseInt(st.nextToken());
			dp[i] = p[i];
		}

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				dp[i] = Math.min(dp[i-j]+p[j], dp[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
