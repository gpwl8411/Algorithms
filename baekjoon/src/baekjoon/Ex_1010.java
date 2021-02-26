package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_1010 {

	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//다리 놓기 dp
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		long[][] dp = new long[30][30];
		
		for (int i = 0; i < 30; i++) {
			dp[i][i] = 1;
			dp[1][i] = i;
		}
		for(int i=2;i<30;i++) {
			for(int j=2;j<30;j++) {
				if(i!=j)
					dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
			}
		}
		while(t-- > 0) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			bw.append(dp[n][m]+"\n");
			
			
		}
		bw.flush();
		
	
	}

}
