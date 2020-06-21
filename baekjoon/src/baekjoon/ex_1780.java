package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1780 {
	static int map[][];
	static int c1;
	static int c2;
	static int c3;
	public static void main(String[] args) throws IOException {
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
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
	static int check(int row,int col,int n){
		int std=map[row][col];
		for(int i=row;i<row+n;i++){
			for(int j=col;j<col+n;j++){
				if(std != map[i][j]){
					return 2;
				}
			}
		}
		if(std==-1)return -1;
		if(std==0)return 0;
		if(std==1)return 1;
		return 2;
	}
	
	static void divide(int row,int col,int n){
		if(check(row,col,n)==-1) c1++;
		else if(check(row,col,n)==0) c2++;
		else if(check(row,col,n)==1) c3++;
		else{
			int s = n/3;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					divide(row+i*s,col+j*s,s);
				}
			}
		}
	}

}
