package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_2018 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//투 포인터/수들의 합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		int s = 1;
		int e = 1;
		int sum = s;
		while(true) {
			if(e > n || s > e)
				break;
			if(sum == n) {
				cnt++;
				sum-=s;
				s++;
			}else if(sum > n) {
				sum-=s;
				s++;
			}else {
				e++;
				sum+=e;
			}
		}
		System.out.println(cnt);
		
	}

}
