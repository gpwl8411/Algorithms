package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_17144 {
	static int r, c;
	static int[][] arr;
	static int[][] copy;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// 삼성 sw역량ㅌ스트 미세먼지 안녕!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[][] cleaner = new int[2][2];
		int index=0;
		arr = new int[r][c];
		copy = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) {
					cleaner[index][0]=i;
					cleaner[index++][1]=j;
				}
			}
		}

		for (int time = 0; time < t; time++) {
			for(int i=0;i<r;i++)
				Arrays.fill(copy[i], 0);
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] > 0) {
						spread(i,j);
					}
				}

			}
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					arr[i][j] += copy[i][j];
				}
			}
			for(int i=0;i<r;i++)
				Arrays.fill(copy[i], 0);
			clean(cleaner);
			cleanerCopy(cleaner);

		}
		System.out.println(getSum());
	}

	static int getSum() {
		int sum=0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j]>0) 
					sum+=arr[i][j];
			}
		}
		return sum;
	}
	//공기 청정기 후 결과 copy
	static void cleanerCopy(int[][] cleaner) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || i == r - 1  || j == cleaner[0][1] || j == c - 1 || i == cleaner[0][0] || i == cleaner[1][0]) {
                    arr[i][j] = copy[i][j];
                }
            }
        }
        arr[cleaner[0][0]][cleaner[0][1]] = -1;
        arr[cleaner[1][0]][cleaner[1][1]] = -1;
        arr[cleaner[0][0]][cleaner[0][1]+1] = 0;
        arr[cleaner[1][0]][cleaner[1][1]+1] = 0;
    }
	//공기청정기 수행
	static void clean(int[][] cleaner) {
		 for (int idx = 0; idx < 2; idx++) {
	            int ny = cleaner[idx][0];
	            int nx = cleaner[idx][1];
	            //동
	            while (nx < c - 1) {
	                copy[ny][nx + 1] = arr[ny][nx];
	                nx++;
	            }
	            //북,남
	            if (idx == 0) {
	                while (ny > 0) {
	                	copy[ny - 1][nx] = arr[ny][nx];
	                    ny--;
	                }
	            } else {
	                while (ny < r - 1) {
	                	copy[ny + 1][nx] = arr[ny][nx];
	                    ny++;
	                }
	            }
	            //서
	            while (nx > 0) {
	            	copy[ny][nx - 1] = arr[ny][nx];
	                nx--;
	            }
	            //공기청정기로 들어가는
	            if (idx == 0) {
	                while (ny < cleaner[idx][0] - 1) {
	                	copy[ny + 1][nx] = arr[ny][nx];
	                    ny++;
	                }
	            } else {
	                while (ny > cleaner[idx][0] + 1) {
	                	copy[ny - 1][nx] = arr[ny][nx];
	                    ny--;
	                }
	            }
	        }

	}
	//미세먼지 확산
	static void spread(int x,int y) {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int num = arr[x][y]/5;
		int cnt=0;
		for (int i = 0; i < 4; i++) {
			int sx = x+dx[i];
			int sy = y+dy[i];
			
			if(sx <0 || sy < 0 || sx >= r || sy >=c )
				continue;
			if(arr[sx][sy]==-1)
				continue;
			copy[sx][sy] += num;
			cnt++;
		}
		arr[x][y] = arr[x][y]-num*cnt;
	}
}
