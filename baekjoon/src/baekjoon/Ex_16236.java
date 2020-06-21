package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_16236 {
	static int n;
	static int[][] map;
	static boolean flag = true;
	static boolean[][] visited;
	static int size=2;
	static int cnt;
	static int eat;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		Baby b = null;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				if (map[i][j] == 9) {
//					b = new Baby(i, j, 2);
//				}
			}
		}
		while (flag) {
			detect();
		}
		System.out.println(cnt);

	}
	//1.물고기 순서대로 list저장
	
	//2.물고기 작은거부터 거리 가까운거 위쪽인거 왼쪽인거 순으로 sort
	//-거리 확인하는 함수 
	//sort를 할경우 물고기 위치가 바뀌면 계속 바뀌어야함 right?
	
	//3.빼면서 확인
	//-물고기 사이즈 위치 저장해야함!


	// 물고기 확인
	public static void detect() {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 9)
					qx.offer(i);
					qy.offer(j);
			}
		}
		while (!qx.isEmpty()) {
			int tmpx = qx.poll();
			int tmpy = qy.poll();
			
			for (int i = 0; i < 4; i++) {
				int sx = tmpx + dx[i];
				int sy = tmpy + dy[i];

				if (sx < 0 || sx >= n || sy < 0 || sy >= n) {
					continue;
				}
				if(map[sx][sy]!=0 && visited[sx][sy]==false){
					if(map[sx][sy]<size){
						eat++;
					}
				}
				 qx.offer(sx);
				 qy.offer(sy);
				 visited[sx][sy]=true;
				 cnt++;
				 
				

			}

		}
		flag = false;

	}

	// 거리구하는

	// 거리 같으면 가장 높은거 중에 가장 왼쪽

}

class Baby {
	int x;
	int y;
	int size;

	Baby(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
}
