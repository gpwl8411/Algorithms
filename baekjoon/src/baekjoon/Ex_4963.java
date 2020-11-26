package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_4963 {

	static int w = -1;
	static int h = -1;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//bfs 섬의 개수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		w = -1;
		h = -1;
 		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int cnt=0;
			if(w==0 && h==0) break;
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					
					if(map[i][j]==1 && !visited[i][j]) {
						bfs(new Pair(i,j));
						cnt++;
					}
				}
			}
			
			sb.append(cnt+"\n");
			
			
		}
 		System.out.println(sb);
 
	}
	static void bfs(Pair start) {
		int[] dx = {0,1,0,-1,1,-1,1,-1};
		int[] dy = {1,0,-1,0,1,-1,-1,1};
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		//visited[]
		while(!q.isEmpty()) {
			Pair p = q.poll();
//			visited[p.x][p.y] = true;
			for(int i=0;i<8;i++) {
				int sx = p.x+dx[i];
				int sy = p.y+dy[i];
				
				if(sx < 0 || sy < 0|| sx >= h || sy >= w)
					continue;
				if(map[sx][sy]==0 || visited[sx][sy]) 
					continue;
				q.add(new Pair(sx,sy));
				visited[p.x][p.y] = true;
				visited[sx][sy] = true;
			}
		}
		
	}

}
//class Pair{
//	int x;
//	int y;
//	Pair(int x,int y){
//		this.x = x;
//		this.y = y;
//	}
//	
//}
