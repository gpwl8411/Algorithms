package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ex_2468 {
	static int g[][];
	static int x;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean visited[][]; 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		x = Integer.parseInt(str[0]);
		g = new int[x][x];
		int maxH=0;
		int minH=101;
		int cnt=0;
		int max=-1;
		
		for (int i = 0; i < x; i++) {
			str = in.readLine().split(" ");
			for (int j = 0; j < x; j++) {
				g[i][j] = Integer.parseInt(str[j]);
				maxH = Math.max(maxH, g[i][j]);
				minH = Math.min(minH,g[i][j]);

			}
		}
		for(int h=minH;h<= maxH;h++){
			cnt=0;
			visited	= new boolean[x][x];
			for(int i=0;i<x;i++){
				for(int j=0;j<x;j++){
					if(g[i][j]>h && !visited[i][j]){
						 bfs(i,j,h);
//						 if(h==3)
//						 System.out.println("3:"+i+","+j);
						 cnt++;
						
					}
					
				}
			}
			max = Math.max(max, cnt);
			if(max==0)
				max=1;
		}
		System.out.println(max);
		

	}

	public static void bfs(int xx,int yy,int height) {

			
			Queue<Integer> qx = new LinkedList<>();
			Queue<Integer> qy = new LinkedList<>();
			qx.offer(xx);
			qy.offer(yy);
			
			 visited[xx][yy]=true;
			while (!qx.isEmpty()) {
				int tempx = qx.poll();
				int tempy = qy.poll();
				
				for (int k = 0; k < 4; k++) {
					int sx= tempx+dx[k];
					int sy= tempy+dy[k];
	

						if (sx >= 0 && sx < x && sy >= 0 && sy < x && g[sx][sy]>height && !visited[sx][sy]) {
							qx.offer(sx);
							qy.offer(sy);
							visited[sx][sy] = true;
						
						}


						// g[sx][sy] = g[tempx][tempy] + 1;

				}

			}


	}

}
