package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Ex_2251 {

	static boolean[] ans;
	static int[] bucket;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//물통 bfs
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		bucket = new int[3];
		ans = new boolean[201];
		for(int i=0;i<3;i++) {
			bucket[i] = Integer.parseInt(st.nextToken());
		}
		bfs();
		for(int i=0;i<=bucket[2];i++) {
			if(ans[i])
				System.out.println(i);
		}
		
	}
	static void bfs() {
		boolean[][] visited = new boolean[201][201];
		int[] from = {0,0,1,1,2,2};
		int[] to = {1,2,0,2,0,1};
		Queue<Pair> q = new LinkedList<>();
		
		q.add(new Pair(0,0));
		visited[0][0] = true;
		ans[bucket[2]] = true;
		
		while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int z = bucket[2]-x-y;
 
            for(int k=0; k<6; k++) {
                int [] next = {x, y, z};
                next[to[k]] += next[from[k]];
                next[from[k]] = 0;
 
                if(next[to[k]] > bucket[to[k]]) { 
                    next[from[k]] = next[to[k]] - bucket[to[k]]; 
                    next[to[k]] = bucket[to[k]]; 
                }
                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new Pair(next[0], next[1]));
                    if(next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }

	}

}
class Pair{
	int x;
	int y;
	Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
	
}
