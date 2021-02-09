package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_9663 {
	static int[] board;
	static int n;
	static int ans=0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//N-Queen
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		board = new int[n];
		solve(0);
		System.out.println(ans);
		
	}
	static boolean check(int row) {
		for(int i=0;i<row;i++) {
			if(board[i] == board[row] || (row - i) == Math.abs(board[i] - board[row])) {
				return false;
			}
		}
		return true;
	}
	static void solve(int row) {
		if(row >= n) {
			ans++;
			return;
		}
		for(int col=0;col<n;col++) {
			board[row] = col;
			
			if(check(row)) {
				solve(row+1);
			}
		}
	}

}
//다른 방식 참고 코드
//public class Main{
//
//	static int N, data = 0;
//	static int[][] result, check;
//	
//	public static void main(String args[]) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		N = Integer.parseInt(br.readLine());
//		
//		result = new int[N][N];
//		check = new int[N][N];
//		
//		dfs(0);
//		
//		System.out.println(data);
//	}
//	
//	static void dfs(int num) {
//		
//		if (num == N) {
//			data++;
//			return;
//		}
//		
//		for (int i = 0; i < N; i++) {
//			if (num != 0) {
//				if (check[num][i] > 0) {
//					continue;
//				}
//			}
//			
//			//false로 만들기
//			int p = i, m = i;
//			for (int j = num + 1; j < N; j++) {
//				p++;
//				m--;
//				if (p < N) {
//					check[j][p] += 1;
//				}
//				if (m >= 0) {
//					check[j][m] += 1;
//				}
//			}
//			
//			for (int j = num + 1; j < N; j++) {
//				check[j][i] += 1;
//			}
//
//			dfs(num + 1);
//			
//			//true로 만들기
//			int p1 = i, m1 = i;
//			for (int j = num + 1; j < N; j++) {
//				p1++;
//				m1--;
//				if (p1 < N) {
//					check[j][p1] -= 1;
//				}
//				if (m1 >= 0) {
//					check[j][m1] -= 1;
//				}
//			}
//			
//			for (int j = num + 1; j < N; j++) {
//				check[j][i] -= 1;
//			}
//
//		}
//	}
//	
//	
//}
