package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex_16932 {

	static boolean[][] visited;
	static int[][] arr;
	static int max = 0;
	static int n,m;
	static int team=2;
	static Map<Integer,Integer> mapT;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//그래프탐색 모양 만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
				
		arr = new int[n][m];
		visited = new boolean[n][m];
		mapT = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					visited[i][j]=true;
					arr[i][j]=team;
					mapT.put(team,dfs(i,j,team++));
				}
			}
		}

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==0) {
					max = Math.max(max,connect(i,j));
				}
			}
		}
		System.out.println(max+1);
	}
	static int connect(int x,int y) {
		int sum=0;
		HashSet<Integer> hset = new HashSet<>();
		for(int i=0;i<4;i++) {
			int sx = x+dx[i];
			int sy = y+dy[i];
			
			if(sx < 0 || sy < 0 || sx >= n || sy >= m) 
				continue;
			if(arr[sx][sy] > 0) {
				hset.add(arr[sx][sy]);
			}
		}
		for(int key : hset) {
			sum+=mapT.get(key);
		}
			
		return sum;
		
	}
	static int dfs(int x,int y,int team) {
		int sum = 1;
		for(int i=0;i<4;i++) {
			int sx = x+dx[i];
			int sy = y+dy[i];
			
			if(sx < 0 || sy < 0 || sx >= n || sy >= m) 
				continue;
		
			if(arr[sx][sy]==1 && !visited[sx][sy]) {
				visited[sx][sy]=true;
				arr[sx][sy]=team;
				sum += dfs(sx,sy,team);
			}
		}
		return sum;
	}

}
