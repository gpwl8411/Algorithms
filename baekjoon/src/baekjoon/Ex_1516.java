package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_1516 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 위상정렬/게임 개발
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] list = new List[n+1];
		int[] in = new int[n+1];
		int[] time = new int[n+1];
		int[] res = new int[n+1];
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			res[i] = time[i];
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if(num!=-1) {
					list[num].add(i);
					in[i]++;
				}
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(in[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i : list[cur]) {
				in[i]--;
				res[i] = Math.max(res[i], res[cur]+time[i]);
				if(in[i]==0) {
					q.add(i);
				}
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.println(res[i]);
		}
	}

}

