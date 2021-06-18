package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_15684 {

	static int[][] map;
	static int n, m, h;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 삼성 sw역량 테스트 사다리 조작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h + 1][n + 1];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[x][y + 1] = -1;
		}
		install(1,1,0);	
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
	}

	static void install(int x,int y,int cnt) {
		if (play()) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (cnt == 3) {
			return;
		}
		for (int i = x; i <= h; i++) {
			for (int j = y; j < n; j++) {
				if (check(i, j)) {
					map[i][j] = 1;
					map[i][j + 1] = -1;
					install(x,y+1,cnt + 1);
					map[i][j] = 0;
					map[i][j + 1] = 0;
				}
			}
		}
	}

	static boolean play() {
		for (int y = 1; y <= n; y++) {
			int m = y;
			for (int x = 1; x <= h; x++) {
				m += map[x][m];
			}
			if(m!=y)
				return false;
		}
		return true;
	}

	static boolean check(int x, int y) {
		if (map[x][y] == 1 || map[x][y] == -1 
				|| (y+1 <= n && ( map[x][y+1] == 1 || map[x][y+1] == -1))) {
				return false;
		}
		return true;
	}

}
