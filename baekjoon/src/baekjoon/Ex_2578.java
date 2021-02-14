//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class Ex_2578 {
//
//	static Map<Integer, Pair> map;
//	static boolean[][] bingo;
//	static boolean diag1,diag2;
//	static int bingoNum = 0;
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//
//		// 빙고 구현
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		map = new HashMap<>();
//		bingo = new boolean[5][5];
//
//		int ans = 0;
//
//		for (int i = 0; i < 10; i++) {
//			st = new StringTokenizer(br.readLine());
//			if (ans != 0)
//				continue;
//
//			for (int j = 0; j < 5; j++) {
//				int n = Integer.parseInt(st.nextToken());
//
//				if (i < 5) {
//					map.put(n, new Pair(i, j));
//				} else {
//
//					go(n);
//					if (bingoNum >= 3) {
//						ans = (i-5) * 5 + j + 1;
//						break;
//					}
//				}
//			}
//			
//		}
//		System.out.println(ans);
//
//	}
//
//	static void go(int n) {
//		Pair p = map.get(n);
//		bingo[p.x][p.y] = true;
//		// 가로
//		for (int i = 0; i < 5; i++) {
//			if (!bingo[p.x][i])
//				break;
//			if (i == 4)
//				bingoNum++;
//		}
//		// 세로
//		for (int i = 0; i < 5; i++) {
//			if (!bingo[i][p.y])
//				break;
//			if (i == 4)
//				bingoNum++;
//		}		
//		// 대각선\
//		if(!diag1)
//		outer: 
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				if (i == j && !bingo[i][j])
//					break outer;
//			}
//			if (i == 4) {
//				bingoNum++;
//				diag1=true;
//			}
//		}
//		//대각선 /
//		if(!diag2)
//		outer:
//		for (int i = 0; i < 5; i++) {
//			for(int j=0;j<5;j++) {
//			if (j == (4 - i) && !bingo[i][j])
//				break outer;
//			}
//			if(i==4) {
//				bingoNum++;
//				diag2=true;
//			}
//			
//		}
//		
//	}
//
//}
//
//class Pair {
//	int x;
//	int y;
//
//	Pair(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}