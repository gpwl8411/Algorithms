package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_1806 {

	public static void main(String[] args) throws Exception {
		//부분합  s이상
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		int l=0;
		int r=0;
		int sum=0;
		int min=Integer.MAX_VALUE;
		boolean flag=false;
		while(true) {
			if(sum>=s) sum-=arr[l++];
			else if(r>= n) break;
			else sum+=arr[r++];
			if(sum>=s) {
				min = Math.min(min, r-l);
				flag=true;
			}
		}
		if(flag)
			System.out.println(min);
		else
			System.out.println(0);
		
	}

}
