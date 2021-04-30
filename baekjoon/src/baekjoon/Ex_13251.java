package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_13251 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//수학/조합론 조약돌 꺼내기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		double[] arr = new double[m];
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sum = 0;
		double ans = 0;
		for(int i=0;i<m;i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			sum+=arr[i];
		}
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			if(arr[i] < k)
				continue;
			double tmp=1.0;
			for(int j=0;j<k;j++) {
				tmp *= (arr[i]-j)/(sum-j);
			}
			ans+=tmp;
		}
		System.out.println(ans);
	}

}
