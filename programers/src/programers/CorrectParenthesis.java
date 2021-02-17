package programers;

import java.util.Stack;

public class CorrectParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//올바른 괄호
		String s = "(()(";
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(')
				stack.push(s.charAt(i));
			else {
				if(stack.isEmpty())
					System.out.println(false);
				else
					stack.pop();
			}
		}
		if(!stack.isEmpty())
			System.out.println(false);
		else
			System.out.println(true);
	}

}
