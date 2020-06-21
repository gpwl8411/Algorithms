package baekjoon;

import java.util.Scanner;

public class ex_2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] dp = new int[num];
		int[] g = new int[num];
		for(int i=0;i<num;i++){
			g[i]=input.nextInt();
		}
		for(int i=0;i<num;i++){
			if(i==0)
				dp[i]=g[i];
			else if(i==1)
				dp[i]=g[i]+dp[i-1];
			else if(i==2)
				dp[i]=Math.max(dp[i-1], Math.max(dp[i-2]+g[i],g[i-1]+g[i]));
			else
				dp[i]=Math.max(Math.max(dp[i-1],dp[i-2]+g[i]), dp[i-3]+g[i-1]+g[i]);
		}
		System.out.println(dp[num-1]);

	}

}
