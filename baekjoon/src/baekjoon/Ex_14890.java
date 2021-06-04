package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_14890 {

	static int[][] map;
	static int n, l;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 삼성 sw역량 테스트 경사로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += install(false, i);// 가로
			ans += install(true, i);// 세로
		}
		System.out.println(ans);

	}

	static int install(boolean dir, int idx) {
		int cnt = 1;
		int tmp = dir ? map[0][idx] : map[idx][0];
		for (int i = 1; i < n; i++) {
			int cur = dir ? map[i][idx] : map[idx][i];
			if (tmp != cur) {
				if (Math.abs(tmp - cur) > 1)
					return 0;

				if (tmp > cur) {
					cnt = 0;
					boolean flag = true;
					for (int j = i; j < n; j++) {
						if (cur == (dir ? map[j][idx] : map[idx][j]))
							cnt++;
						else
							break;
						if (cnt == l) {
							tmp = cur;
							cnt = 0;
							i = j;
							flag = false;
							break;
						}
					}
					if (flag)
						return 0;

				} else {
					if (cnt >= l) {
						tmp = cur;
						cnt = 1;
					} else {
						return 0;
					}
				}
			} else {
				cnt++;
			}
		}
		return 1;
	}

}
