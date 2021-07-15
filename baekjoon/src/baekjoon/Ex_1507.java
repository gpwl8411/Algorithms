package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_1507 {

	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 플로이드와샬 궁금한 민호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] arr = new int[n][n];
		int[][] dist = new int[n][n];
//		boolean[][] visited = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = arr[i][j];
			}
		}
		
		for(int k=0;k<n;k++) {//거쳐가는 노드
			for(int i=0;i<n;i++) {//시작
				for(int j=0;j<n;j++) {//끝
					if(i==k || k==j || i==j)
						continue;
					if(dist[i][j] > dist[i][k]+dist[k][j]) {
						System.out.println("-1");
						return;
					}
					if(dist[i][j]==dist[i][k]+dist[k][j]) {
						arr[i][j]=INF;
					}
				}
			}
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]!=INF)
					ans+=arr[i][j];
			}
		}
		System.out.println(ans/2);
	}

}
