package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_14888 {
	static long min = 1000000000;
	static long max = -1000000000;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//부르트포스 연산자끼워넣기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		 arr = new int[n];
		int[] op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		calculator(op,new int[n-1],0,n-1,n-1);
		System.out.println(max);
		System.out.println(min);
	}

	static void calculator(int[] op,int[] output,int depth, int n, int r) {
		if(depth == r) {
			long num = arr[0];
			for(int i=0;i<arr.length-1;i++) {
				switch(output[i]) {
				case 0 : 
					num += arr[i+1];
					break;
				case 1 : 
					num -= arr[i+1];
					break;
				case 2 : 
					num *= arr[i+1];
					break;
				case 3 : 
					num /= arr[i+1];
					break;
				}
			}
			min = Math.min(min, num);
			max = Math.max(max, num);
			return;
		}
		for(int i=0;i<op.length;i++) {
			if(op[i]>0) {
				op[i]-=1;
				output[depth] = i;
				calculator(op,output,depth+1,n,r);
				op[i]+=1;
			}
		}
	}

}
