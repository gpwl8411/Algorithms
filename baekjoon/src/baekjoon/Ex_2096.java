package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_2096 {

	public static void main(String[] args) throws Exception{

		//내려가기 슬라이딩윈도우+DP
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] max = new int[2][3];
		int[][] min = new int[2][3];
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				max[1][j] = Integer.parseInt(st.nextToken());
				min[1][j] = max[1][j];
				
				max[1][j] += Math.max(max[0][1],j==1 ? Math.max(max[0][0],max[0][2]):max[0][j]);
				min[1][j] += Math.min(min[0][1],j==1 ? Math.min(min[0][0],min[0][2]):min[0][j]);
			}
			System.arraycopy(max[1], 0,max[0] , 0, 3);
			System.arraycopy(min[1], 0,min[0] , 0, 3);
		}
		Arrays.sort(max[0]);
		Arrays.sort(min[0]);
		System.out.println(max[0][2]+" "+min[0][0]);
	}

}
