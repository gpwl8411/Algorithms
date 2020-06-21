package baekjoon;
import java.util.*;
import java.io.*;

public class ex_1012 {
	static boolean visited[][];
	static int g[][];
	static int M,N,K;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	        int testcase = Integer.parseInt(br.readLine());
	        for(int t=0;t<testcase;t++){
	        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				M = Integer.parseInt(st.nextToken());
				N = Integer.parseInt(st.nextToken());
				K = Integer.parseInt(st.nextToken());
		        g = new int[M][N];
		        visited = new boolean[M][N];
		        int cnt=0;

		        for(int i=0; i<K; i++) {
		        	st = new StringTokenizer(br.readLine(), " ");
		        	int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());

		                g[x][y] = 1;
		        }
				for(int i=0;i<M;i++){
				for(int j=0;j<N;j++){
					if(g[i][j]==1 && !visited[i][j]){

						dfs(i,j);
						cnt++;
					}
				}
			}

				System.out.println(cnt);

	        }

	      
	}
	static void dfs(int x,int y){
//		System.out.println(x+" "+y);
		visited[x][y]=true;
//		cnt++;
		for(int i=0;i<4;i++){
			int sx = x+dx[i];
			int sy = y+dy[i];
			if(sx<0 || sx>=M || sy<0 || sy>=N){
				continue;
			}
			
			if(g[sx][sy]==1 && !visited[sx][sy])
				dfs(sx,sy);
		}

	}
	

}
