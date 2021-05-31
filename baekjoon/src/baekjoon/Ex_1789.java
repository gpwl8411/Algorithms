package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_1789 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//수들의 합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long s = Long.parseLong(br.readLine());
		long sum = 0;
		long n = 0;
		while(sum <= s) {
			sum+=++n;
		}
		System.out.println(n-1);
	}

}
