package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_2110 {

	public static void main(String[] args) throws Exception{

		//이분탐색 공유기 설치
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int left = 1;
		int right = arr[n-1]-arr[0];
		int max = 0;
		int distance = 0;
		
		while(left<=right) {
			int mid = (left+right)/2;
			int start = arr[0];
			int cnt=1;
			
			for(int i=1;i<n;i++) {
				distance = arr[i]-start;
				if(mid <= distance) {
					cnt++;
					start = arr[i];
				}
			}
			
			if(cnt >= c) {
				max = mid;
				left = mid +1;
			}else {
				right = mid-1;
			}

				
		}
		System.out.println(max);
	}

}
