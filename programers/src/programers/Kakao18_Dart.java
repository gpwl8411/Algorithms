package programers;

import java.util.Stack;

public class Kakao18_Dart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//카카오블라인드18 다트 게임
		
		String dartResult="0S";
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<dartResult.length();i++) {
			char c = dartResult.charAt(i);
			if(c == '*' && stack.size() >= 4) {
				char bonus = stack.pop();
				char num = stack.pop();
				if(num=='0' && stack.peek()=='1') {
					stack.pop();
					num='+';
				}
				stack.push(c);
				stack.push(num);
				stack.push(bonus);
			}
			if(c=='0'&& !stack.isEmpty() && stack.peek()=='1') {
				stack.pop();
				c='+';
			}
			stack.push(c);
		}
		int option=1;
		int answer=0;
		while(!stack.isEmpty()) {
			char c = stack.pop();
//			System.out.println(c);
			if(c=='*') {
				option*=2;
				continue;
			}
			if(c=='#') {
				option*=-1;
				continue;
			}
			int num=0;
			if(stack.peek()=='+') {
				num=10;
				stack.pop();
			}else {
				num=stack.pop()-'0';
			}
//			System.out.println(num);
			switch(c) {
			case 'T':
				answer+=Math.pow(num, 3)*option;
				break;
			case 'D':
				answer+=Math.pow(num, 2)*option;
				break;
			case 'S':
				answer+=num*option;
				break;
			}
			option=1;
//			System.out.println(answer);
		}
		System.out.println(answer);
		
	}

}
