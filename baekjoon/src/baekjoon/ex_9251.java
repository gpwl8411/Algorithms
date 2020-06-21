package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_9251 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] a = in.readLine().split("");
		String[] b = in.readLine().split("");
		int[][] dp = new int[a.length+1][b.length+1];
		
		for(int i=1;i<=a.length;i++){
			for(int j=1;j<=b.length;j++){
				if (a[i-1].equals(b[j-1])) {
					dp[i][j] = dp[i-1][j-1]+1;
//					System.out.println(i+","+j+":"+dp[i][j]);
					continue;
				}
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
//				System.out.println(i+","+j+":"+dp[i][j]);
			}
		}
		System.out.println(dp[a.length][b.length]);
	}


}
