package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_1799 {

	static int[][] map,colors;
	static boolean[] visited;
	static int[] ans = new int[2];
	static int n;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 백트래킹 비숍
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[100];
		colors = new int[n][n]; // black = 1 , white = 0

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				colors[i][j] = i%2==j%2 ? 1 : 0;
			}
		}
		search(-1, 0, 1);//black
		search(-1, 0, 0);//white

		System.out.println(ans[0] + ans[1]);
	}

	static void search(int v, int cnt,int color) {
			if (ans[color] < cnt) {
				ans[color] = cnt;
			}			
	 
	    for (int i = v + 1; i < n * n; i++) {
	        int r = i / n;
	        int c = i % n;
	 
	        if (colors[r][c] != color) 
	            continue;
	 
	        if (map[r][c] == 1) {
	            if (check(r, c)) {
	                visited[i] = true;
	                search(i, cnt + 1, color);
	            }
	        }
	    }
	    if (v == -1) return;
	    visited[v] = false;
	}
	
	public static boolean check(int r, int c) {
		
		int[] dx = { -1, 1, 1, -1 };
		int[] dy = { -1, -1, 1, 1 };


	    for (int i = 0; i < 4; i++) {
	        int nx = dx[i] + r;
	        int ny = dy[i] + c;
	        int v = nx * n + ny;
	 
	        for (int j = 1; j < n; j++) {
	            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
	                if (visited[v]) {
	                    return false;
	                }
	            }
	            nx += dx[i];
	            ny += dy[i];
	            v = nx * n + ny;
	        }
	    }
	    return true;
	}



}
