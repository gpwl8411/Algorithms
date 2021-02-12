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
		long k = Integer.parseInt(st.nextToken());

		long[] arr = new long[n];
		long[] dp = new long[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			
		}
		long max=0;
		long sum=0;
        int end=-1;
        for(int start=0;start<n;start++){
            while(end+1<n && sum < k) sum+= arr[++end];
            dp[end]=Math.max(dp[end],max+Math.max(0,sum-k));
            sum -= arr[start];
            max=Math.max(max,dp[start]);
        }
        System.out.println(max);



	}

}
