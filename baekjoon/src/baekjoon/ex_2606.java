package baekjoon;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ex_2606 {
	static boolean visited[];
	static int g[][];
	static int vn;
	static int en;
	static int cnt=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		vn = input.nextInt();
		en = input.nextInt();
		
		g = new int[vn][vn];
		visited = new boolean[vn];
		for(int i=0;i<en;i++){
			int n = input.nextInt();
			int m =input.nextInt();
			g[n-1][m-1] = 1;
			g[m-1][n-1] = 1;
		}
		dfs(0);
		System.out.println(cnt);
	}
	public static void dfs(int s){
		visited[s]=true;
		for(int i=0;i<vn;i++){
			if(g[s][i]==1 && !visited[i]){
				cnt++;
				dfs(i);
			}
		}
	}

}
