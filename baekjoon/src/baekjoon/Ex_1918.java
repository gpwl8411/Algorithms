package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex_1918 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//후위 표기식 자료구조
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
//		Stack<Character> oper = new Stack<>();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(c>=65 && c<=90) {
				sb.append(c);
			}
			else if(c=='*' || c=='/') {
				while(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/')) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
			else if(c=='-' || c=='+') {
				while(!stack.isEmpty() && !(stack.peek()=='(' || stack.peek()==')')) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
			else if(c==')') {
				while(stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.pop();

			}
			else 
				stack.push(c);
			
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());

	}

}
