package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ex_7569 {
	static int x;
	static int y;
	static int z;
	static long[][][] g;
	static int[] dx={1,-1,0,0,0,0};
	static int[] dy={0,0,1,-1,0,0};
	static int[] dz={0,0,0,0,1,-1};

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		z = Integer.parseInt(str[0]);// ¿­
		y = Integer.parseInt(str[1]);// Çà
		x = Integer.parseInt(str[2]);// ¸é
		g = new long[x][y][z];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				str = in.readLine().split(" ");
				for (int k = 0; k < z; k++) {
					g[i][j][k] = Integer.parseInt(str[k]);
				}

			}
		}

		bfs();
	}
	public static void bfs() {
		int max = 0;
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qz = new LinkedList<Integer>();
		int tempx;
		int tempy;
		int tempz;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for(int k=0;k<z;k++){
					if (g[i][j][k] == 1) {
						qx.offer(i);
						qy.offer(j);
						qz.offer(k);
					}
				}
				

			}
		}
		while (!qx.isEmpty()) {
			tempx = qx.poll();
			tempy = qy.poll();
			tempz = qz.poll();
			for (int k = 0; k < 6; k++) {
				int sx = tempx + dx[k];
				int sy = tempy + dy[k];
				int sz = tempz + dz[k];
				//System.out.println(dx[k]+","+dy[k]+","+dz[k]);
				if (sx < 0 || sx >= x || sy < 0 || sy >= y||sz < 0 || sz >= z) {
					continue;
				}
				if (g[sx][sy][sz] != 0) {
					continue;
				}
				qx.offer(sx);
				qy.offer(sy);
				qz.offer(sz);
				//System.out.println(sx+","+sy+","+sz);
				g[sx][sy][sz] = g[tempx][tempy][tempz] + 1;
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for(int k=0;k<z;k++){
					if (g[i][j][k] == 0) {
						System.out.println("-1");
						return;

					}
					max = (int) Math.max(g[i][j][k], max);
				}
				

			}
		}
		System.out.println(max-1);
		return;

	}

}
