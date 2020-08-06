package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_16236 {
	static int n;
	static int[][] map;
	static boolean flag = true;
	static boolean[][] visited;
	static int cnt;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		Shark shark = null;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark = new Shark(i,j,0,2,0);
					map[i][j]=0;
				}
			}
		}
		detect(shark);
		System.out.println(cnt);
		
	}
	static void detect(Shark s) {

		Queue<Shark> q = new LinkedList<>();//탐색 큐
		PriorityQueue<Shark> preQ = new PriorityQueue<>();//먹을 수 있는 상어 큐
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		q.offer(s);
		for(boolean a[] : visited) {
			Arrays.fill(a, false);
		}
		while(!q.isEmpty()) {
			Shark temp = q.poll();
			for(int i=0;i<4;i++) {
				int sx = temp.x + dx[i];
				int sy = temp.y + dy[i];
				if(sx < 0 || sx >= n || sy < 0 || sy >= n) {
					continue;
				}
				if(visited[sx][sy]) {
					continue;
				}
				if(map[sx][sy]>temp.size) {
					continue;
				}
				visited[sx][sy]=true;
				if(map[sx][sy]<temp.size && map[sx][sy]!=0) {
					preQ.offer(new Shark(sx,sy,temp.eat,temp.size,temp.dis+1));
					continue;
				}
				q.offer(new Shark(sx,sy,temp.eat,temp.size,temp.dis+1));
			}
		}
		if(preQ.size()==0) return;
		Shark eatShark = preQ.poll();
		int x=eatShark.x;
		int y=eatShark.y;
		map[x][y]=0;
		cnt += eatShark.dis;
		if(eatShark.size == eatShark.eat+1) {
			detect(new Shark(x,y,0,eatShark.size+1,0));
		}else {
			detect(new Shark(x,y,eatShark.eat+1,eatShark.size,0));
		}
		return;		
	}

}
class Shark implements Comparable<Shark>{
	int x;
	int y;
	int eat;
	int size;
	int dis;
	Shark(int x,int y,int eat,int size, int dis){
		this.x = x;
		this.y = y;
		this.eat = eat;
		this.size = size;
		this.dis = dis;
	}
	@Override
	public int compareTo(Shark s) {
		if(dis<s.dis) {
			return -1;
		}else if(dis==s.dis) {
			
			if(x<s.x) {
				return -1;
			}else if(x==s.x) {
				if(y<s.y)
					return -1;
			}
		}
		return 1;
	}
	
	
}