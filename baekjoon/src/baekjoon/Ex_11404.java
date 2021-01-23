package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_11404 {

	static final int INF = 10000000;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//플로이드 플로이드 와샬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] bus = new int[n+1][n+1];
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			if(bus[from][to]!=0)
				bus[from][to] = Math.min(val,bus[from][to]);
			else
				bus[from][to] = val;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i!=j && bus[i][j]==0)
					bus[i][j] = INF;
			}
		}
		for(int i=1;i<=n;i++) {//거쳐가는
			for(int j=1;j<=n;j++) {//출발
				for(int k=1;k<=n;k++) {//도착
					if(bus[j][k] > bus[j][i]+bus[i][k])
						bus[j][k] = bus[j][i]+bus[i][k];
				}
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(bus[i][j]==INF)
					bus[i][j]=0;
				System.out.print(bus[i][j]+" ");
			}
			System.out.println();
		}
	}

}
