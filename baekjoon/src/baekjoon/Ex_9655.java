package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_9655 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//dp 돌 게임
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] dp = new boolean[n+1];
		dp[0]=false;
		for(int i=1;i<=n;i++) {
			dp[i]=false;
			if(i-1 >= 0 && dp[i-1] == false)
				dp[i] = true;
			if(i-3 >= 0 && dp[i-3] == false)
				dp[i] = true;
		}
		System.out.println(dp[n] ? "SK" : "CY");

	}

}
