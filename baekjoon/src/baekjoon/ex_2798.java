package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_2798 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] str = in.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int arr[] = new int[n];
		int max = 0;
		str = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == i)
					continue;
				for (int k = 0; k < n; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					//System.out.println(sum);
					if (k == i || k == j)
						continue;
					if (sum <= m)
						max = Math.max(max, sum);
				}
			}
		}
		System.out.println(max);
	}

}
