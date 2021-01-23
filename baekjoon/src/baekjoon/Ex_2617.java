package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_2617 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		// 구슬찾기 플로이드 와샬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][n+1];
		int half = (n/2)+1;
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//크기 a>b
			arr[a][b] = 1; // a가 b보다 큼   a<-b
			arr[b][a] = -1; // b가 a보다 작음 b->a
		}
		for(int i=1;i<=n;i++) {//거쳐가는 노드
			for(int j= 1;j<=n;j++) {//출발 노드
				for(int k=1;k<=n;k++) {//도착 노드
					if(arr[k][i] != 0 && arr[j][i] == arr[i][k])
						arr[j][k] = arr[j][i];
				}
			}
		}
		 int[] big = new int[n+1];
		    int[] small = new int[n+1];

		    for (int i = 1; i <= n; i++ ) {
		        for (int j = 1; j <= n; j++) {

		            if (arr[i][j] == 1) 
		                big[i]++;
		            
		            if (arr[i][j] == -1) 
		                small[i]++;
		            
		        }
		    }
		    int ans=0;
		    for(int i=1;i<=n;i++) {
		    	if(big[i] >= half) ans++;
		    	if(small[i] >= half ) ans++;
		    }
		    System.out.println(ans);

	}

}
