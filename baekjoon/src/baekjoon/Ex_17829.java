package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex_17829 {

	static int[][] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(divide(0,0,n));
		
	}
	static int select(int row,int col,int n) {
		List<Integer> list = new ArrayList<>();
		for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++) {
				list.add(arr[i][j]);
			}
		}
		Collections.sort(list);
		
		return list.get(2);
	}
	static int divide(int row,int col,int n){
		if(n==2){
			return select(row,col,n);
		}	
		else{
			List<Integer> list = new ArrayList<>();
			int s = n/2;
			for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	               list.add(divide(row + s * i, col + s * j, s));
	            }
	        }
			Collections.sort(list);
			return list.get(2);
		}
		
	}

}
