package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1629 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(a,b,c));

	}

	static long pow(int a, int b,int c) {
		if (b == 0)
			return 1;

		long n = pow(a, b / 2,c);
		long square = n * n %c;

		if (b % 2 == 0)
			return square;
		else
			return a * square %c;

	}
}
