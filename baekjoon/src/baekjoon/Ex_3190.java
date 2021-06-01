package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_3190 {
	
	static int[][] map;
	static int n,time;
	static Queue<Direction> dirQ = new LinkedList<>();
	static Deque<int[]> snake = new ArrayDeque<>(); 
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String args[]) throws Exception{
		//삼성 sw 역량테스트 뱀
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		int k = Integer.parseInt(br.readLine());
		while(k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			map[row][col] = 1;
		}
		
		int l = Integer.parseInt(br.readLine());
		while(l-- > 0 ) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			dirQ.add(new Direction(time,dir));
		}
		snake.add(new int[] {1,1});
		map[1][1]=2;
		time=1;
		int dir = 0;
		while(true) {
			dir = go(dir);
			if(dir == -1 )
				break;
			time++;
		}
		System.out.println(time);
	}
	static int go(int dir) {
		int[] head = snake.peekFirst();		
		int x = head[0]+dx[dir];
		int y = head[1]+dy[dir];
		
		if(x <= 0 || y <= 0 || x > n || y > n ) 
			return -1;
		//사과
		if(map[x][y]==2)
			return -1;

		if(map[x][y]==0) {
			int[] tail = snake.pollLast();
			map[tail[0]][tail[1]]=0;
		}
		snake.addFirst(new int[] {x,y});
		map[x][y]=2;
		
		
		//방향
		if(!dirQ.isEmpty() && dirQ.peek().time == time) {
			Direction direction = dirQ.poll();
			if(direction.dir.equals("L"))
				dir = dir == 0 ? 3 : (dir-1)%4;
			else
				dir = (dir+1)%4;
		}
		return dir;
		
	}
	static class Direction{
		int time;
		String dir;
		
		Direction(int time, String dir){
			this.time = time;
			this.dir = dir;
		}
	}
}

