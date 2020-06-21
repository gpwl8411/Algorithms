package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//
public class ex_2206 {
	static class Place{
		int x;
		int y;
		int dis;//이동거리
		int drill;//공사횟수

		public Place(int x,int y,int dis,int drill){
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.drill = drill;
		}
	}
	static int n,m,ans;
	static int[][] map,visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	
//	static int g[][];
//	static int n;
//	static int m;
//	static int[] dx = { 1, -1, 0, 0 };
//	static int[] dy = { 0, 0, 1, -1 };
//	static boolean wall[][];
//	static byte visited[][];
//
	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new int[n][m];
		//wall = new boolean[n][m];
		visit = new int[n][m];

		for (int i = 0; i < n; i++) {
			str = in.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		ans = Integer.MAX_VALUE;

		bfs(0,0);
		
		if(ans==Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(ans);
	}
	public static void bfs(int x,int y){
		Queue<Place> q = new LinkedList<>();
		
		q.add(new Place(x,y,1,0));//좌표,이동거리,벽부순횟수
		visit[x][y]=0;
		
		while(!q.isEmpty()){
			Place p = q.poll();
			//System.out.println(p.drill);
			if(p.x==n-1&&p.y==m-1){
				ans = p.dis;
				break;
			}
			for(int i=0;i<4;i++){
				int sx = p.x + dx[i];
				int sy = p.y + dy[i];
				if (sx < 0 || sx >= n || sy < 0 || sy >= m) {
					continue;
				}
				if(visit[sx][sy]<=p.drill){//이미방문했기 때문에 pass
					System.out.println(sx+","+sy);
					System.out.println(sx+","+sy);
					System.out.println(p.drill+":"+p.dis);
					continue;
				}
				if(map[sx][sy]==0){//벽이 아닌경우임. go 이동거리추가.
					System.out.println(sx+","+sy);
					visit[sx][sy]=p.drill;
					System.out.println(p.drill+":"+p.dis);
					q.add(new Place(sx,sy,p.dis+1,p.drill));
					continue;
				}
				if(p.drill==0){//위에서 0인거 걸러짐.1.즉 벽일경우 이전에 벽 뚫지 않았다면 go
					visit[sx][sy]=p.drill+1;
					System.out.println(sx+","+sy);
					System.out.println(p.drill+":"+p.dis);
					q.add(new Place(sx,sy,p.dis+1,p.drill+1));
				}
			}
	
		}
		
	}
	
//
//	public static void bfs() {
//		int min = 0;
//		Queue<Integer> qx = new LinkedList<Integer>();
//		Queue<Integer> qy = new LinkedList<Integer>();
//		Queue<Integer> move = new LinkedList<Integer>();
//		int tempx;
//		int tempy;
//		int tmove;
//		qx.offer(0);
//		qy.offer(0);
//		move.offer(1);
//		while (!qx.isEmpty()) {
//
//			tempx = qx.poll();
//			tempy = qy.poll();
//			tmove = move.poll();
//			if(tempx==n-1 && tempy==m-1){
//				System.out.println(tmove);
//				return;
//			}
//
//			for (int k = 0; k < 4; k++) {
//				int sx = tempx + dx[k];
//				int sy = tempy + dy[k];
//				if (sx < 0 || sx >= n || sy < 0 || sy >= m) {
//					continue;
//				}
//				if (g[sx][sy] == 1 && wall[tempx][tempy]) {
//					//visited[sx][sy]++;
//					continue;
//				}
//				if(visited[sx][sy]<2){
//					visited[sx][sy]++;
//					if(g[sx][sy] == 1 && !wall[tempx][tempy]) {
//						wall[sx][sy]=true;
//						qx.offer(sx);
//						qy.offer(sy);
//						move.offer(tmove+1);
//						
//					}else{
//						wall[sx][sy]=wall[tempx][tempy];
//						qx.offer(sx);
//						qy.offer(sy);
//						move.offer(tmove+1);
//					}
//				//}
//				
//
//					
//			}
//		}
//
//		System.out.println("-1");
//		System.out.println(Arrays.toString(visited[0]));
//		System.out.println(Arrays.toString(visited[1]));
//		System.out.println(Arrays.toString(visited[2]));
//		System.out.println(Arrays.toString(visited[3]));
//		System.out.println(Arrays.toString(visited[4]));
//		System.out.println(Arrays.toString(visited[5]));
//		System.out.println(Arrays.toString(visited[6]));
//		System.out.println(Arrays.toString(visited[7]));
//		return;
//
	
//
}
