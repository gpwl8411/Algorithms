//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class ex_13460 {
//	static char g[][];
//	static int x;
//	static int y;
//	static int[] dx = { 1, -1, 0, 0 };
//	static int[] dy = { 0, 0, 1, -1 };
//	public static boolean[][][][] visited;
//	public static void main(String[] args) throws Exception{
//		// TODO Auto-generated method stub
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//		String[] str = in.readLine().split(" ");
//		y = Integer.parseInt(str[0]);
//		x = Integer.parseInt(str[1]);
//		g = new char[x][y];
//		int rx = 0,ry = 0,bx = 0,by = 0;
//		for (int i = 0; i < x; i++) {
//			str = in.readLine().split("");
//			for (int j = 0; j < y; j++) {
//				
//				g[i][j] = str[j].charAt(0);
//				if(g[i][j]=='R'){
//					rx=i;
//					ry=j;
//				}
//				if(g[i][j]=='B'){
//					bx=i;
//					by=j;
//				}
//			}
//		}
//
//		bfs(rx,ry,bx,by);
//
//	}
//	public static void bfs(int rx,int ry,int bx,int by) {
//		int cnt = 0;
//
//		
//		while (!qbx.isEmpty()) {
//			tempbx = qbx.poll();
//			tempby = qby.poll();
//
//			for (int k = 0; k < 4; k++) {
//				int sx = tempbx + dx[k];
//				int sy = tempby + dy[k];
//				if (sx < 0 || sx >= x || sy < 0 || sy >= y) {
//					continue;
//				}
//				if (g[sx][sy] == '#') {
//					cnt++;
//					continue;
//				}
//				if(g[sx][sy]=='.'){
//					qbx.offer(sx);
//					qby.offer(sy);
//					continue;
//				}
//				if (g[sx][sy] == 'O') {
//					System.out.println("-1");
//					return;
//				}
//
////				g[sx][sy] = g[tempx][tempy] + 1;
//			}
//			
//		}
//
//	
//
//		return;
//
//	}
//
//}
////////////////////////////////////여기서부터 다른 사람 코드
/*
 import java.io.*;
import java.util.*;
 
public class Main {
    public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int n, m;
    public static int rx, ry, bx, by;
    public static int[][] map;
    public static boolean[][][][] visited;
    public static Queue<Pair> q = new LinkedList<>();
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= s.length(); j++) {
                int tmp = 0;
                switch (s.charAt(j - 1)) {
                    case '#':
                        tmp = -1;
                        break;
                    case '.':
                        tmp = 0;
                        break;
                    case 'R':
                        tmp = 1;
                        rx = i;
                        ry = j;
                        break;
                    case 'B':
                        tmp = 2;
                        bx = i;
                        by = j;
                        break;
                    case 'O':
                        tmp = 3;
                        break;
                }
                map[i][j] = tmp;
            }
        }
        System.out.println(bfs());
    }
 
    public static int bfs() {
        q.add(new Pair(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.cnt > 10) continue;
            if (map[p.bx][p.by] == 3) continue;
            if (map[p.rx][p.ry] == 3) return p.cnt;
 
            for (int i = 0; i < 4; i++) {
                //빨간 구슬 상하좌우 끝까지 이동
                int next_rx = p.rx, next_ry = p.ry;
                while (true) {
                    //다음 지점이 벽이랑 구멍이 아니면
                    if (map[next_rx][next_ry] != -1 && map[next_rx][next_ry] != 3) {
                        next_rx += dx[i];
                        next_ry += dy[i];
                    } else {
                        //다음 지점이 벽이면
                        if (map[next_rx][next_ry] == -1) {
                            next_rx -= dx[i];
                            next_ry -= dy[i];
                        }
                        break;
                    }
                }
 
                //파란 구슬 상하좌우 끝까지 이동
                int next_bx = p.bx, next_by = p.by;
                while (true) {
                    //다음 지점이 벽이랑 구멍이 아니면
                    if (map[next_bx][next_by] != -1 && map[next_bx][next_by] != 3) {
                        next_bx += dx[i];
                        next_by += dy[i];
                    } else {
                        //다음 지점이 벽이면
                        if (map[next_bx][next_by] == -1) {
                            next_bx -= dx[i];
                            next_by -= dy[i];
                        }
                        break;
                    }
                }
 
                //구한 Red, Blue 의 점이 서로 같은데 'O'가 아닌 경우
                //더 움직인 구슬의 dx[i], dy[i]를 빼준다
                if (next_rx == next_bx && next_ry == next_by) {
                    if (map[next_rx][next_ry] != 3) {
                        int red_cost = Math.abs(next_rx - p.rx) + Math.abs(next_ry - p.ry);
                        int blue_cost = Math.abs(next_bx - p.bx) + Math.abs(next_by - p.by);
                        if (red_cost > blue_cost) {
                            next_rx -= dx[i];
                            next_ry -= dy[i];
                        } else {
                            next_bx -= dx[i];
                            next_by -= dy[i];
                        }
                    }
                }
 
                //next 점이 방문한적 없다면 큐에 추가
                if (!visited[next_rx][next_ry][next_bx][next_by]) {
                    visited[next_rx][next_ry][next_bx][next_by] = true;
                    q.add(new Pair(next_rx, next_ry, next_bx, next_by, p.cnt + 1));
                }
            }
        }
        return -1;
    }
 
    public static class Pair {
        int rx, ry, bx, by, cnt;
 
        public Pair(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
}

 
 */
