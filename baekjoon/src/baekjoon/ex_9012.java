//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Stack;
//
//public class ex_9012 {
//
//	public static void main(String[] args) throws IOException{
//		// TODO Auto-generated method stub
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//		int n = Integer.parseInt(in.readLine());
//		int answer=0;
//	
//			String str = in.readLine();
//			Stack<Character> s1 = new Stack<Character>();
//			char temp;
//			
//			for(int j=0;j<str.length();j++){
//				temp = str.charAt(j);
//				if(temp == '(' || temp == ')'){
//					s1.push(temp);
//					continue;
//				}
//				if(temp == '{'|| temp == '}'){
//					s1.push(temp);
//					continue;
//				}
//				if(temp == '['|| temp == ']'){
//					s1.push(temp);
//					continue;
//				}
//				if(temp == '<'|| temp == '>'){
//					s1.push(temp);
//					continue;
//
//				}
////				if(s.isEmpty()){
////					//out.write("NO\n");
////					answer = -1;
////					temp=' ';s
////					break;
////				}else{
////					s.pop();
////				}
//			}
//			if(s1.size()==0)
//				answer=-1;
//			System.out.println(answer);
//			
//			int a=0;
//		
//			int c=0;
//			int e=0;
//		
//			int g=0;
//			
//			while(!s1.isEmpty()){
//				switch(s1.pop()){
//				case '(':
//					a++;
//					break;
//				case ')':
//					a--;
//					break;
//				case '[':
//					c++;
//					break;
//				case ']':
//					c--;
//					break;
//				case '{':
//					e++;
//					break;
//				case '}':
//					e--;
//					break;
//				case '<':
//					g++;
//					break;
//				case '>':
//					g--;
//					break;
//					
//				
//				}
//				if(a<0||a>1)
//					answer=-1;
//				if(c<0||c>1)
//					answer=-1;
//				if(e<0||e>1)
//					answer=-1;
//				if(g<0||g>1)
//					answer=-1;	
////			}		if(s1.pop()=='('){
////					a++;
////					continue;
////				}
////				if(s1.pop()==')')
////				{
////					b++;
////					continue;
////				}
////				if(s1.pop()=='[')
////				{
////					c++;
////					continue;
////				}
////				if(s1.pop()==']')
////				{
////					d++;
////					continue;
////				}
////				if(s1.pop()=='{')
////				{
////					e++;
////					continue;
////				}
////				if(s1.pop()=='}')
////				{
////					f++;
////					continue;
////				}
////				if(s1.pop()=='<')
////				{
////					g++;
////					continue;
////				}
////				if(s1.pop()=='>')
////				{
////					h++;
////					continue;
////				}
//				
//			}
//			if(a==b) answer++;
//			else answer = -1;
//			if(c==d) answer++;
//			else answer = -1;
//			if(e==f) answer++;
//			else answer = -1;
//			if(g==h) answer++;
//			else answer = -1;
//			
////			if(temp!=' '){
////				if(!s.isEmpty())
////					answer= -1;
//////					out.write("NO\n");
////				else
////					answer++;
//////					out.write("YES\n");
////				
////			}
//			
//
//		
////		out.flush();
//		System.out.println(answer);
//
//	}
//
//}
