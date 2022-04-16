package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_2612 {

	public static void main(String[] args) throws Exception{
		// 부분 서열 - DP
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		char[] arr1 = br.readLine().toCharArray();
		int n2 = Integer.parseInt(br.readLine());
		char[] arr2 = br.readLine().toCharArray();
		
		int[][] dp = new int[n1+1][n2+1];
		
		for(int i=1;i<=n1;i++) {
			for(int j=1;j<=n2;j++) {
				if(arr1[i-1] == arr2[j-1]) {
					dp[i][j] = dp[i-1][j-1]+3;
				}else {
					dp[i][j] = Math.max(Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]))-2, 0);
				}
			}
		}
		
		int x = 0;
		int y = 0;
		int max = Integer.MIN_VALUE;	
		
		for(int i=0;i<=n1;i++) {
			for(int j=0;j<=n2;j++) {
				if(max < dp[i][j]) {
					max = dp[i][j];
					x = i;
					y = j;
				}
			}
		}
		
		int maxX = x;
		int maxY = y;
		while(dp[x][y] != 0) {	
			if(dp[x][y] == dp[x-1][y] - 2) {
				x--;
			}else if(dp[x][y] == dp[x][y-1] - 2) {
				y--;
			}else {
				x--;
				y--;
			}
		}
		
		System.out.println(max);
		for(int i=x;i<maxX;i++) {
			System.out.print(arr1[i]);
		}
		System.out.println();
		for(int i=y;i<maxY;i++) {
			System.out.print(arr2[i]);
		}
	}

}
