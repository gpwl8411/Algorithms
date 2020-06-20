package programers;


public class kakao18_block {
	// static String board[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// board = new String[4];
		String[] board = { "HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK" };
		int m = 8;
		int n = 5;
		int answer = 0;
		String[][] g = new String[m][n];
		for (int i = 0; i < m; i++) {
			g[i] = board[i].split("");
		}
		
		while (true) {
			int check=0;
			boolean visited[][] = new boolean[m][n];
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j< n-1; j++) {
					if (g[i][j]!=""&&g[i][j].charAt(0)>='A'&&g[i][j].charAt(0)<='Z') {
						System.out.println(g[i][j]);
						if (g[i][j].equals(g[i][j + 1]) && g[i][j].equals(g[i+1][j]) && g[i][j].equals(g[i+1][j + 1])) {
							visited[i][j] = true;
							visited[i][j + 1] = true;
							visited[i + 1][j] = true;
							visited[i + 1][j + 1] = true;
							check=1;
						}
					}
					
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(visited[i][j]) answer++;
					if (visited[i][j]&&g[i][j]!="") {
						int k=i;
						while(k>0 && g[k][j]!=""){
							g[k][j]=g[k-1][j];
							k--;
						}
						g[k][j]="";
						visited[k][j]=false;
					}
					
				}
			}
			if(check==0)
				break;

		}
		System.out.println(answer);

	}
}
