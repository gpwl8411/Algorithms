package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ex_1260 {
	static boolean visited[];
	static long g[][];
	static int vn;
	static int en;
	static int start;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
//		String data = input.nextLine();
		vn = input.nextInt();
		en = input.nextInt();
		start = input.nextInt();
		
		g = new long[vn][vn];
		visited = new boolean[vn];
		for(int i=0;i<en;i++){
//			String e = input.nextLine();
			int n = input.nextInt();
			int m =input.nextInt();
			g[n-1][m-1] = 1;
			g[m-1][n-1] = 1;
		}
		dfs(start);
		for(int j=0; j< vn; j++){
            visited[j]=false;
        }
        System.out.println();

		bfs(start);
	}
	public static void dfs(int s){
		visited[s-1]=true;
		System.out.print(s+" ");
		for(int i=0;i<vn;i++){
			if(g[s-1][i]==1 && !visited[i]){
				dfs(i+1);
			}
		}
//		for(inti=0;i<)
//		return "";
	}
	public static void bfs(int s){
		visited[s-1] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);
		System.out.print(s+" ");
		int temp;
		while(!q.isEmpty()){
			temp = q.poll();
			for(int i=0;i<vn;i++){
				if(g[temp-1][i]==1 && !visited[i]){
					visited[i]=true;
					q.offer(i+1);
					System.out.print((i+1)+" ");
				}
			}
		}
		
//		return "";
	}

}
