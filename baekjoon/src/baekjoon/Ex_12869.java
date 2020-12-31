package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_12869 {

	static int[][] potion = { { 9, 3, 1 }, { 9, 1, 3 }, { 3, 9, 1 }, { 3, 1, 9 }, { 1, 9, 3 }, { 1, 3, 9 } };
	static int min = Integer.MAX_VALUE;
	static int[][][][] dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// dp 뮤탈리스크
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] scv = new int[3];

		for (int i = 0; i < n; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[61][61][61][70];
		for (int i = 0; i <= 60; i++) {
			for (int j = 0; j <= 60; j++) {
				for (int k = 0; k <= 60; k++) {
					Arrays.fill(dp[i][j][k], -1);

				}
			}
		}
		attack(scv[0], scv[1], scv[2], 0);
		System.out.println(min);
	}

	static int attack(int a, int b, int c, int cnt) {
		if (a < 0)a = 0;
		if (b < 0)b = 0;
		if (c < 0)c = 0;
		
		if (cnt >= min) {
			dp[a][b][c][cnt] = 0;
			return 0;
		}
		if (a <= 0 && b <= 0 && c <= 0) {
			min = Math.min(cnt, min);
			return 1;
		}

		if (dp[a][b][c][cnt] != -1) {
			return dp[a][b][c][cnt];
		}
		for (int i = 0; i < 6; i++) {
			if (attack(a - potion[i][0], b - potion[i][1], c - potion[i][2], cnt + 1) == 1) {
				dp[a][b][c][cnt] = 1;
			}
		}
		return 0;

	}

}
//다른사람 코드
//public class Main {
//
//    static int[][] attack = {
//            {1, 3, 9},
//            {1, 9, 3},
//            {3, 1, 9},
//            {3, 9, 1},
//            {9, 1, 3},
//            {9, 3, 1}
//    };
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[] num = new int[3];
//        Arrays.fill(num, 0);
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++){
//            num[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int[][][] d = new int[num[0] + 1][num[1] + 1][num[2] + 1];
//        for(int i = 0; i < num[0] +1; i++){
//            for(int j = 0; j < num[1] + 1; j++){
//                for(int k = 0; k < num[2] + 1; k++){
//                    d[i][j][k] = -1;
//                }
//            }
//        }
//
//        int ans = calc(num[0], num[1], num[2], d);
//        System.out.println(ans);
//    }
//
//    private static int calc(int num1, int num2, int num3, int[][][] d) {
//        if (num1 == 0 && num2 == 0 && num3 == 0)
//            return 0;
//        if (d[num1][num2][num3] != -1)
//            return d[num1][num2][num3];
//
//        int min = Integer.MAX_VALUE;
//        for(int i = 0; i < 6; i++){
//            int n1 = Math.max(num1 - attack[i][0], 0);
//            int n2 = Math.max(num2 - attack[i][1], 0);
//            int n3 = Math.max(num3 - attack[i][2], 0);
//            min = Math.min(calc(n1, n2, n3, d) + 1, min);
//        }
//        d[num1][num2][num3] = min;
//        return min;
//    }
//}
