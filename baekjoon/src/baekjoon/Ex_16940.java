package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_16940 {
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// bfs 스페셜 저지
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		list = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			list[v1].add(v2);
			list[v2].add(v1);

		}
		st = new StringTokenizer(br.readLine());
		int[] answer = new int[n];
		for(int i=0;i<n;i++) {
			answer[i]=Integer.parseInt(st.nextToken());
		}
		if (bfs(answer, n)) {
			System.out.println(1);
		} else
			System.out.println(0);

	}

	static boolean bfs(int[] answer, int n) {
		int idx = 1;
		HashSet<Integer> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		q.add(answer[0]);
		visited[answer[0]] = true;
		while(!q.isEmpty()) {
			set.clear();
			
			int cur = q.poll();
			
			for(int next : list[cur]) {
				if(visited[next]) continue;
				
				set.add(next);
				visited[next] = true;
			}
			
			int size = set.size();
			
			for(int i = idx ; i < idx + size ; ++i) {
				if(set.contains(answer[i])) q.offer(answer[i]);
				else return false;
			}
			
			idx += size;
		}
		
		return true;
	}

}
