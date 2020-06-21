package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2630 {
	static int[][] map;
	static int blue=0;
	static int white=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++){
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		divide(0,0,n);
		System.out.println(white);
		System.out.println(blue);
	}
	static int check(int row,int col,int n){
		int std = map[row][col];
		
			for (int i = row; i < row + n; i++) {
	            for (int j = col; j < col + n; j++) {
	                if (std != map[i][j]) {
	                    return -1;
	                }
	            }
	        }
			if(std==1) return 1;
			if(std==0) return 0;
			return -1;
		
        
        
	}
	static void divide(int row,int col,int n){
		if(check(row,col,n)==1){
			blue++;
		}else if(check(row,col,n)==0){
			white++;
		}
		else{
			int s = n/2;
			for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                divide(row + s * i, col + s * j, s);
	            }
	        }
		}
		
	}

}
