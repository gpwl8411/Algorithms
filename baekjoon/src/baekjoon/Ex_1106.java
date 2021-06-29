package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_1106 {
	static int[] dp;
	static Price[] prices;
	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//dp 호텔
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		dp = new int[c+1];
		prices = new Price[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			prices[i] = new Price(p,num);
		}
		System.out.println(dfs(c));
	}
	 public static int dfs(int c) {
	        if(c<=0) return 0;

	        if(dp[c]!=0) return dp[c];

	        int min = Integer.MAX_VALUE;

	        for(int i=0; i<n; i++) {
	            Price p = prices[i];

	            min = Math.min(min, dfs(c-p.num) + p.price);
	        }

	        return dp[c] = min;
	    }

	 static class Price{
		 int price;
		 int num;
		 Price(int price,int num){
			 this.price = price;
			 this.num = num;
		 }
	 }
}
/**참고 코드
 * public class Main {
	
	static final int INF = 987654321;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 입력 및 초기화
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int C = Integer.parseInt(st.nextToken()); // 최소 고객 달성
		int N = Integer.parseInt(st.nextToken()); // 도시 개수
		
		int[] dp = new int[C+101]; // 달성고객 + 최대 도시고객
		Arrays.fill(dp, INF);
		dp[0] = 0;
		
		// 2. DP ( 호텔의 고객을 'i' 명 늘리기 위해 투자해야 하는 최소비용 )
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			int cost     = Integer.parseInt(st.nextToken()); // 비용
			int customer = Integer.parseInt(st.nextToken()); // 고객
			for(int i=customer; i<C+101; i++) {
				dp[i] = Math.min(dp[i], cost + dp[i - customer]);
			}
		}

		// 3. 최소값 출력
		int ans = INF;
		for(int i=C; i<C+101; i++) ans = Math.min(ans, dp[i]);
		System.out.println(ans);
	}
	
}
*/
