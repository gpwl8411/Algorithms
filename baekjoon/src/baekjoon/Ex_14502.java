package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_14502 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] copyMap;
	static List<Pairs> virusList;
	static int zone=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		List<Pairs> list = new ArrayList<>();
		virusList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					list.add(new Pairs(i, j));
				else if(map[i][j]==2)
					virusList.add(new Pairs(i,j));
			}
		}

		comb(list, new boolean[list.size()], 0, list.size(), 3);
		System.out.println(zone);

	}

	static void comb(List<Pairs> arr, boolean[] visited, int depth, int n, int r) {
		if (r == 0) {
			int cnt=0;
			copyMap = new int[N][M];
			for (int j = 0; j < copyMap.length; j++) {
				System.arraycopy(map[j], 0, copyMap[j], 0, M);
			}
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					copyMap[arr.get(i).x][arr.get(i).y] = 1;
				}
			}
			for(int i=0;i<virusList.size();i++) {
				spread(virusList.get(i),2);
			}
			for(int i=0;i<copyMap.length;i++) {
				for(int j=0;j<copyMap[0].length;j++) {
					if(copyMap[i][j]==0) {
						cnt+=spread(new Pairs(i,j),0);
						}
				}
			}
			zone = Math.max(cnt, zone);
			return;
		}

		if (depth == n) {
			return;
		}

		visited[depth] = true;
		comb(arr, visited, depth + 1, n, r - 1);

		visited[depth] = false;
		comb(arr, visited, depth + 1, n, r);
	}

	static int spread(Pairs p,int flag) {
		int cnt=1;
		Queue<Pairs> q = new LinkedList<>();
		q.add(p);
		boolean[][] visited = new boolean[N][M];
		while (!q.isEmpty()) {
			Pairs pair = q.poll();
			visited[pair.x][pair.y]=true;
			copyMap[pair.x][pair.y] = flag==0?-1:2;
			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 };

			for (int i = 0; i < 4; i++) {
				int sx = pair.x + dx[i];
				int sy = pair.y + dy[i];

				if (sx < 0 || sy < 0 || sx >= N || sy >= M) {
					continue;
				}
				if (visited[sx][sy] ||copyMap[sx][sy] == 1 || copyMap[sx][sy] == (flag==0?2:2)) {
					continue;
				}
				visited[sx][sy]=true;
				copyMap[sx][sy] = flag==0?-1:2;
				cnt++;
				q.add(new Pairs(sx,sy));
			}
		}
		return cnt;
	}
	
}

class Pairs {
	int x;
	int y;

	Pairs(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
