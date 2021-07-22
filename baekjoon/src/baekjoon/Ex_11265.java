package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_11265 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//플로이드와샬- 끝나지 않는 파티
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(map[i][j] > map[i][k]+map[k][j])
						map[i][j] = map[i][k]+map[k][j];
				}
			}
		}
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long time = Long.parseLong(st.nextToken());
			if(map[a][b] <= time)
				bw.append("Enjoy other party\n");
			else
				bw.append("Stay here\n");
		}
		bw.flush();
	}

}
