package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_1261 {
	static int[][] dist;
	static int[][] map;
	static int n,m;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//bfs 다익스트라 알고스팟
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		dist = new int[m][n];
		
		for(int i =0;i<m;i++) {
			String[] s = br.readLine().split("");
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		bfs();
		System.out.println(dist[m-1][n-1]);
		

	}
	static void bfs() {
		Queue<Spot> q = new LinkedList<>();
		q.add(new Spot(0,0));
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		dist[0][0] = 0;
		while(!q.isEmpty()) {
			
			Spot spot = q.poll();
			
			for(int i=0;i<4;i++) {
				int sx = spot.x + dx[i];
				int sy = spot.y + dy[i];
				
				if(sx < 0 || sy < 0 || sx >= m || sy >= n)
					continue;
				if(dist[sx][sy] > dist[spot.x][spot.y] + map[sx][sy]) {
					q.add(new Spot(sx,sy));
					dist[sx][sy] = dist[spot.x][spot.y] + map[sx][sy];
				}
					
			}
		}
		
	}

}
class Spot {
	int x;
	int y;
	Spot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
