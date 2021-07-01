package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Ex_2407 {
	public static void main(String[] args) throws Exception{
		//dp 조합-n!/(n-r)!r!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		BigInteger[][] comb = new BigInteger[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=i;j++) {
				if(j==i || j==0)
					comb[i][j]=new BigInteger("1");
				else
					comb[i][j]=comb[i-1][j-1].add(comb[i-1][j]);
			}
		}
		System.out.println(comb[n][r]);
	}
}
/**
 * public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            a = a.multiply(new BigInteger(String.valueOf(n-i)));
            b = b.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        System.out.println(a.divide(b));
    }
}
 */