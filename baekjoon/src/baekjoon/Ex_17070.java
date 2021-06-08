package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_17070 {

	static int[][] map;
	static int[] dx = { 0, 1, 1 };// 가로,세로,대각선
	static int[] dy = { 1, 0, 1 };
	static int n, cnt = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 삼성 a형기출 - 파이프 옮기기1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move(0, 1, 0);
		System.out.println(cnt);
	}

	static void move(int x, int y, int dir) {
		if (x == n - 1 && y == n - 1 && map[x][y] != 1) {
			cnt++;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int sx = x + dx[i];
			int sy = y + dy[i];

			if ((dir == 0 && i == 1) || (dir == 1 && i == 0))
				continue;
			if (sx < 0 || sy < 0 || sx >= n || sy >= n)
				continue;

			if ((i == 0 || i == 1) && map[sx][sy] == 1)
				continue;
			if (i == 2 && (map[sx][sy] == 1 || map[sx - 1][sy] == 1 || map[sx][sy - 1] == 1))
				continue;

			move(sx, sy, i);

		}
	}

}
/**
 * class Case {
	int left;
	int above;
	int diag;
	
	public Case(int left, int above, int diag) {
		this.left = left;
		this.above = above;
		this.diag = diag;
	}
}

public class Main {
	private static boolean[][] map;
	private static Case[][] arr; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N];
		StringTokenizer st;
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input==0;
			}
		}
		
		
		arr = new Case[N+1][N];
		for(int i=2; i<N; i++) {
			arr[0][i] = new Case(0, 0, 0);
			arr[i][1] = new Case(0, 0, 0);
		}
		arr[N][1] = new Case(0, 0, 0);
		arr[1][1] = new Case(1, 0, 0);
		
		for(int i=1; i<N+1; i++) {
			for(int j=2; j<N; j++)
				makeCase(i, j);
		}
		
		System.out.print(arr[N][N-1].left + arr[N][N-1].above + arr[N][N-1].diag);
	}

	private static void makeCase(int row, int col) {
		if(!map[row][col]) {
			arr[row][col] = new Case(0, 0, 0);
			return;
		}
		
		int l = 0, a = 0, d = 0;
		Case temp;
		
		temp = arr[row][col-1];
		l = temp.left + temp.diag;
		
		temp = arr[row-1][col];
		a = temp.above + temp.diag;
		
		if(map[row][col-1] && map[row-1][col] && map[row-1][col-1]) {
			temp = arr[row-1][col-1];
			d = temp.left + temp.above + temp.diag;
		}
		
		arr[row][col] = new Case(l, a, d);
	}
}
 */
/*
 * // [1][1]에서 출발해서 -> [x][y]까지 오는 경우의 수 ==> [x][y]에서 시작해서 [r][c]까지 가는 경우의 수  계속 쪼개서 더해가면됨
// 세가지 방법으로 퍼져나갈 수 있는데  대신, (45회전가능) 가로는 -> 가로,대각선만 가능 , 세로는 -> 세로, 대각선만 가능 , 대각선은 -> 가로 세로 대각선 가능
// dp[x][y][가로] ->  이전 가로에서 온얘랑 [x-1][y][가로], 대각선에서 온얘랑 [x-1][y-1][대각선] 더하기


public class Main {
	
	static int N, ans;
	static boolean isPossible;
	static int[][] map;
	static int[][][] dp;
//	static int[] dy = {1, 0, 1};
//	static int[] dx = {0, 1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1]; // 걍 0,0부터 출발 -> [N-1][N-1]까지 이동
		dp= new int[N+1][N+1][3];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		
		
		//가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로
		// 파이프 오른쪽 끝이 이동한다고 생각하면 됨 (0,1)부터 시작 -> (N-1)(N-1)까지
		// 세번째 파라미터 가로 : 1, 세로 : 2, 대각선 :  3 으로 생각하자
		
		dp[1][2][0] = 1;
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				if(map[r][c] == 1) continue;
				
				dp[r][c][0] += dp[r][c-1][0] + dp[r][c-1][2];
				dp[r][c][1] += dp[r-1][c][1] + dp[r-1][c][2];
				
				if(map[r-1][c] == 0 && map[r][c-1] == 0) {
					dp[r][c][2] += dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2];
				}
			}
		}
		
		
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
		}
 * */
