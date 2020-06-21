package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ex_12100 {
	static boolean visited[][];
	static int g[][];
	static int x;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		x = Integer.parseInt(str[0]);
		g = new int[x][x];
		for (int i = 0; i < x; i++) {
			str = in.readLine().split(" ");
			for (int j = 0; j < x; j++) {
				g[i][j] = Integer.parseInt(str[j]);
			}
		}
//		Queue<Integer> qx = new LinkedList<>();
//		Queue<Integer> qy = new LinkedList<>();
		for(int i=0;i<x;i++){
			for(int j=0;j<x;j++){
				if(g[i][j]>0){
//					qx.offer(i);
//					qy.offer(j);
					dfs(i,j,g[i][j]);
				}
				visited = new boolean[x][x];
			}
		}

	}
	public static void dfs(int xx,int yy,int val) {

		
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


					if (sx >= 0 && sx < x && sy >= 0 && sy < x && g[sx][sy]==val && !visited[sx][sy]) {
						qx.offer(sx);
						qy.offer(sy);
						visited[sx][sy] = true;
					
					}


					// g[sx][sy] = g[tempx][tempy] + 1;

			}

		}


}
//	public static void dfs(int xx,int yy){
//		//visited[s-1]=true;
//		//System.out.print(s+" ");
//		for(int i=xx;i<x;i++){
//			for(int j=yy;j<x)
//			if(g[s-1][i]==1 && !visited[i]){
//				dfs(i+1);
//			}
//		}
////		for(inti=0;i<)
////		return "";
//	}

}
