package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex_1992 {
	static StringBuilder sb;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//분할정복 쿼드트리
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		divide(0,0,n);
		System.out.println(sb);
	}
	static int check(int row,int col,int n) {
		int num  = arr[row][col];
		
		for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++) {
				if(arr[i][j]!=num)
					return -1;
			}
		}
		if(num==1) return 1;
		if(num==0) return 0;
		return -1;
	}
	static void divide(int row,int col,int n) {
		if(check(row,col,n)==1) {
			sb.append("1");
		}else if(check(row,col,n)==0) {
			sb.append("0");
		}else {
			int mid = n/2;
			sb.append("(");
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					divide(row+mid*i,col+mid*j,mid);
				}
			}
			sb.append(")");
		}
	}

}
