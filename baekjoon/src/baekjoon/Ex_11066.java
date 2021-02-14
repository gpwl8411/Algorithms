package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_11066 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// dp 파일 합치기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n + 1];
			int[][] dp = new int[n + 1][n + 1];
			int[] sum = new int[n+1];
			
			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1]+arr[i];
//				System.out.println("i="+i+"sum="+sum[i]);
//				dp[i][i] = arr[i];
				dp[i-1][i] = arr[i - 1] + arr[i];
			}

			for (int j = 2; j <= n; j++) {
				for (int i = 1; i+j <= n; i++) {
					for (int k = i; k < i+j; k++) {
						if(dp[i][i+j]==0)
							dp[i][i+j]=dp[i][k]+dp[k + 1][i+j];
						else
							dp[i][i+j] = Math.min(dp[i][i+j],dp[i][k]+dp[k + 1][i+j]);
					}
					dp[i][i+j]+= sum[i+j]-sum[i-1];
				}
			}
			
			bw.append(dp[1][n]+"\n");
		}
		bw.flush();
	}
	//참고
//	public class Main {
//
//	    public static void main(String[] args) throws IOException {
//	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	        int N = Integer.parseInt(br.readLine());
//	        for (int test_case=0; test_case<N; test_case++) {
//	            int K = Integer.parseInt(br.readLine());
//	            int[] chapters = new int[K+1];
//	            StringTokenizer st = new StringTokenizer(br.readLine());
//	            for (int i=0; i<K; i++) {
//	                chapters[i] = Integer.parseInt(st.nextToken());
//	            }
//	            bw.write(Integer.toString(concatFiles(K, chapters)));
//	            bw.newLine();
//	        }
//	        br.close();
//	        bw.flush();
//	        bw.close();
//	    }
//	    
//	    private static int concatFiles(int K, int[] chapters) {
//	        int[][] dp = new int[K][K];
//	        for (int i=K; i>=0; i--) {
//	            int fileSize = chapters[i];
//	            for (int j=i+1; j<K; j++) {
//	                fileSize += chapters[j];
//	                int min = Integer.MAX_VALUE;
//	                for (int k=i; k<j; k++) {
//	                    min = Math.min(min, dp[i][k] + dp[k+1][j]);
//	                }
//	                dp[i][j] = min + fileSize;
//	            }
//	        }
//	        return dp[0][K-1];
//	    }
//	}

}
