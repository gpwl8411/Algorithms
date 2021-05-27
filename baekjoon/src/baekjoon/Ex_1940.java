package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_1940 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//투 포인터 - 주몽
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = n-1;
		int cnt = 0;
		while(left < right) {
			int sum = arr[left]+arr[right];
			if(sum==m) {
				cnt++;
				left++;
				right--;
			}
			else if(sum < m)
				left++;
			else
				right--;
		}
		System.out.println(cnt);
	}

}
