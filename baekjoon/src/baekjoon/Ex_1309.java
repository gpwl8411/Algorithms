package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex_1309 {

	public static void main(String[] args) throws Exception{
		//동물원 dp
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][3];
		Arrays.fill(dp[1],1);
		
		for(int i=2;i<=n;i++) {
			//이번방에 넣지 않는 경우
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
			//왼쪽방에 넣을 경우
			dp[i][1] = (dp[i-1][0]+dp[i-1][2])%9901;
			//오른쪽방에 넣을 경우
			dp[i][2] = (dp[i-1][0]+dp[i-1][1])%9901;
		}
		int sum = 0;
		for(int i=0;i<3;i++) {
			sum+=dp[n][i];
		}
		System.out.println(sum%=9901);
	}

}
