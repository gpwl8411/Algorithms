package baekjoon;
import java.util.*;
public class coloringbook {
    static boolean visited[][];
	static int g[][];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
	static int cnt=0;
	static int total=0;
   public static void main(String[] args) throws Exception{
	  int[][] picture =  {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
	  int m=6;
	  int n=4;
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      
      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      g = picture;
	  visited = new boolean[m][n];
	  bfs(0,0,m,n);
	        
//			for(int i=0;i<m;i++){
//			for(int j=0;j<n;j++){
//					cnt=0;
//				if(g[i][j]!=0 && !visited[i][j]){
////					bw.write(i+" "+j);
//					dfs(i,j,m,n);
//					pq.offer(cnt);
//					total++;
//				}
//			}
//		}
//			bw.write("total: "+total + "\n");
//      answer[0]=total;
////      answer[1]=pq.poll();
//			// System.out.println(total);
//      int num=0;
//			 while(!pq.isEmpty()){
//				 
//				 if(num==total-1){
//					 answer[1]=pq.poll();
//					 continue;
//				 }
//				 pq.poll();
//				 num++;
//			 	
//			 }
//      System.out.println(answer[0]+" "+answer[1]);
  }
    static void dfs(int x,int y,int m,int n){
    	
         cnt++;
		visited[x][y]=true;
		for(int i=0;i<4;i++){
			int sx = x+dx[i];
			int sy = y+dy[i];
			if(sx<0 || sx>=m || sy<0 || sy>=n){
				continue;
			}
			
			if(g[sx][sy]==g[x][y] && !visited[sx][sy])
				dfs(sx,sy,m,n);
		}

	}
  //-----------------------------------------------------------------위에 dfs 아래 bfs
    static void bfs(int x,int y,int m,int n){
        
//    	int cnt =0;
		Queue<Integer> xq = new LinkedList();
		Queue<Integer> yq = new LinkedList();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				cnt=0;
				if(g[i][j]!=0 && !visited[i][j]){
					//cnt++;
			    	visited[x][y]=true;
					xq.add(i);
					yq.add(j);
					total++;
                    cnt++;
                   // answer[0]++;
				}
				
				while(!xq.isEmpty()&&!yq.isEmpty()){
					x = xq.poll();
					y = yq.poll();		
					for(int k=0;k<4;k++){
						int sx = x+dx[k];
						int sy = y+dy[k];
						if(sx<0 || sx>=m || sy<0 || sy>=n){
							continue;
						}
						
						if(g[sx][sy]==g[x][y] && !visited[sx][sy]){
							xq.add(sx);
							yq.add(sy);
							visited[sx][sy]=true;
							cnt++;
							
						}
					}
					
						
				}
				pq.offer(cnt);
			}
		}
		
		int num=0;
		while(!pq.isEmpty()){
//			 
			 if(num==total-1){
				 cnt=pq.poll();
				 continue;
			 }
			 pq.poll();
			 num++;
		 	
		 }
		System.out.println(total+" "+cnt);
    }
}


