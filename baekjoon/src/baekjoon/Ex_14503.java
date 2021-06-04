package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex_14503 {

	static int[][] map;
	static int cnt=1;
	static int n,m;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//삼성 sw 역량테스트 -로봇 청소기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[r][c]=2;
		go(r,c,d);
		System.out.println(cnt);
	
	}
	static void go(int r, int c, int d) {
		d = d == 3 ? 1 : d == 1 ? 3 : d;
		int[] dx = {-1,0,1,0}; // 북 서  남 동
		int[] dy = {0,-1,0,1};
		Stack<Integer> back = new Stack<>();
		
		while(true) {
			boolean flag = true;
			for(int i=1;i<=4;i++) {
				int sx = r+dx[(d+i)%4];
				int sy = c+dy[(d+i)%4];
				if(sx < 0 || sy < 0 || sx >= n || sy >= m)
					continue;
				if(map[sx][sy]==1 || map[sx][sy]==2)
					continue;
				
				r=sx;
				c=sy;
				d=(d+i)%4;
				flag = false;
				cnt++;
				map[r][c]=2;
				break;

			}
			if(flag) {
				d =  (d+4)%4;
				r = r+dx[(d+2)%4];
				c = c+dy[(d+2)%4];
				if(r < 0 || c < 0 || r >= n || c >= m)
					break;
				if(map[r][c]==1)
					break;
			}
			
		}
			
	}
}
