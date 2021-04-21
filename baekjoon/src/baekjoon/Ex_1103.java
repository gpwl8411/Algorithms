package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
6 7
12HHHHH
2214HHH
H1HHHHH
H4H9H2H
HHHHHHH
HHH2HHH

3 4
3552
5555
2553
 */
public class Ex_1103 {

	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	static int r,c;
	static int max = 0;
	static boolean flag=false;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//dp 그래프탐색 게임
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		dp = new int[r][c];
		visited = new boolean[r][c];
		
		for(int i=0;i<r;i++) {
			String s = br.readLine();
			for(int j=0;j<c;j++) {
				if(s.charAt(j)=='H')
					map[i][j]=10;
				else
					map[i][j] = s.charAt(j)-'0';
			}
		}
		
		visited[0][0]=true;
		dfs(0,0,1);
		System.out.println(flag ? -1 : max);
	}
	static void dfs(int x, int y, int cnt) {
		if(flag)
			return;
		
		dp[x][y] = cnt;
		
		for(int i=0;i<4;i++) {
			int sx = x+dx[i]*map[x][y];
			int sy = y+dy[i]*map[x][y];
			
			if(sx < 0 || sy < 0 || sx >= r || sy >= c || map[sx][sy] == 10 ) {
				max = Math.max(max, cnt);
				continue;
			}
			
			if(visited[sx][sy]) {
				flag = true;
				return;
			}
			if (dp[sx][sy] > cnt) continue;
			
			visited[sx][sy]=true;
			dfs(sx,sy,cnt+1);
			visited[sx][sy]=false;
		}
	}

}
/*
 class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n, m, max;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visit;
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dp = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				if(s.charAt(j)=='H') {
					map[i][j] = 0;
				}else {
					map[i][j] = s.charAt(j)-'0';
				}
			}
		}
		//입력 끝
		
		visit[0][0] = true;
		int result = dfs(0,0);
	
		
		if(result==-1) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		
	}
	static int dfs(int x, int y) {
		
		if(dp[x][y]!=0) return dp[x][y];
		
		for (int i = 0; i < 4; i++) {
			int xx = x+di[i]*map[x][y];
			int yy = y+dj[i]*map[x][y];

			if(xx>=0 && xx<n && yy>=0 && yy<m && map[xx][yy]!=0) {
				
				if(visit[xx][yy]) return -1;
				
				visit[xx][yy] = true;
				int num = dfs(xx, yy);
				if(num==-1) return -1;
				dp[x][y] = Math.max(num+1, dp[x][y]);
				
				visit[xx][yy] = false;
			}else {
				dp[x][y] = Math.max(1, dp[x][y]);
			}
		}	
		
		return dp[x][y];
	}
}
*/
