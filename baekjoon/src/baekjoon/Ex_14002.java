package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex_14002 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//dp 가장 긴 증가하는 부분수열4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int a = Integer.parseInt(br.readLine());
		int[] arr = new int[a];
		int[] dp = new int[a];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		
		int index=0;
		while(st.hasMoreTokens()) {
			arr[index] = Integer.parseInt(st.nextToken());
			dp[index] = 1;
			index++;
		}
		
		for(int i=0;i<arr.length;i++) {

			for(int j=0;j<i;j++){
				if(arr[j]<arr[i]){
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
			max = Math.max(max,dp[i]);
		}
		
		Stack<Integer> stack = new Stack<>();
		int temp = max;
		for(int i=a-1;i>=0;i--) {
			if(dp[i]==temp) {
				stack.push(arr[i]);
				temp--;
			}
		}
		System.out.println(max);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
		
	}

}
