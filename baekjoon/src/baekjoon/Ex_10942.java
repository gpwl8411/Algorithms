package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_10942 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//팰린드롬?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		boolean[][] dp = new boolean[n+1][n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			dp[i][i]=true;//1개짜리 팰린드롬 ->a , b ...
		}
		for(int i=1;i<=n-1;i++) { //2개짜리 팰린드롬 -> aa , bb ...
			if(arr[i]==arr[i+1])
				dp[i][i+1]=true;
		}
		for(int k=2;k<=n-1;k++) {//몇 칸 뛸지
			for(int i=1;i<=n-k;i++) {
				int j=i+k;
				if(arr[i]==arr[j]&& dp[i+1][j-1])
					dp[i][j]=true;
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		while(m-- >0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(dp[start][end]) {
				bw.append(1+"\n");
			}else {
				bw.append(0+"\n");
			}
		}
		bw.flush();
	}
	

}
