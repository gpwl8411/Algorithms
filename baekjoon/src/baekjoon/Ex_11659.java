package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_11659 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//구간 합 구하기4 누적합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	
		int[] arr = new int[n+1];
		int[] sumArr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sumArr[i]+=sumArr[i-1]+arr[i];
		}
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			bw.append(sumArr[j]-sumArr[i-1]+"\n");
			
		}
		bw.flush();
		
	}

}
