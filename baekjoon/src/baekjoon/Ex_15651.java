package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_15651 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 백트래킹 N과 M (1)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		permutation(new int[n], n, m, 0);

		System.out.println(sb.toString());

	}

	static void permutation(int[] arr, int n, int r, int depth) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[depth] = i + 1;
			permutation(arr, n, r, depth + 1);

		}

	}

}

