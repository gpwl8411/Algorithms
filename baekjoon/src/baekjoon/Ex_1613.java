package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ex_1613 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//최단거리 역사
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][n+1];
		
		while(k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = -1;
			arr[b][a] = 1;
		}		
		for(int i=1;i<=n;i++){//거쳐가는 노드
			for(int j=1;j<=n;j++) {//시작 노드
				for(int l=1;l<=n;l++) {//끝 노드
					if(arr[j][l]==0) {
						if(arr[j][i]==arr[i][l])
							arr[j][l]=arr[j][i];
					}
				}
			}
		}
		
		int s = Integer.parseInt(br.readLine());
		while(s-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.append(arr[a][b]+"\n");
		}
		bw.flush();
	}

}
