package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex_15683 {

	static int n, m;
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Camera> list;
	static int listSize;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		list = new ArrayList<>();
		int wall = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;

				if (val != 0 && val != 6) {
					list.add(new Camera(i, j, val));
				}
				if (val == 6) {
					wall++;
				}

			}
		}
		listSize = list.size();
		dfs(0, 0);
		System.out.println(n * m - max - wall - listSize);

	}

	static void dfs(int idx, int cnt) {
		
		if (idx == listSize) {
			max = Math.max(max, cnt);
			return;
		}
		int[][] copyMap = new int[n][m];
		// 동서남북 0123
		switch (list.get(idx).num) {
		case 1:
			for (int i = 0; i < 4; i++) {
				int preCnt = cnt;
				for (int j = 0; j < copyMap.length; j++) {
					System.arraycopy(map[j], 0, copyMap[j], 0, m);
				}
				cnt = monitor(list.get(idx), cnt, i);

				dfs(idx + 1, cnt);
				cnt = preCnt;
				for (int j = 0; j < copyMap.length; j++) {
					System.arraycopy(copyMap[j], 0, map[j], 0, m);
				}
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				int preCnt = cnt;
				for (int j = 0; j < copyMap.length; j++) {
					System.arraycopy(map[j], 0, copyMap[j], 0, m);
				}
				cnt = monitor(list.get(idx), cnt, i);
				cnt = monitor(list.get(idx), cnt,i + 2);
				dfs(idx + 1, cnt);
				cnt = preCnt;
				for (int j = 0; j < copyMap.length; j++) {
					System.arraycopy(copyMap[j], 0, map[j], 0, m);
				}
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				int preCnt = cnt;
				for (int j = 0; j < copyMap.length; j++) {
					System.arraycopy(map[j], 0, copyMap[j], 0, m);
				}
				cnt = monitor(list.get(idx), cnt,  i);
				cnt = monitor(list.get(idx), cnt, (i + 1) % 4);
				dfs(idx + 1, cnt);
				cnt = preCnt;
				for (int j = 0; j < copyMap.length; j++) {
					System.arraycopy(copyMap[j], 0, map[j], 0, m);
				}
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				int count = 0;
				int preCnt = cnt;
				for (int k = 0; k < copyMap.length; k++) {
					System.arraycopy(map[k], 0, copyMap[k], 0, m);
				}
				for (int j = i; count < 3; j++) {
					cnt = monitor(list.get(idx), cnt,  j % 4);
					count++;
				}
				dfs(idx + 1, cnt);
				cnt = preCnt;
				for (int j = 0; j < copyMap.length; j++) {
					System.arraycopy(copyMap[j], 0, map[j], 0, m);
				}
			}
			break;
		case 5:
			int preCnt = cnt;
			for (int j = 0; j < copyMap.length; j++) {
				System.arraycopy(map[j], 0, copyMap[j], 0, m);
			}
			for (int i = 0; i < 4; i++) {
				cnt = monitor(list.get(idx), cnt, i);
			}
			dfs(idx + 1, cnt);
			cnt = preCnt;
			for (int j = 0; j < copyMap.length; j++) {
				System.arraycopy(copyMap[j], 0, map[j], 0, m);
			}
			break;
		}
	}

	static int monitor(Camera c, int cnt, int dir) {
		switch (dir) {
		case 0:
			for (int i = c.y; i < m; i++) {
				if (map[c.x][i] == 0) {
					map[c.x][i] = -1;
					cnt++;
				} else if (map[c.x][i] == 6) {
					break;
				}
			}
			break;
		case 1:
			for (int i = c.x; i < n; i++) {
				if (map[i][c.y] == 0) {
					map[i][c.y] = -1;
					cnt++;
				} else if (map[i][c.y] == 6) {
					break;
				}
			}
			break;
		case 2:
			for (int i = c.y; i >= 0; i--) {
				if (map[c.x][i] == 0) {
					map[c.x][i] = -1;
					cnt++;
				} else if (map[c.x][i] == 6) {
					break;
				}
			}
			break;
		case 3:
			for (int i = c.x; i >= 0; i--) {
				if (map[i][c.y] == 0) {
					map[i][c.y] = -1;
					cnt++;
				} else if (map[i][c.y] == 6) {
					break;
				}
			}
			break;
		}

		return cnt;
	}


}

class Camera {
	int x;
	int y;
	int num;

	Camera(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}
