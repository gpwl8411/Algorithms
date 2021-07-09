package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex_12026 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//dp - BOJ거리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine());
		String s = br.readLine();
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(((s.charAt(i)=='B' && s.charAt(j) == 'J')||(s.charAt(i)=='O' && s.charAt(j) == 'B' )
						||(s.charAt(i)=='J' && s.charAt(j) == 'O' ))&&dp[j]!=Integer.MAX_VALUE)
				dp[i] = Math.min(dp[i], dp[j]+(i-j)*(i-j));
			}
		}
		System.out.println(dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1]);
		
	}

}
