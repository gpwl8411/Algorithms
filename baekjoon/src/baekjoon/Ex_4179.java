package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_4179 {
	static Queue<Position> JQ = new LinkedList<>();
	static Queue<Position> FQ = new LinkedList<>();
	static char[][] map;
	static int r,c;
	static int minT=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//불! 그래프탐색 bfs
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for(int i=0;i<r;i++) {
			String s = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='J')
					JQ.add(new Position(i,j,1));
				else if(map[i][j]=='F')
					FQ.add(new Position(i,j,1));
			}
		}
		bfs();
		if(minT==Integer.MAX_VALUE)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(minT);
			
		
		
	}
	static void bfs() {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		boolean flag = true;
		int time=1;
		boolean[][] visited = new boolean[r][c];
		boolean[][] visitedF = new boolean[r][c];
		while(!JQ.isEmpty()) {
			Position jP = JQ.poll();
			visited[jP.x][jP.y] = true;
			
			if(jP.min!=time) {
				flag = true;
				time=jP.min;
			}
			//불 확산-1분 다 돌았으면
			if(flag) {
				int size = FQ.size();
				while(size-- > 0) {
					Position fP = FQ.poll();
					visitedF[fP.x][fP.y]=true;
						for(int i=0;i<4;i++) {
							int sx = fP.x+dx[i];
							int sy = fP.y+dy[i];
							
							if(sx < 0 || sx >= r || sy < 0 ||  sy >= c || map[sx][sy]=='#'|| map[sx][sy]=='F')
								continue;
							map[sx][sy]='F';
							if(!visitedF[sx][sy]) {
								visitedF[sx][sy]=true;
								FQ.add(new Position(sx,sy,fP.min+1));
							}
								
						}
				}
				flag=false;
			}

			for(int i=0;i<4;i++) {
				int sx = jP.x+dx[i];
				int sy = jP.y+dy[i];
				
				if(sx < 0 || sx >= r || sy < 0 ||  sy >= c) {
						minT = jP.min;
						return;						
					
				}
				if( map[sx][sy]=='.' && !visited[sx][sy]) {
					visited[sx][sy]=true;
					JQ.add(new Position(sx,sy,jP.min+1));
				}
				
			}
			
			
		}
		
	}

}
class Position{
	int x;
	int y;
	int min;
	Position(int x, int y ,int min){
		this.x = x;
		this.y = y;
		this.min = min;
	}
	
	
}