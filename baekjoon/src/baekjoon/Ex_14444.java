package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_14444 {
	static int[] a;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//가장 긴 팰린드롭 부분 문자열 manacher 알고리즘
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String str= "";
		for(int i=0;i<input.length();i++) {
			str += "#";
			str += input.charAt(i);
		}
		str+="#";
//		int n = str.length();
		a = new int[str.length()];
		manacher(str,str.length());
		int max = 0;
		for(int i : a) {
			max = Math.max(max, i);
		}
		System.out.println(max);
	}
	static void manacher(String str,int n) {
		int p = 0;
		int r = 0;
		for(int i=0;i<n;i++) {
			
			if(i <= r) {
				a[i] = Math.min(r-i, a[2*p-i]);
			}else {
				a[i] = 0;
			}
			
			while(i-a[i]-1 >= 0 && i +a[i] + 1 < n &&  str.charAt(i - a[i] - 1) == str.charAt(i + a[i] + 1)) {
				a[i]++;
			}
			if(r<i+a[i]) {
				r = i+a[i];
				p = i;
			}
		}
	}

}