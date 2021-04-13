package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_15656 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		// 백트래킹 N과 M (7)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(arr,new int[m],n,m,0);
		
		System.out.println(sb.toString());
	}
	static void perm(int[] arr,int[] output ,int n, int r, int depth) {
		if(depth==r) {
			for(int i=0;i<r;i++) {
				sb.append(output[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			output[depth]=arr[i];
			perm(arr,output,n,r,depth+1);
		}
	}

}
