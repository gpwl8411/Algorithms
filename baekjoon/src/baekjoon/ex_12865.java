package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_12865 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n =  Integer.parseInt(st.nextToken());
		int maxW = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][2];
		int[][] dp = new int[n+1][maxW+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());//weight
			arr[i][1] = Integer.parseInt(st.nextToken());//value
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=maxW;j++){
				if(j>=arr[i][0]){//weight
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]]+arr[i][1]);
				}else {
					dp[i][j] = dp[i-1][j];//무게합이 넘으므로 넣을수 없음.
				}
				
			}
		}
		System.out.println(dp[n][maxW]);
	}

}
