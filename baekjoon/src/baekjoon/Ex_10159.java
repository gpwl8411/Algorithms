package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_10159 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//플로이드와샬 저울
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean[][] fromTo = new boolean[n+1][n+1];
		boolean[][] toFrom = new boolean[n+1][n+1];
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			fromTo[from][to]=true;
			toFrom[to][from]=true;
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i==j)
						continue;
					if(fromTo[i][k]&&fromTo[k][j])
						fromTo[i][j]=true;
					if(toFrom[i][k]&&toFrom[k][j])
						toFrom[i][j]=true;
				}
			}
		}
		for(int i=1;i<=n;i++) {
			fromTo[i][i]=true;
			int num = 0;
			for(int j=1;j<=n;j++) {
				if(!(fromTo[i][j]||toFrom[i][j])) {
					num++;
				}
			}
			bw.append(num+"\n");
		}
		bw.flush();
	}

}
