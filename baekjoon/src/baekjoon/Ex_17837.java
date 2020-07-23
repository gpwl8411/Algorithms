package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex_17837 {
	final static int E = 1;
	final static int W = 2;
	final static int N = 3;
	final static int S = 4;
	
	static Stack<Integer>[][] moveMap; 
	static int[][] kInfo;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		moveMap = new Stack[n][n];
		kInfo = new int[k + 1][3];
		int trun = 1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				moveMap[i][j] = new Stack<>();
			}
		}
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			kInfo[i][0] = Integer.parseInt(st.nextToken()) - 1;
			kInfo[i][1] = Integer.parseInt(st.nextToken()) - 1;
			kInfo[i][2] = Integer.parseInt(st.nextToken());
			moveMap[kInfo[i][0]][kInfo[i][1]].push(i);
		}
		outer: while (true) {
			if (trun > 1000) {
				trun = -1;
				break;
			}

			// kinfo에서 1번말부터 검색한다
			for (int i = 1; i <= k; i++) {
				// 해당말의 위치에 가서 리스트에 값이 담겨져있는지 확인한다
				list = new ArrayList<>();
				int x = kInfo[i][0];
				int y = kInfo[i][1];
				int dir = kInfo[i][2];

				// pop을 통해 해당말이 나올때까지 담고
				while (!moveMap[x][y].isEmpty()) {
					if (moveMap[x][y].peek() == i) {
						list.add(moveMap[x][y].pop());
						break;
					} else {
						list.add(moveMap[x][y].pop());
					}
				}
				// 해당말의 방향으로 한칸 이동함 맵의 색을 확인하여 수행한다
				int[] resultArr;
				resultArr = moveDir(dir, x, y);
				x = resultArr[0];
				y = resultArr[1];
				int color;
				if (x >= n || y >= n || x < 0 || y < 0) {
					color = 2;
				} else {
					color = map[x][y];
				}
				switch (color) {
				case 0:
					white(x,y);
					break;
				case 1:
					red(x,y);
					break;
				case 2:
					if (dir == E)
						dir = W;
					else if (dir == W)
						dir = E;
					else if (dir == N)
						dir = S;
					else if (dir == S)
						dir = N;
					resultArr = moveDir(dir, kInfo[i][0], kInfo[i][1]);
					x = resultArr[0];
					y = resultArr[1];
					if (x >= n || y >= n || x < 0 || y < 0 || map[x][y] == 2) {
						for (int index = list.size() - 1; index >= 0; index--) {
							int piece = list.get(index);
							moveMap[kInfo[i][0]][kInfo[i][1]].push(piece);
						}
					} else if (map[x][y] == 1) {
						red(x,y);
					} else {
						white(x,y);
					}
					kInfo[i][2] = dir;
					break;

				}
				// 4개가 모이면 종료
				if (moveMap[kInfo[i][0]][kInfo[i][1]].size() >= 4) {
					break outer;
				}
			}

			trun++;

		}
		System.out.println(trun);

	}

	static void white(int x, int y) {
		for (int index = list.size() - 1; index >= 0; index--) {
			int piece = list.get(index);
			moveMap[x][y].push(piece);
			kInfo[piece][0] = x;
			kInfo[piece][1] = y;
		}
	}

	static void red(int x,int y) {
		for (int index = 0; index < list.size(); index++) {
			int piece = list.get(index);
			moveMap[x][y].push(piece);
			kInfo[piece][0] = x;
			kInfo[piece][1] = y;
		}
	}


	static int[] moveDir(int dir, int x, int y) {

		switch (dir) {
		case E:
			y++;
			break;
		case W:
			y--;
			break;
		case N:
			x--;
			break;
		case S:
			x++;
			break;
		}
		int[] resultArr = { x, y };
		return resultArr;
	}

}
