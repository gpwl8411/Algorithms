package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_1987 {

	static String[][] map;
	static boolean[][] visited;
	static int r;
	static int c;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new String[r][c];
		visited = new boolean[r][c];
		max =0;
		for(int i=0;i<r;i++) {
			String[] alpa = br.readLine().split("");
			for(int j=0;j<c;j++) {
				map[i][j]=alpa[j];
			}
		}
		dfs(0,0,map[0][0]);
		System.out.println(max);
		
		
	}
	static void dfs(int x, int y,String str) {
		visited[x][y]=true;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		for(int i=0;i<4;i++) {
			int sx = x+dx[i];
			int sy = y+dy[i];
			
			if(sx <0 || sy <0 || sx >=r || sy >=c) {
//				System.out.println(str);
				max = Math.max(max, str.length());
				continue;
			}
			if(str.contains(map[sx][sy])) {
//				System.out.println(str);
				max = Math.max(max, str.length());
				continue;
			}
			if(!visited[sx][sy])
				dfs(sx,sy,str+map[sx][sy]);
			
			visited[sx][sy]=false;
			
		}
		
		
	}

}
