package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ex_1931 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		 int[][] meeting = new int[num][2];
		 //int[] finish = new int[num];
		for (int i = 0; i <num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			 meeting[i][0] = Integer.parseInt(st.nextToken());
			 meeting[i][1]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting,new Comparator<int[]>(){

			@Override
			public int compare(int[] start, int[] finish) {
				// TODO Auto-generated method stub
				if(start[1]==finish[1]){
					return Integer.compare(start[0], finish[0]);
				}
				return Integer.compare(start[1], finish[1]);
			}
			
		});
		int cnt=1;
		int pre=meeting[0][1];
		for(int i=1;i<num;i++){
			if(meeting[i][0]>=pre){
				pre=meeting[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
