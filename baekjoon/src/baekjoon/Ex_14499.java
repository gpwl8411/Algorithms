package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_14499 {

	static int[][] map;
	static int[] dx = {0,0,-1,1};//동 서 북 남
	static int[] dy = {1,-1,0,0};
	static int[] dice = {0,0,0,0,0,0};
	static int n,m,x,y;
	static StringBuilder ans = new StringBuilder();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//삼성 sw역량테스트-주사위 굴리기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while(k-- > 0 ) {
			int dir = Integer.parseInt(st.nextToken())-1;
			go(dir);
		}
		System.out.println(ans);
	}
	static void go(int dir) {
		int sx = x+dx[dir];
		int sy = y+dy[dir];
		
		if(sx < 0 || sy < 0 || sx >= n || sy >= m) 
			return;
		
		x = sx;
		y = sy;
		//주사위
		int[] tmp = dice.clone();
		//동 서 북 남
		if(dir==0) {
			dice[0] = tmp[3];
			dice[3] = tmp[5];
			dice[5] = tmp[2];
			dice[2] = tmp[0];
		}
		else if(dir==1) {
			dice[0] = tmp[2];
			dice[3] = tmp[0];
			dice[5] = tmp[3];
			dice[2] = tmp[5];
		}
		else if(dir==2) {
			dice[0] = tmp[4];
			dice[1] = tmp[0];
			dice[5] = tmp[1];
			dice[4] = tmp[5];
		}else {
			dice[0] = tmp[1];
			dice[1] = tmp[5];
			dice[5] = tmp[4];
			dice[4] = tmp[0];
		}
		if(map[x][y]!=0) {
			dice[5] = map[x][y];
			map[x][y] = 0;
		}
		else {
			map[x][y] = dice[5];
		}
		ans.append(dice[0]+"\n");	
	}

}
