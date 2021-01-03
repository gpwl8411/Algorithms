package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_12872 {

	static long[][] dp;
	static int n,m,p;
	static final long mod = 1_000_000_007;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 플레이리스트
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		dp = new long[p+1][n+1];
		//주석 풀면 방법 1
//		for (int i = 0; i <= p; i++) {
				
//					Arrays.fill(dp[i], -1);
				
//		}
//		System.out.println(solve(0,0));
		//방법 2
		dp[0][0] = 1;
	    for(int i = 1; i <= p; i++)
	        for(int j = 0; j <= n; j++){
	            if(j != n) dp[i][j + 1] = (dp[i][j + 1] + dp[i - 1][j] * (n - j)) % mod;
	            if(m < j) dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - m)) % mod;
	        }
	    System.out.println(dp[p][n]);
	}
	static long solve(int idx, int x) {
		long ans=0;
		
		// y 는 아직 플레이 리스트에 담기지 않은 노래의 갯수
	    int y = n-x;
			
	    // idx는 0부터 시작했기 때문에 p이면 이미 다 담긴 것임
	    if( idx == p ){
	      // 아직 플레이 리스트에 담기지 않은 노래는 없어야한다
	      if( y == 0 ) return 1;
	      // 아직 있다면 불가능한 경우 - 0 반환
	      else return 0;
	    }
			
	    // 메모된 값이 있다면 갖다 쓰자
	    if(dp[idx][x] != -1){
	      return dp[idx][x];
	    }
			

	    // 아직 한번도 안 담긴 곡이 있다면
	    if( y > 0 ){
	      // 이 곡을 넣는 모든 경우의 수는 yC1 이므로
	      ans +=solve(idx+1, x+1)*y;
	    }

	    // 이미 담긴 곡 수가 m개를 초과한다면, 
	    // 끝에서부터 m+1번째 곡~ 첫곡 까지는 한번 더 담겨도 되는거잖아?
	    if( x > m ){
	      ans += solve(idx+1, x) * (x-m);
	    }

	    ans %= mod;
	    dp[idx][x] = ans;
	    return ans;
	}
	

}
