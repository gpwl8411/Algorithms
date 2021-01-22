package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_2529 {

	static List<String> ans = new ArrayList<>();
	static String[] s;
	static int k;
	static boolean[] visited = new boolean[10];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//백트래킹 부등호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = new String[k];
		for(int i=0;i<k;i++) {
			s[i]=st.nextToken();
		}
		dfs(0,"");
		Collections.sort(ans);
		System.out.println(ans.get(ans.size()-1));
		System.out.println(ans.get(0));
		
		
	}
	static void dfs(int index,String num) {
		if(index == k+1) {
			ans.add(num);
			return;
		}
		for(int i=0;i<=9;i++) {
			if(visited[i])
				continue;
			if(index==0 || check(index-1,num.charAt(index-1),(char)(i+'0'))) {
				visited[i]=true;
				dfs(index+1,num+String.valueOf(i));
				visited[i]=false;
			}
			
		}
	}
	static boolean check(int index,char a,char b) {
		if(s[index].equals("<")) {
			if(a<b) return true;
		}else {
			if(a>b) return true;
		}
		return false;
	}

}
