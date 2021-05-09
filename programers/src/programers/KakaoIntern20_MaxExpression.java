package programers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KakaoIntern20_MaxExpression {

	static char[] output= new char[3];
	static List<String> list;
	static int ans = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//카카오20 인턴십 수식 최대화
		String expression="100-200*300-500+20";
		
		list = new ArrayList<>();
		String tmp ="";
		for(int i=0;i<expression.length();i++) {
			char c = expression.charAt(i);
			if(c != '-' && c != '+' && c != '*') {
				tmp+=c;
			}else {
				list.add(tmp);
				list.add(c+"");
				tmp="";
			}
		}
		list.add(tmp);
		
		char[] arr = {'-','+','*'};
		perm(arr,new boolean[3],0);
		System.out.println(ans);
	}
	static void perm(char[] arr ,boolean[] visited,int depth) {
		if(depth==3) {
			solve();
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				output[depth] = arr[i];
				perm(arr,visited,depth+1);
				visited[i]=false;
			}
		}
	}
	static void solve() {
		Queue<String> q = new LinkedList<>();
		Queue<String> tmpQ = new LinkedList<>();
		for(int i=0;i<list.size();i++) {
			String s = list.get(i);
			q.add(s);
		}
		
		int num=-1;
		for(int i=0;i<output.length;i++) {
			String op = output[i]+"";
			num=-1;
			while(!q.isEmpty()) {
				String s = q.poll();
				if(s.equals(op)) {
					int curNum = Integer.parseInt(q.poll());
					num = calc(num,curNum,output[i]);
					if(q.isEmpty())
						tmpQ.add(String.valueOf(num));
				}
				else if(s.equals("+") || s.equals("-") || s.equals("*")){
					if(num!=-1) {
						tmpQ.add(String.valueOf(num));
						tmpQ.add(s);
						num=-1;
					}
				}else {
					if(num==-1)
						num=Integer.parseInt(s);
					if(q.isEmpty())
						tmpQ.add(s);
				}
			}
			
			while(!tmpQ.isEmpty()) {
				q.add(tmpQ.poll());
			}
			
		}
		ans = Math.max(ans, Math.abs(num));
	}
	static int calc(int n1, int n2, char op) {
		int res=0;
		switch(op) {
		case '+' :
			res = n1+n2;
			break;
		case '-' :
			res = n1-n2;
			break;
		case '*' :
			res = n1*n2;
			break;
		}
		return res;
	}

}
