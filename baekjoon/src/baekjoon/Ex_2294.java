package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex_2294 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 동전 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);

		int[] dp = new int[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=1;
		int[] arr = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[arr[i]]=1;
			for(int j=arr[i];j<=k;j++)
				if(dp[j-arr[i]]!=Integer.MAX_VALUE)
					dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
		}
		if(dp[k]==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}

}
