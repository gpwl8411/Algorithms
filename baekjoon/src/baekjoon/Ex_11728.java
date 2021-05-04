package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex_11728 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//투 포인터 배열 합치기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int p1=0;
		int p2=0;
		StringBuilder sb = new StringBuilder();
		
		while(p1 < n && p2 < m) {
			if(arr1[p1] < arr2[p2]) {
				sb.append(arr1[p1]+" ");
				p1++;
			}else if(arr1[p1] > arr2[p2]) {
				sb.append(arr2[p2]+" ");
				p2++;
			}else {
				sb.append(arr1[p1]+" "+arr2[p2]+" ");
				p1++;
				p2++;
			}
		}
		for(int i=p1;i<n;i++) {
			sb.append(arr1[i]+" ");
		}
		for(int i=p2;i<m;i++) {
			sb.append(arr2[i]+" ");
		}
		System.out.println(sb);
	}
}