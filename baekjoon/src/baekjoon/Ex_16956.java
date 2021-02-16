package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_16956 {

	static char[][] map;
	static int r,c;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//그래프탐색 늑대와 양
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		Queue<Pair3> q1 = new LinkedList<>();
		Queue<Pair3> q2 = new LinkedList<>();
		for(int i=0;i<r;i++) {
			String s = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='S')
					q1.add(new Pair3(i,j));
				else if(map[i][j]=='W')
					q2.add(new Pair3(i,j));
			}
		}
		
		bfs(q1);
		int ans = isPossible(q2);
		System.out.println(ans);
		if(ans==1) {
			for(int i=0;i<r;i++) {
				for(char c : map[i])
					System.out.print(c);
				System.out.println();
			}
		}
	}
	static int isPossible(Queue<Pair3> q) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		boolean[][] visited = new boolean[r][c];
		while(!q.isEmpty()) {
			Pair3 p = q.poll();
			for(int i=0;i<4;i++) {
				
				int sx = p.x+dx[i];
				int sy = p.y+dy[i];
				
				if(sx < 0 || sx >= r || sy < 0 || sy >= c)
					continue;
				visited[sx][sy]=true;
				if(map[sx][sy]=='S')
					return 0;
				if(map[sx][sy]=='.' && !visited[sx][sy])
					q.add(new Pair3(sx,sy));
			}
		}
		return 1;
	}
	static void bfs(Queue<Pair3> q) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		while(!q.isEmpty()) {
			Pair3 p = q.poll();
			for(int i=0;i<4;i++) {
				
				int sx = p.x+dx[i];
				int sy = p.y+dy[i];
				
				if(sx < 0 || sx >= r || sy < 0 || sy >= c)
					continue;
				if(map[sx][sy]=='.')
					map[sx][sy]='D';
			}
		}
	}

}
class Pair3{
	int x;
	int y;
	Pair3(int x, int y){
		this.x = x;
		this.y = y;
	}
}
