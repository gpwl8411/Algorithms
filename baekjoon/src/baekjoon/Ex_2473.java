package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_2473 {

	static long[] choice = new long[3];
	static long sum=Long.MAX_VALUE;
	static long[] arr;
	static int n;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//투포인터 세 용액
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		for(int i=0;i<n-2;i++) {
			choose(i);
		}
		for(long l : choice) {
			System.out.print(l+" ");
		}
		
	}
	static void choose(int idx) {
		int start = idx+1;
		int end = n-1;

		
		while(start < end) {
			long add = arr[idx]+arr[start]+arr[end];
			long absAdd = Math.abs(add);
			
			//절대값 작아야 0에 가까운것.
			if(absAdd < sum) {
				choice[0] = arr[idx];
				choice[1] = arr[start];
				choice[2] = arr[end];
				sum = absAdd; 
			}
			if(add > 0) 
				end--;
			else
				start++;
		}
		
	}

}
