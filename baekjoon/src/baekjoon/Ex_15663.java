package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex_15663 {

	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new LinkedHashSet<>();
	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//백트래킹 N과 M(9)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(new int[m],new boolean[n],n,m,0);
		for(String s : set) {
			System.out.println(s);
		}
	}
	static void perm(int[] output, boolean[] visited,int n, int r, int depth) {
		if(r==depth) {
			StringBuilder sb = new StringBuilder();
			for(int i : output)
				sb.append(i+" ");
			set.add(sb.toString());
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				output[depth]=arr[i];
				perm(output,visited,n,r,depth+1);
				visited[i]=false;
			}
			
		}
	}

}
/*
public class Main {
	static int N, M;
	static ArrayList<Integer> num = new ArrayList<>();
	static int[] check = new int[10001];
	static int[] answer;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(!num.contains(n)) {
					num.add(n);
				}
				check[n]++;
			}
			num.sort(null);
			
			calc(0);
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void calc(int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(answer[i]).append(' ');
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append('\n');
			return;
		}
		for(int i = 0; i < num.size(); i++) {
			int k = num.get(i);
			if(check[k] > 0) {
				check[k]--;
				answer[idx] = k;
				calc(idx + 1);
				check[k]++;
			}
		}
	}

} 
 */
