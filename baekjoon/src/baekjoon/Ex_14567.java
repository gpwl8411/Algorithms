package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_14567 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//위상정렬 선수과목
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new List[n+1];
		int[] in = new int[n+1];
		int[] ans = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			in[b]++;
		}
		
		Queue<Subject> q = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			if(in[i]==0) {
				ans[i]=1;
				q.add(new Subject(i,1));
			}
		}
		
		while(!q.isEmpty()) {
			Subject s = q.poll();
			ans[s.num] = s.cnt;
			
			for(int i: list[s.num]) {
				in[i]--;
				if(in[i]==0)
					q.add(new Subject(i,s.cnt+1));
			}
		}
		
		for(int i=1;i<=n;i++) {
			System.out.print(ans[i]+" ");
		}
		
	}
}
class Subject{
	int num;
	int cnt;
	
	Subject(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
	
}
