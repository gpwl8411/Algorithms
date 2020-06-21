package baekjoon;
import java.util.*;
import java.io.*;

public class ex_2667 {
	static boolean visited[][];
	static int g[][];
	static int vn;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
	static int cnt=0;
	static int total=0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 
	        vn = Integer.parseInt(br.readLine());
	        g = new int[vn][vn];
	        visited = new boolean[vn][vn];
	        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	        for(int i=0; i<vn; i++) {
	            String s = br.readLine();
	 
	            for(int j=0; j<vn; j++)
	                g[i][j] = s.charAt(j) - '0';
	        }
			for(int i=0;i<vn;i++){
			for(int j=0;j<vn;j++){
					cnt=0;
				if(g[i][j]==1 && !visited[i][j]){
//					bw.write(i+" "+j);
					dfs(i,j);
					pq.offer(cnt);
					total++;
				}
			}
		}
//			bw.write("total: "+total + "\n");
			System.out.println(total);
			while(!pq.isEmpty()){
				System.out.println(pq.poll());
			}
	      
	}
	static void dfs(int x,int y){
//		System.out.println(x+" "+y);
		visited[x][y]=true;
		cnt++;
		for(int i=0;i<4;i++){
			int sx = x+dx[i];
			int sy = y+dy[i];
			if(sx<0 || sx>=vn || sy<0 || sy>=vn){
				continue;
			}
			
			if(g[sx][sy]==1 && !visited[sx][sy])
				dfs(sx,sy);
		}

	}
	

}
