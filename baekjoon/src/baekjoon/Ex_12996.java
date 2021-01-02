package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_12996 {

	static long[][][][] dp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

	
		dp = new long[s+1][a+1][b+1][c+1];
		for (int i = 0; i <= s; i++) {
			for (int j = 0; j <= a; j++) {
				for (int k = 0; k <= b; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}
		System.out.println(solve(s, a, b, c));

	}
	static long solve(int s,int a,int b,int c) {
		long ans=0;
		long mod = 1000000007;
		if(s<=0) {
			
			if(a==0&&b==0&&c==0) {
				return 1;
			}
			else return 0;
		}
		if( a < 0 || b < 0 || c < 0)
		      return 0;
		    
		if(dp[s][a][b][c] != -1 )
		      return dp[s][a][b][c];
		
		//a,b,c3명 다 부를경우 -> i+j+k ==3이 되는것.
		for(int i = 0 ; i <= 1 ; i++){
		      for(int j = 0 ; j <= 1 ; j++){
		        for(int k = 0 ; k <= 1 ; k++){
		          if(i+j+k > 0){
		            ans += solve(s-1, a-i, b-j, c-k); 
		          }
		        }
		      }
		    }
		    
		ans %= mod;
	    dp[s][a][b][c] = ans;
	    return ans;
	}

}
