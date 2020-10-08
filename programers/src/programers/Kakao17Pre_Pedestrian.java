package programers;

public class Kakao17Pre_Pedestrian {

	public static void main(String[] args) {

		//2017카카오예선 보행자 천국
		int mod = 20170805;
		int m=3; 
		int n=6; 
		int[][] cityMap={{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
	
		int[][][] dp = new int[m+1][n+1][2];
		
		//0 아래쪽 방향 1 오른쪽 방향
		dp[1][1][0] = 1;
		dp[1][1][1] = 1;
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(cityMap[i-1][j-1]==0) {
					dp[i][j][0] += (dp[i-1][j][0] + dp[i][j-1][1])%mod;
					dp[i][j][1] += (dp[i-1][j][0] + dp[i][j-1][1])%mod;
				}
				else if(cityMap[i-1][j-1]==2) {
					dp[i][j][0] = dp[i-1][j][0];
					dp[i][j][1] = dp[i][j-1][1];
				}else {
					dp[i][j][0]=0;
					dp[i][j][1]=0;
				}
			}
		}
		System.out.println(dp[m][n][0]);
		
	
	}

}
