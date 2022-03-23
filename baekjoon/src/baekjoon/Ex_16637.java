package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_16637 {

	static char[] op;
	static int[] num;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 백준 16637 괄호 추가하기 부르트포스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		if(n == 1) {
			System.out.println(s);
			return;
		}

		int len = n/2;
		op = new char[len];
		num = new int[len+1];
		
		
		for(int i = 0; i < s.length(); i++) {
			if(i % 2 == 0) {
				num[i/2] = s.charAt(i)-'0';
			}else {
				op[i/2] = s.charAt(i);
			}
		}
		dfs(0, num[0]);
		System.out.println(ans);
		
	}
	static void dfs(int idx, int ret) {
		if(idx >= op.length) {
			ans = Math.max(ans, ret);
			return;
		}
		//괄호 안 묶었을 때
		int ret1 = calc(ret, num[idx+1], op[idx]);
		dfs(idx+1, ret1);
		
		//괄호 묶었을 때
		if(idx+2 < num.length) {
			int ret2 = calc(ret, calc(num[idx+1], num[idx+2], op[idx+1]), op[idx]);
			dfs(idx+2, ret2);
		}
	}
	static int calc(int i, int j, char c) {
		int ans = 0;
		switch(c) {
			case '+': 
				ans = i+j;
				break;	
			case '-': 
				ans = i-j;
				break;
			default: 
				 ans = i*j;
		}
		return ans;
	}

}
