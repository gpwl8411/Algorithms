package programers;

import java.util.LinkedList;
import java.util.Queue;

public class KakaoIntern21_CheckDistance {

	static int[] dx = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, 0, -1, 0, 1, -1, -1, 1, };
	static char[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 카카오인턴 21 거리두기 확인하기
		// 맨해튼 거리 |r1-r2|+|c1-c2|
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		int[] ans = new int[places.length];
		for (int i = 0; i < places.length; i++) {
			map = new char[5][5];
			Queue<int[]> person = new LinkedList<>();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					map[j][k] = places[i][j].charAt(k);
					if (map[j][k] == 'P')
						person.add(new int[] { j, k });
				}
			}
			ans[i] = check(person);
		}

		for(int i : ans)
			System.out.println(i);
	}

	static int check(Queue<int[]> q) {

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			boolean[] chkX = new boolean[4];// 동남서북
			for (int i = 0; i < 4; i++) {
				boolean flag = false;
				for (int j = 1; j <= 2; j++) {
					int sx = pos[0] + dx[i] * j;
					int sy = pos[1] + dy[i] * j;

					if (sx < 0 || sy < 0 || sx >= 5 || sy >= 5)
						continue;

					if (map[sx][sy] == 'X') {
						if (j == 1) {
							chkX[i]=true;
						}
						flag = true;
						continue;
					}
					if (map[sx][sy] == 'P' && !flag) 
						return 0;
				}
			}
			for (int i = 4; i < 8; i++) {
				int sx = pos[0] + dx[i];
				int sy = pos[1] + dy[i];

				if (sx < 0 || sy < 0 || sx >= 5 || sy >= 5)
					continue;
				if(map[sx][sy]=='P' && (!chkX[i-4] || !chkX[(i-4+1)%4])) 
					return 0;
				
				
			}
		}
		return 1;
	}

}
