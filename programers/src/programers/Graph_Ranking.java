package programers;



public class Graph_Ranking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 그래프 순위-플로이드 와샬
		int n=5;
		int[][] results= {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		int[][] arr = new int[n+1][n+1];
		for(int i=0;i<results.length;i++) {
			int win = results[i][0];
			int lose = results[i][1];
			arr[win][lose] = 1;
			arr[lose][win] = -1;
			
		}
		for(int i=1;i<=n;i++) {//거쳐가는 노드
			for(int j=1;j<=n;j++) {//출발 노드
				for(int k=1;k<=n;k++) {//끝난 노드
					if(arr[j][i] != 0 && arr[j][i] == arr[i][k]) {
						arr[j][k] = arr[i][k];
					}
				}
			}
		}
		int answer=0;
		for(int i=1;i<=n;i++) {
			int sum=0;
			for(int j=1;j<=n;j++) {
				sum += arr[i][j]!=0 ? 1 : 0;
			}
			if(sum >= n-1)
				answer++;
		}
		System.out.println(answer);
	}

}
