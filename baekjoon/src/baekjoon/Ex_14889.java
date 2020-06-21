package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex_14889 {

	static int[][] map;
	static int minDiff = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++){
			arr.add(i);
			st =  new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		teamSet(arr,new boolean[n],0,n,n/2);
		System.out.println(minDiff);
		
	}
	//가능한 팀의 조합을 만들어줌.
	static void teamSet(ArrayList<Integer> arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int min = getDiff(arr,visited,n);
            if(min<minDiff)
            	minDiff = min;
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            teamSet(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
	//만들어진 팀과 선택되지 않은 사람으로 구성된 팀의 능력차를 계산
	static int getDiff(ArrayList<Integer> arr,boolean[] visited,int n){
		
		int diff=0;
		int team1Sum=0;
		int team2Sum=0;
		ArrayList<Integer> t1 = new ArrayList<>();
		ArrayList<Integer> t2 = new ArrayList<>();
		
		for(int i=0;i<arr.size();i++){
			if(visited[i]==true){
				t1.add(arr.get(i));
			}else{
				t2.add(arr.get(i));
			}
		}
		for(int i=0;i<t1.size();i++){
			for(int j=0;j<t1.size();j++){
				if(i==j)continue;
				team1Sum+=map[t1.get(i)][t1.get(j)];
				team2Sum+=map[t2.get(i)][t2.get(j)];
			}
		}
		 return Math.abs(team1Sum-team2Sum);
		
	}

}
