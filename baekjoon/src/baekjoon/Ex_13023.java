package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_13023 {
	static List<Integer>[] list;

	static boolean isExist;

	public static void main(String[] args) throws Exception{

		//ABCDE 그래프
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];

		for(int i=0;i<n;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}
		for(int i=0;i<n;i++) {
			dfs(i,1,new boolean[n]);
			if(isExist) {
				System.out.println(1);
				return;
			}

		}
		System.out.println(0);
	}
	static void dfs(int num,int cnt,boolean[] visited) {
		visited[num] = true;
		if(cnt == 5) {
			isExist = true;
			return;
		}
		for(int i : list[num]) {
			if(visited[i]) continue;
			dfs(i,cnt+1,visited);
			visited[i]=false;
		}
		
	}

}

