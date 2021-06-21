package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Ex_16235 {

	static int[][] map, a;
	static int n, cnt;
	static Deque<Integer>[][] q;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 삼성 sw역량 테스트-나무 재태크
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		a = new int[n + 1][n + 1];
		map = new int[n + 1][n + 1];
		q = new ArrayDeque[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
				q[i][j] = new ArrayDeque<>();
			}
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			q[x][y].add(age);
		}
		while (k-- > 0) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(cnt);
	}

	static void spring() {
		cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int size = q[i][j].size();
				for (int k = 0; k < size; k++) {
					int age = q[i][j].pollFirst();
					if (map[i][j] >= age) {
						map[i][j] -= age;
						q[i][j].addLast(age + 1);
					} else {
						q[i][j].addLast(age);
						q[i][j].addLast(-1);
					}
				}
			}
		}
	}

	static void summer() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				while(!q[i][j].isEmpty() && q[i][j].peekLast() == -1) {
					q[i][j].pollLast();
					map[i][j]+=q[i][j].pollLast()/2;
				}
			}
		}
	}

	static void fall() {
		int[] dx = { 0, 1, 0, -1, 1, -1, 1, -1 };
		int[] dy = { 1, 0, -1, 0, 1, -1, -1, 1 };
	
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int oneCnt = 0;
				Iterator<Integer> iterator = q[i][j].iterator();
				while(iterator.hasNext()) {
					int age = iterator.next();
					if (age % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int sx = i + dx[d];
							int sy = j + dy[d];

							if (sx <= 0 || sy <= 0 || sx > n || sy > n)
								continue;
							q[sx][sy].addFirst(1);
						}
					}
				}
			}
		}
	}

	static void winter() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] += a[i][j];
				cnt += q[i][j].size();
			}
		}
	}

}
