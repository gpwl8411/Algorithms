package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_13458 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 삼성 sw역량 테스트 -  시험 감독
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			a[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long ans = 0;
		for(int i=0;i<n;i++) {
			ans+=1;
			a[i]-=b;
			if(a[i] > 0)
				ans+=a[i]/c;
			ans += a[i]%c > 0 ? 1 : 0;
		}
		System.out.println(ans);
	}

}
