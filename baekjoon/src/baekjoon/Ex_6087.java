package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_6087 {
	static String[][] arr;
	static Pair2 c1,c2;
	static int[][] visited;
	static int min=10000;
	static int w,h;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//bfs 레이저 통신
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		arr = new String[h][w];
		visited = new int[h][w];
		
		for(int i=0;i<h;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<w;j++) {
				arr[i][j] = str[j];
				visited[i][j]=10000;
				if(arr[i][j].equals("C")) {
					if(c1==null)
						c1 = new Pair2(i,j,-1,0);
					else
						c2 = new Pair2(i,j,-1,0);
				}
			}
		}
		bfs();
		System.out.println(min);
		
	}
	static void bfs() {
		Queue<Pair2> q = new LinkedList<>();
		q.add(c1);
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		visited[c1.x][c1.y] = 0;
		while(!q.isEmpty()) {
			
			Pair2 p = q.poll();
			if(p.x == c2.x && p.y == c2.y) {
				min = Math.min(min, p.cnt);
				
			}
			for(int i=0;i<4;i++) {
				int sx = p.x+dx[i];
				int sy = p.y+dy[i];
				
				if(sx < 0 || sy <0 || sx >= h || sy >= w)
					continue;
				if(arr[sx][sy].equals("*"))
					continue;
				int tmp = p.cnt;
				if(p.preDir != i && p.preDir!= -1) {
					tmp++;
				}
				if(visited[sx][sy] < tmp)
					continue;
			
				visited[sx][sy] = tmp;
				q.add(new Pair2(sx,sy,i,tmp));
			}
		}
	}

}
class Pair2{
	int x;
	int y;
	int preDir;
	int cnt;
	Pair2(int x, int y,int preDir,int cnt) {
		this.x = x;
		this.y = y;
		this.preDir = preDir;
		this.cnt = cnt;
	}
}
