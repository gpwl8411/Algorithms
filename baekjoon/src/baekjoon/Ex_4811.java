package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex_4811 {

	public static void main(String[] args) throws Exception{

		//알약 DP
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] dp = new long[31];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= 30; i++) {
			long cnt = 0;

			for (int j = 0; j < i; j++) {
				cnt += dp[j] * dp[i - 1 - j];
			}

			dp[i] = cnt;
		}
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) break;
			
			bw.append(dp[n]+"\n");
		}
		bw.flush();
	}

}
