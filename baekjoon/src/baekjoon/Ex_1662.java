package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex_1662 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//압축 스택,재귀 -> 문자열 중복 압축 & 풀기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("");
		Stack<String> stack = new Stack<>();
		Stack<Integer> lenStack = new Stack<>();
//		StringBuilder sb = new StringBuilder();
		for(int i=s.length-1;i>=0;i--) {
			String str = s[i];
			if(str.equals(")")) {
				stack.push(str);
				lenStack.push(-1);
			}
			else {
				stack.push(str);
				lenStack.push(1);
				if(str.equals("(")) {
					int k = Integer.parseInt(s[--i]);
					int q = 0;
					while(!str.equals(")")) {
						q += lenStack.pop();
						str = stack.pop(); 
					}
					q*=k;
					stack.push("*");
					lenStack.push(q);
				}
			}
		}
		int answer = 0;
		while(!lenStack.isEmpty()) {
			answer+=lenStack.pop();
		}
		System.out.println(answer);
	}

}
