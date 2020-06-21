package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1912 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int[] arr= new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0]=arr[0];
		int max=arr[0];
		for(int i=1;i<n;i++){
				dp[i]=Math.max(arr[i], dp[i-1]+arr[i]);
				max = Math.max(dp[i], max);
		}
			
		System.out.println(max);

	}

}
