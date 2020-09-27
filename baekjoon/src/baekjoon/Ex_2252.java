package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_2252 {

	public static void main(String[] args) throws Exception{

		//위상정렬 줄세우기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] in = new int[n+1];
		List<List<Integer>> list = new ArrayList<>();
		for(int i=0;i<=n+1;i++) {
			list.add(new ArrayList<Integer>());
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
//			link[from][to]=1;
			list.get(from).add(to);
			in[to]++;
			
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(in[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int from = q.poll();
			bw.append(from+" ");
			
			for(int to : list.get(from)) {
				in[to]--;
					if(in[to] == 0) {
						q.add(to);
					}
			}
			
		}
		bw.flush();
	}

}
