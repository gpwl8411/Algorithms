package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_2623 {

	public static void main(String[] args) throws Exception{

		//위상정렬 부등호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] in = new int[n+1];
		int[][] link = new int[n+1][n+1];
		ArrayList<Integer>[] list = new ArrayList[n+1];
		for(int i=1;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			for(int j=1;j<size;j++) {
				int to = Integer.parseInt(st.nextToken());
				if(link[from][to]==0) {
					list[from].add(to);
					link[from][to] = 1;
					in[to]++;
				}
				from = to;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(in[i]==0) {
				q.add(i);
				bw.append(i+"\n");
			}
		}
		if(q.isEmpty()) {
			System.out.println(0);
			return;
		}
		while(!q.isEmpty()) {
			int from = q.poll();
			
			for(int to : list[from]) {
				if(link[from][to]==1) {
					if(--in[to] == 0) {
						q.add(to);
						link[from][to] = 0;
//						System.out.println(to);
						bw.append(to+"\n");
					}
				}
			}
			
		}
		for(int i=1;i<=n;i++) {
			if(in[i]!=0) {
				System.out.println(0);
				return;
			}
		}
//		System.out.println();
		bw.flush();
	}

}
