package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_7453 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//투포인터 합이 0인 네 정수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long[][] arr = new long[4][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++)
				arr[j][i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<4;i++) {
			Arrays.sort(arr[i]);
		}
		//0->a 1->b 2->c 3->d 
		long[] ab = new long[n*n];
		long[] cd = new long[n*n];
		int idx = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ab[idx] = arr[0][i]+arr[1][j];
				cd[idx] = arr[2][i]+arr[3][j];
				idx++;
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		int s=0; // abIdx
		int e=n*n-1; //cdIdx
		long ans=0;
		while(e>=0 && s<n*n) {
			long sum = ab[s]+cd[e];
			long abVal = ab[s];
			long cdVal = cd[e];
			if(sum < 0) {
				s++;
			}
			else if(sum > 0) {
				e--;
			}			
			else{
				long abCnt=0;
				long cdCnt=0;
				//값은 값일때 처리해주기
				while(s<n*n && abVal == ab[s]) {
					s++;
					abCnt++;
				}
				while(e>=0 && cdVal == cd[e]) {
					e--;
					cdCnt++;
				}
				ans += abCnt*cdCnt;
			}
		}
		System.out.println(ans);
	}

}
