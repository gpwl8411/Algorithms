package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_1717 {

	static int[] parent;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//그래프/분리집합 집합의 표현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i=0;i<=n;i++) {
			parent[i]=i;
		}
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(type==0)
				union(a,b);
			else
				bw.append(isSameParent(a, b) ? "YES\n" : "NO\n");
			
		}
		bw.flush();
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) {
			if(x < y) parent[y] = x;
            else parent[x] = y;
		}
	}
	static int find(int x) {
		if(x == parent[x])
            return x;
        else 
            return parent[x] = find(parent[x]);
	}
	static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        else
            return false;
    }

}
