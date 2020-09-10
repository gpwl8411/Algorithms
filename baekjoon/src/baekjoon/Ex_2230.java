package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_2230 {

	public static void main(String[] args) throws Exception{
		//수 고르기-차이가 M이상
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int s=0;
		int e=1;
		int min=Integer.MAX_VALUE;
		while(true) {
			if(e < n && s < n && arr[e]-arr[s]>=m) s++;
			else if(e >= n) break;
			else e++;
			if(e < n && s < n && arr[e]-arr[s] >= m) {
				min = Math.min(min, arr[e]-arr[s]);
			}
		}
		if(n==1) System.out.println(0);
		else System.out.println(min);
	}

}
