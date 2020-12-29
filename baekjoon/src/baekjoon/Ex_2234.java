package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_2234 {

	static int[][] arr;
	static int[][] group;
	static Map<Integer, Integer> map;
	static int removeWallSize;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// bfs 성곽
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		group = new int[m][n];
		map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int groupCnt = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (group[i][j] == 0) {
					int cnt = bfs(i, j, groupCnt);
					max = Math.max(max, cnt);
					map.put(groupCnt, cnt);
					groupCnt++;					
				}
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				removeWall(i,j);
			}
		}
		System.out.println(map.size());//방개수
		System.out.println(max);//가장 넓은 방
		System.out.println(removeWallSize);//하나의 벽 제거하여 얻는 가장 넓은 방
	}

	static String getBit(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(String.valueOf(n % 2));
			n /= 2;
		}
		while (sb.length() < 4) {
			sb.append("0");
		}
		return sb.reverse().toString();
	}

	static void removeWall(int x, int y) {
		int sum = map.get(group[x][y]);
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		
		String bit = getBit(arr[x][y]);
		
		for (int i = 0; i < 4; i++) {
			
			int sx = x+dx[i];
			int sy = y+dy[i];
			
			if(sx < 0 || sy < 0|| sx >= arr.length || sy >= arr[0].length)
				continue;
			if (bit.charAt(i) == '1' && group[x][y]!=group[sx][sy]) {
				sum+=map.get(group[sx][sy]);
				removeWallSize = Math.max(removeWallSize, sum);
				sum-=map.get(group[sx][sy]);
			}
				
		}
		
	}
	static int bfs(int x, int y, int groupCnt) {
		int cnt = 1;
		Queue<Room> q = new LinkedList<>();
		q.add(new Room(x, y));
		group[x][y]=groupCnt;
		
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		while (!q.isEmpty()) {

			Room r = q.poll();
			String bit = getBit(arr[r.x][r.y]);
			
			for (int i = 0; i < 4; i++) {
				int sx = r.x+dx[i];
				int sy = r.y+dy[i];
				
				if (bit.charAt(i) == '1') 
					continue;
				if(group[sx][sy]==0) {
					group[sx][sy]= groupCnt;
					cnt++;
					q.add(new Room(sx,sy));
				}
				
			}
		}

		return cnt;
	}
}

class Room {
	int x;
	int y;

	Room(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
