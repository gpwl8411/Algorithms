package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_10986 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//누적합 나머지 합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long ans = 0;
		long[] mod = new long[(int)m];
		long[] sumArr = new long[n+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=n;i++) {
			long num = Long.parseLong(st.nextToken());
			
			
			sumArr[i]=sumArr[i-1]+num;
			if(sumArr[i]%m==0) ans++;
			
			mod[(int) (sumArr[i]%m)]+=1;
			
		}
		for(int i=0;i<m;i++) {
			ans += mod[i]*(mod[i]-1)/2;
		}
		
		
		System.out.println(ans);
	}

}
