package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_3980 {

	static int[][] map = new int[11][11];
	static boolean[] visited = new boolean[11];// 몇번자리
	static int max;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 백트래킹 선발명단
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			max = Integer.MIN_VALUE;
			Arrays.fill(visited, false);

			for (int i = 0; i < 11; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			select(0, 0);// 몇번선수,합계
			System.out.println(max);
		}

	}

	static void select(int idx, int sum) {
		if (idx == 11) {
			max = Math.max(sum, max);
			return;
		}
		for (int i = 0; i < 11; i++) {
			if (!visited[i] && map[idx][i] != 0) {
				visited[i] = true;
				select(idx + 1, sum + map[idx][i]);
				visited[i] = false;
			}
		}
	}

}
