package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_12871 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 무한 문자열 문자열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		int sLen = s.length();
		int tLen = t.length();
		if (sLen == tLen) {
			if (s.equals(t))
				System.out.println(1);
			else
				System.out.println(0);
			return;
		}

		int a1 = Math.max(sLen,tLen);
		int b1 = Math.min(sLen,tLen);

		while (b1 != 0) {
			int r = a1 % b1;
			a1 = b1;
			b1 = r;
		}
		int lcm =  (sLen * tLen) / a1;
		StringBuilder sb1 = new StringBuilder();
		sb1.append(s);
		for(int i=0;i<lcm-sLen;i++) {
			sb1.append(s.charAt(i%sLen));
		}
		StringBuilder sb2 = new StringBuilder();
		sb2.append(t);
		for(int i=0;i<lcm-tLen;i++) {
			sb2.append(t.charAt(i%tLen));
		}
		int answer = sb1.toString().equals(sb2.toString()) ? 1:0 ;
		System.out.println(answer);
	}

}
