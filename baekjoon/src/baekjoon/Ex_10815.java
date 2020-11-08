package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_10815 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] card = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<m;i++) {
			int num = arr[i];
			int left = 0;
			int right = n-1;
			int answer = 0;
			while(left <= right) {
				int mid = (left+right)/2;
				if(num < card[mid]) {
					right = mid-1;
				}else if(num > card[mid]) {
					left = mid+1;
				}else {
					answer = 1;
					break;
				}
			}
			bw.append(answer+" ");
		}
		bw.flush();
	}

}
