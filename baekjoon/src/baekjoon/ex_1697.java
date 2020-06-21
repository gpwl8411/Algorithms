package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ex_1697 {
	static int[] g = new int[100004];
	static int[] dx={-1,1,2};


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		int me = Integer.parseInt(str[0]);
		int sister = Integer.parseInt(str[1]);
		
		Arrays.fill(g, -1);
		bfs(me,sister);
	}

	public static void bfs(int me,int sister) {
		//int min = 0;
		Queue<Integer> qx = new LinkedList<Integer>();
		int tempx=me;
		qx.offer(tempx);
		g[me]=0;
		while (!qx.isEmpty() && tempx !=g.length-1) {
			tempx = qx.poll();
			for (int k = 0; k < 3; k++) {
				int sx = tempx + dx[k];
				if(k==2)
					sx=tempx*dx[k];
				
				if (sx < 0 || sx > 100000) {
					continue;
				}
				if(g[sx]==-1){
					qx.offer(sx);
					g[sx] = g[tempx]+1;
				}
				
			}
		}

		System.out.println(g[sister]);
		//System.out.println(Arrays.toString(g));
		return;

	}

}