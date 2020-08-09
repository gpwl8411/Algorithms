package programers;

public class WayToSchool {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };
		int[][] map = new int[n + 1][m + 1];
		for (int i = 0; i < puddles.length; i++) {
			int x = puddles[i][1];
			int y = puddles[i][0];
			map[x][y] = -1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(i==1 && j==1) {
					map[i][j]=1;
					continue;					
				}
				if (map[i][j] == -1) {
					map[i][j]=0;
					continue;
				}
				map[i][j] = map[i - 1][j]%1000000007 + map[i][j - 1]%1000000007;
			}
		}
		System.out.println(map[n][m]%1000000007);
	}

}
