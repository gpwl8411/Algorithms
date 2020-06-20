package programers;

import java.util.EmptyStackException;
import java.util.Stack;

public class Kakao20_bracket_trans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p="))((()";
		String answer="";
		if(p.equals("")){
			return;
		}
		answer = separate(p);
		System.out.println(answer);
	}
	public static String separate(String s){
		String u="";
		String v="";
		String result="";
		int left=0;
		int right=0;
		if(s.isEmpty()) return result;
		
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				left++;
			}
			else if(s.charAt(i)==')')
				right++;
			if(left==right){
				for(int j=0;j<s.length();j++){
					if(j<=i)
						u+=s.charAt(j);
					else
						v+=s.charAt(j);
					
				}
//				System.out.printf("u=%s,v=%s%n",u,v);
				if(check(u))
					result = u+separate(v);
				else{
					if(!v.equals(""))
						v=separate(v);
					result = correct(u,v);
				}
				break;	
			}
				
		}
		
		return result;
	}
	public static String correct(String u, String v){
		String result="";
		result+="(";
		result+=v;
		result+=")";
		u = u.substring(1, u.length()-1);
		String[] str = u.split("");
		for(int i=0;i<str.length;i++){
			if(str[i].equals("(")){
				str[i] = ")";
			}else if(str[i].equals(")"))
				str[i]="(";
		}
		StringBuilder builder = new StringBuilder();
		for(String s : str) {
		    builder.append(s);
		}
		u = builder.toString();
		result+=u;
		
		return result;
	}
	public static boolean check(String s){
		Stack<Character> st = new Stack<>();
		boolean ans = true;
	
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='('){
					st.push(s.charAt(i));
				}else if(!st.isEmpty()){
					st.pop();
				}else{
					ans = false;
					break;
				}
			}
			
		
		if(!st.isEmpty()) ans = false;
		return ans;
	}

}
