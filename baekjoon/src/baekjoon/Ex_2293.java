package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Ex_2293 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 동전 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		int[] arr = new int[n+1];
		int[] dp = new int[k+1];
		dp[0]=1;
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j=arr[i];j<=k;j++)
				dp[j] += dp[j-arr[i]];
		}
		System.out.println(dp[k]);
		
	}

}
