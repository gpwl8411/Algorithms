package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_11722 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//dp 가장 긴 감소하는 부분 수열
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int max=0;
		
		for(int i=0;i<n;i++){
			dp[i]=1;
			for(int j=0;j<i;j++){
				if(arr[j]>arr[i]&&dp[i]<dp[j]+1){
					dp[i]=dp[j]+1;
				}
			}
			if(max<dp[i]){
				max = dp[i];
			}
		}
		System.out.println(max);
	}

}
