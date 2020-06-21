package baekjoon;
import java.util.*;
import java.io.*;

public class ex_2178 {
	static boolean visited[][];
	static int g[][];
	static int M,N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
  

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				N= Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
		
		        g = new int[N][M];
		        visited = new boolean[N][M];


		        for(int i=0; i<N; i++) {
//		        	st = new StringTokenizer(br.readLine(), "");
		        	String s = br.readLine();
		        	for(int j=0;j<M;j++){
			        	
			        	g[i][j] = s.charAt(j)-'0';
		        	}
		        }
		        
		        		bfs();
						System.out.println(g[N-1][M-1]);
			}

				

	        

	      
	
	static void bfs(){
		int cnt =0;
		Queue<Integer> xq = new LinkedList();
		Queue<Integer> yq = new LinkedList();
		xq.add(0);
		yq.add(0);
		int x,y;
		
		while(!xq.isEmpty()&&!yq.isEmpty()){
			x = xq.poll();
			y = yq.poll();
			for(int i=0;i<4;i++){
				int sx = x+dx[i];
				int sy = y+dy[i];
				if(sx<0 || sx>=N || sy<0 || sy>=M){
					continue;
				}
				
				if(g[sx][sy]==1 && !visited[sx][sy]){
					xq.add(sx);
					yq.add(sy);
					visited[sx][sy]=true;
					g[sx][sy] = g[x][y]+1;
				}
			}
			
				
		}

	}
	

}
