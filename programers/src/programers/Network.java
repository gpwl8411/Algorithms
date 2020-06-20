package programers;

public class Network {

	static boolean[] visited;
	static int n;

	public static void main(String[] args) {

		n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		int answer=0;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visited[i] == false){
				dfs(i, computers);
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void dfs(int node, int[][] computers) {
		for(int i=0;i<n;i++){
			if(visited[i]==false && computers[node][i]==1){
				visited[i] = true;
				dfs(i,computers);
			}
		}
	}

}
