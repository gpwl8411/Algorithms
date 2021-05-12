package programers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoIntern20_BuildRoad {

	static int n;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] price;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//카카오 인턴 20 경주로 건설
//		int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
		price = new int[board.length][board.length];
		n = board.length-1;
		for(int i=0;i<=n;i++)
			Arrays.fill(price[i], Integer.MAX_VALUE);
		go(board);
		System.out.println(price[n][n]);
	}
	static void go(int[][] board) {
		Queue<Road> q = new LinkedList<>();
		
		q.add(new Road(0,0,0,0,0));
		q.add(new Road(0,0,1,0,0));
		while(!q.isEmpty()) {
			
			Road r = q.poll();
			
			int tmp = r.road*100;
			tmp += r.corner*500;
			if(price[r.x][r.y] < tmp)
				continue;
			price[r.x][r.y] = tmp;
			
			for(int i=0;i<4;i++) {
				int sx = r.x+dx[i];
				int sy = r.y+dy[i];
			
				if(sx < 0 || sy < 0 || sx > n || sy > n || board[sx][sy]==1)
					continue;
				
				int corner = r.corner;
				if(r.dir != i && !(r.x==0 && r.y==0))
					corner++;
				if(!(sx==0 && sy ==0))
					q.add(new Road(sx,sy,i,r.road+1,corner));
			
			}
		}
	}

}
class Road{
	int x;
	int y;
	int dir;
	int road;
	int corner;
	
	Road(int x,int y,int dir, int road,int corner){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.road = road;
		this.corner = corner;
	}
}
