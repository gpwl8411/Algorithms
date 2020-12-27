package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_15653 {
	
	static Pos[] position;
	static String[][] map;
	static int n,m;
	static boolean visited[][][][];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//구슬탈출 4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new String[n][m];
		position = new Pos[2];
		visited = new boolean[n][m][n][m]; //빨간 x,y 파란 x,y
		
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<m;j++) {
				map[i][j] = str[j];
				if(map[i][j].equals("R"))
					position[0] = new Pos(i,j,0);
				else if(map[i][j].equals("B"))
					position[1] = new Pos(i,j,0);
			}
		}
		
		visited[position[0].x][position[0].y][position[1].x][position[1].y]=true;
		System.out.println(bfs());
		
	}
	static int bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(position[0]);
		q.add(position[1]);
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		while(!q.isEmpty()) {
			Pos red = q.poll();
			Pos blue = q.poll();
			
			for(int i=0;i<4;i++) {
				boolean blueInHole=false;
				boolean redInHole = false;
				int rx = red.x + dx[i];
				int ry = red.y + dy[i];
				int bx = blue.x + dx[i];
				int by = blue.y + dy[i];
				
				//파란 구슬
				while(true) {
					if(bx < 0 || by <0 || bx >=n || by >= m)
						break;
					if(map[bx][by].equals("#")) 
						break;
					
					if(map[bx][by].equals("O")) {
						blueInHole = true;
					}
					bx += dx[i];
					by += dy[i];
					
				}
				bx-=dx[i];
				by-=dy[i];
				//빨간 구슬
				while(true) {
					if(rx < 0 || ry <0 || rx >=n || ry >= m)
						break;
					if(map[rx][ry].equals("#")) 
						break;

					if(map[rx][ry].equals("O")) {
						redInHole = true;
					}
					rx += dx[i];
					ry += dy[i];
				}
				rx-=dx[i];
				ry-=dy[i];
				if(blueInHole)
					continue;
				if(redInHole)
					return red.time+1;
				//두개가 겹쳤을 때
				if(rx==bx && ry==by) {
					switch(i) {
					case 0:
						if(red.y-blue.y < 0)
							ry-=1;
						else
							by-=1;
						break;
					case 1:
						if(red.x-blue.x < 0)
							rx-=1;
						else
							bx-=1;
						break;
					case 2:
						if(red.y-blue.y < 0)
							by+=1;
						else
							ry+=1;
						break;
					case 3:
						if(red.x-blue.x < 0)
							bx+=1;
						else
							rx+=1;
						break;
					}
				}
				if(!visited[rx][ry][bx][by]) {
					q.add(new Pos(rx,ry,red.time+1));
					q.add(new Pos(bx,by,blue.time+1));
					visited[rx][ry][bx][by]=true;
				}
			}
			
		}
		return -1;
	}

}
class Pos{
	int x;
	int y;
	int time;
	Pos(int x,int y,int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
