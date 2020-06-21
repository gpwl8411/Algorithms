package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ex_1932 {
	public static void main(String[] args) throws Exception{
		 Scanner input = new Scanner(System.in);
		 	int size = input.nextInt();
	      
	        int[][] g = new int[size][size];
	        int[][] sum = new int[size][size];
	        int max=0;
	        for(int i=1;i<=size;i++){
	        	for(int j=0;j<i;j++){
	        		g[i-1][j]=input.nextInt();
//	        		
	        	}
	        }
	        sum[0][0] = g[0][0];
	        for(int i=1;i<size;i++){
	        	for(int j=0;j<=i;j++){
	        		if(j==0){
	        			sum[i][j] = sum[i-1][j]+g[i][j];//오른쪽 대각선
	        		}else if(j==i){
	        			sum[i][j] += sum[i-1][j-1]+g[i][j];//왼쪽 대각선
	        		}
	        		else
	        			sum[i][j] = Math.max(sum[i-1][j-1],sum[i-1][j])+g[i][j];
	        		if(max < sum[i][j])
	        			max = sum[i][j];
	        	}
	        }
//	        for(int i=0;i<size;i++){
//	        	max = Math.max(sum[size-1][i], max);
//	        }
	        System.out.println(max);
	        
	}
	
}
